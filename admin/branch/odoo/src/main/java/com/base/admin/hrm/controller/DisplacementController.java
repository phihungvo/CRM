package com.base.admin.hrm.controller;

import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.base.admin.dto.PagedResponse;
import com.base.admin.dto.Pagination;
import com.base.admin.handler.ResponseHandler;
import com.base.admin.hrm.dto.DisplacementsDTO;
import com.base.admin.hrm.dto.DisplacementsSearchDTO;
import com.base.admin.hrm.entity.Contracts;
import com.base.admin.hrm.entity.Displacements;
import com.base.admin.hrm.service.DisplacementsService;
import com.base.admin.hrm.service.EmployeesService;
import com.base.admin.utils.ClassUtils;

@RequestMapping("/api/v1/hrm/displacement")
@RestController
public class DisplacementController {
    private final DisplacementsService displacementsService;
    private final EmployeesService employeesService;

    public DisplacementController(DisplacementsService displacementsService, EmployeesService employeesService) {
        this.displacementsService = displacementsService;
        this.employeesService = employeesService;
    }

    @PostMapping("/findById")
    public ResponseEntity<Object> findById(
            @RequestParam(name = "displacementid", required = true) UUID displacementid) {
        DisplacementsDTO displacement = displacementsService.findById(displacementid);
        if (displacement == null) {
            return ResponseHandler.generateResponseError("Displacement not found", HttpStatus.NOT_FOUND);
        }
        return ResponseHandler.generateResponseSuccess("", displacement);
    }

    @PostMapping(value = "/search")
    public ResponseEntity<Object> search(
            @RequestBody DisplacementsSearchDTO displacementsSearchDTO,
            @RequestParam(required = false, defaultValue = "false") boolean exact) {
        Pagination pagination = displacementsSearchDTO.getPagination();
        List<String> listFields = ClassUtils.getAllPropertyNames(Contracts.class);

        if (!pagination.isValidSortField(listFields)) {
            return ResponseHandler.generateResponseError(
                    "sortFiels invalid. In list: " + StringUtils.join(listFields, ','), HttpStatus.BAD_REQUEST);
        }
        Pageable pageable = pagination.convertToPageable();
        Page<DisplacementsDTO> paged =
                displacementsService.searchPaged(displacementsSearchDTO.getDto(), pageable, exact);
        PagedResponse<DisplacementsDTO> response = new PagedResponse<>(
                paged.getContent(),
                paged.getNumber(),
                paged.getSize(),
                paged.getTotalElements(),
                paged.getTotalPages(),
                paged.isLast());
        return ResponseHandler.generateResponseSuccess("", response);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody @Validated Displacements displacements) {
        // validate parameters
        if (StringUtils.isEmpty(displacements.getDisplacementnumber())) {
            return ResponseHandler.generateResponseError(
                    "Invalid parameters. Displacement Number not null", HttpStatus.BAD_REQUEST);
        }
        if (displacements.getEmployeeid() != null && !employeesService.existsById(displacements.getEmployeeid())) {
            return ResponseHandler.generateResponseError("Employee not exists", HttpStatus.BAD_REQUEST);
        }
        ////////////////////////////////
        int count = displacementsService.insert(displacements);
        if (count == 0) {
            return ResponseHandler.generateResponseError("Save Displacement fail", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseHandler.generateResponseSuccess("Suessfully created", null);
    }

    @PostMapping("/update")
    public ResponseEntity<Object> update(@RequestBody @Validated Displacements displacements) {
        JSONObject jsonObject = ClassUtils.newJSONObject(displacements);
        // validate parameters
        if (StringUtils.isEmpty(displacements.getDisplacementnumber())) {
            return ResponseHandler.generateResponseError(
                    "Invalid parameters. Dismision Number not null", HttpStatus.BAD_REQUEST);
        }
        if (displacements.getDisplacementid() == null
                || !displacementsService.existsById(displacements.getDisplacementid())) {
            return ResponseHandler.generateResponseError(
                    "Invalid parameters. Dismision Id not null", HttpStatus.BAD_REQUEST);
        }

        if (jsonObject != null
                && ClassUtils.existsParameter(jsonObject, "employeeid")
                && displacements.getEmployeeid() != null
                && !employeesService.existsById(displacements.getEmployeeid())) {
            return ResponseHandler.generateResponseError("Employee not exists", HttpStatus.BAD_REQUEST);
        }
        ////////////////////////////////
        int count = displacementsService.udpate(displacements);
        if (count == 0) {
            return ResponseHandler.generateResponseError("Save Contract fail", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseHandler.generateResponseSuccess("Suessfully updated", null);
    }

    @PostMapping("/delete")
    public ResponseEntity<Object> delete(@RequestParam(name = "designateid", required = true) UUID designateid) {
        if (displacementsService.deleteByPrimaryKey(designateid) == 0) {
            return ResponseHandler.generateResponseError("Designation ID not found", HttpStatus.NOT_FOUND);
        }
        return ResponseHandler.generateResponseSuccess("Suessfully deleted", null);
    }

    @PostMapping("/deleteByIds")
    public ResponseEntity<Object> deleteByIds(@RequestBody List<UUID> listDisplacementids) {
        if (displacementsService.deleteByPrimaryKeys(listDisplacementids) == 0) {
            return ResponseHandler.generateResponseError("Displacement ID not found", HttpStatus.NOT_FOUND);
        }
        return ResponseHandler.generateResponseSuccess("Suessfully deleted", null);
    }
}
