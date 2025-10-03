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
import com.base.admin.hrm.dto.DesignationsDTO;
import com.base.admin.hrm.dto.DesignationsSearchDTO;
import com.base.admin.hrm.entity.Contracts;
import com.base.admin.hrm.entity.Designations;
import com.base.admin.hrm.service.DesignationsService;
import com.base.admin.hrm.service.EmployeesService;
import com.base.admin.utils.ClassUtils;

@RequestMapping("/api/v1/hrm/designation")
@RestController
public class DesignationController {
    private final DesignationsService designationsService;
    private final EmployeesService employeesService;

    public DesignationController(DesignationsService designationsService, EmployeesService employeesService) {
        this.designationsService = designationsService;
        this.employeesService = employeesService;
    }

    @PostMapping("/findById")
    public ResponseEntity<Object> findById(@RequestParam(name = "designationid", required = true) UUID designationid) {
        DesignationsDTO designation = designationsService.findById(designationid);
        if (designation == null) {
            return ResponseHandler.generateResponseError("Designation not found", HttpStatus.NOT_FOUND);
        }
        return ResponseHandler.generateResponseSuccess("", designation);
    }

    @PostMapping(value = "/search")
    public ResponseEntity<Object> search(
            @RequestBody DesignationsSearchDTO designationsSearchDTO,
            @RequestParam(required = false, defaultValue = "false") boolean exact) {
        Pagination pagination = designationsSearchDTO.getPagination();
        List<String> listFields = ClassUtils.getAllPropertyNames(Contracts.class);

        if (!pagination.isValidSortField(listFields)) {
            return ResponseHandler.generateResponseError(
                    "sortFiels invalid. In list: " + StringUtils.join(listFields, ','), HttpStatus.BAD_REQUEST);
        }
        Pageable pageable = pagination.convertToPageable();
        Page<DesignationsDTO> paged = designationsService.searchPaged(designationsSearchDTO.getDto(), pageable, exact);
        PagedResponse<DesignationsDTO> response = new PagedResponse<>(
                paged.getContent(),
                paged.getNumber(),
                paged.getSize(),
                paged.getTotalElements(),
                paged.getTotalPages(),
                paged.isLast());
        return ResponseHandler.generateResponseSuccess("", response);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody @Validated Designations designations) {
        // validate parameters
        if (StringUtils.isEmpty(designations.getDesignatenumber())) {
            return ResponseHandler.generateResponseError(
                    "Invalid parameters. Designation Number not null", HttpStatus.BAD_REQUEST);
        }
        if (designations.getEmployeeid() != null && !employeesService.existsById(designations.getEmployeeid())) {
            return ResponseHandler.generateResponseError("Employee not exists", HttpStatus.BAD_REQUEST);
        }
        ////////////////////////////////
        int count = designationsService.insert(designations);
        if (count == 0) {
            return ResponseHandler.generateResponseError("Save Contract fail", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseHandler.generateResponseSuccess("Suessfully created", null);
    }

    @PostMapping("/update")
    public ResponseEntity<Object> update(@RequestBody @Validated Designations designations) {
        JSONObject jsonObject = ClassUtils.newJSONObject(designations);
        // validate parameters
        if (StringUtils.isEmpty(designations.getDesignatenumber())) {
            return ResponseHandler.generateResponseError(
                    "Invalid parameters. Designation Number not null", HttpStatus.BAD_REQUEST);
        }
        if (designations.getDesignateid() == null || !designationsService.existsById(designations.getDesignateid())) {
            return ResponseHandler.generateResponseError(
                    "Invalid parameters. Designation Id not null", HttpStatus.BAD_REQUEST);
        }

        if (jsonObject != null
                && ClassUtils.existsParameter(jsonObject, "employeeid")
                && designations.getEmployeeid() != null
                && !employeesService.existsById(designations.getEmployeeid())) {
            return ResponseHandler.generateResponseError("Employee not exists", HttpStatus.BAD_REQUEST);
        }
        ////////////////////////////////
        int count = designationsService.udpate(designations);
        if (count == 0) {
            return ResponseHandler.generateResponseError("Save Contract fail", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseHandler.generateResponseSuccess("Suessfully updated", null);
    }

    @PostMapping("/delete")
    public ResponseEntity<Object> delete(@RequestParam(name = "designateid", required = true) UUID designateid) {
        if (designationsService.deleteByPrimaryKey(designateid) == 0) {
            return ResponseHandler.generateResponseError("Designation ID not found", HttpStatus.NOT_FOUND);
        }
        return ResponseHandler.generateResponseSuccess("Suessfully deleted", null);
    }

    @PostMapping("/deleteByIds")
    public ResponseEntity<Object> deleteByIds(@RequestBody List<UUID> listDesignateids) {
        if (designationsService.deleteByPrimaryKeys(listDesignateids) == 0) {
            return ResponseHandler.generateResponseError("Designation ID not found", HttpStatus.NOT_FOUND);
        }
        return ResponseHandler.generateResponseSuccess("Suessfully deleted", null);
    }
}
