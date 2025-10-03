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
import com.base.admin.hrm.dto.DismissionsDTO;
import com.base.admin.hrm.dto.DismissionsSearchDTO;
import com.base.admin.hrm.entity.Contracts;
import com.base.admin.hrm.entity.Dismissions;
import com.base.admin.hrm.service.DismissionsService;
import com.base.admin.hrm.service.EmployeesService;
import com.base.admin.utils.ClassUtils;

@RequestMapping("/api/v1/hrm/dismission")
@RestController
public class DismissionController {
    private final DismissionsService dismissionsService;
    private final EmployeesService employeesService;

    public DismissionController(DismissionsService dismissionsService, EmployeesService employeesService) {
        this.dismissionsService = dismissionsService;
        this.employeesService = employeesService;
    }

    @PostMapping("/findById")
    public ResponseEntity<Object> findById(@RequestParam(name = "dismissionid", required = true) UUID dismissionid) {
        DismissionsDTO dismission = dismissionsService.findById(dismissionid);
        if (dismission == null) {
            return ResponseHandler.generateResponseError("Dismission not found", HttpStatus.NOT_FOUND);
        }
        return ResponseHandler.generateResponseSuccess("", dismission);
    }

    @PostMapping(value = "/search")
    public ResponseEntity<Object> search(
            @RequestBody DismissionsSearchDTO dismissionsSearchDTO,
            @RequestParam(required = false, defaultValue = "false") boolean exact) {
        Pagination pagination = dismissionsSearchDTO.getPagination();
        List<String> listFields = ClassUtils.getAllPropertyNames(Contracts.class);

        if (!pagination.isValidSortField(listFields)) {
            return ResponseHandler.generateResponseError(
                    "sortFiels invalid. In list: " + StringUtils.join(listFields, ','), HttpStatus.BAD_REQUEST);
        }
        Pageable pageable = pagination.convertToPageable();
        Page<DismissionsDTO> paged = dismissionsService.searchPaged(dismissionsSearchDTO.getDto(), pageable, exact);
        PagedResponse<DismissionsDTO> response = new PagedResponse<>(
                paged.getContent(),
                paged.getNumber(),
                paged.getSize(),
                paged.getTotalElements(),
                paged.getTotalPages(),
                paged.isLast());
        return ResponseHandler.generateResponseSuccess("", response);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody @Validated Dismissions dismissions) {
        // validate parameters
        if (StringUtils.isEmpty(dismissions.getDismissionnumber())) {
            return ResponseHandler.generateResponseError(
                    "Invalid parameters. Dismision Number not null", HttpStatus.BAD_REQUEST);
        }
        if (dismissions.getEmployeeid() != null && !employeesService.existsById(dismissions.getEmployeeid())) {
            return ResponseHandler.generateResponseError("Employee not exists", HttpStatus.BAD_REQUEST);
        }
        ////////////////////////////////
        int count = dismissionsService.insert(dismissions);
        if (count == 0) {
            return ResponseHandler.generateResponseError("Save Contract fail", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseHandler.generateResponseSuccess("Suessfully created", null);
    }

    @PostMapping("/update")
    public ResponseEntity<Object> update(@RequestBody @Validated Dismissions dismissions) {
        JSONObject jsonObject = ClassUtils.newJSONObject(dismissions);
        // validate parameters
        if (StringUtils.isEmpty(dismissions.getDismissionnumber())) {
            return ResponseHandler.generateResponseError(
                    "Invalid parameters. Dismision Number not null", HttpStatus.BAD_REQUEST);
        }
        if (dismissions.getDismissionid() == null || !dismissionsService.existsById(dismissions.getDismissionid())) {
            return ResponseHandler.generateResponseError(
                    "Invalid parameters. Dismision Id not null", HttpStatus.BAD_REQUEST);
        }

        if (jsonObject != null
                && ClassUtils.existsParameter(jsonObject, "employeeid")
                && dismissions.getEmployeeid() != null
                && !employeesService.existsById(dismissions.getEmployeeid())) {
            return ResponseHandler.generateResponseError("Employee not exists", HttpStatus.BAD_REQUEST);
        }
        ////////////////////////////////
        int count = dismissionsService.udpate(dismissions);
        if (count == 0) {
            return ResponseHandler.generateResponseError("Save Contract fail", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseHandler.generateResponseSuccess("Suessfully updated", null);
    }

    @PostMapping("/delete")
    public ResponseEntity<Object> delete(@RequestParam(name = "designateid", required = true) UUID designateid) {
        if (dismissionsService.deleteByPrimaryKey(designateid) == 0) {
            return ResponseHandler.generateResponseError("Designation ID not found", HttpStatus.NOT_FOUND);
        }
        return ResponseHandler.generateResponseSuccess("Suessfully deleted", null);
    }

    @PostMapping("/deleteByIds")
    public ResponseEntity<Object> deleteByIds(@RequestBody List<UUID> listDismissionids) {
        if (dismissionsService.deleteByPrimaryKeys(listDismissionids) == 0) {
            return ResponseHandler.generateResponseError("Dismission ID not found", HttpStatus.NOT_FOUND);
        }
        return ResponseHandler.generateResponseSuccess("Suessfully deleted", null);
    }
}
