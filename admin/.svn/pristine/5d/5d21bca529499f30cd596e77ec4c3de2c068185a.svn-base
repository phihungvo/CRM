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
import com.base.admin.hrm.dto.TerminationsDTO;
import com.base.admin.hrm.dto.TerminationsSearchDTO;
import com.base.admin.hrm.entity.Contracts;
import com.base.admin.hrm.entity.Terminations;
import com.base.admin.hrm.service.EmployeesService;
import com.base.admin.hrm.service.TerminationsService;
import com.base.admin.utils.ClassUtils;

@RequestMapping("/api/v1/hrm/termination")
@RestController
public class TerminationController {
    private final TerminationsService terminationsService;
    private final EmployeesService employeesService;

    public TerminationController(TerminationsService terminationsService, EmployeesService employeesService) {
        this.terminationsService = terminationsService;
        this.employeesService = employeesService;
    }

    @PostMapping("/findById")
    public ResponseEntity<Object> findById(@RequestParam(name = "terminationid", required = true) UUID terminationid) {
        TerminationsDTO termination = terminationsService.findById(terminationid);
        if (termination == null) {
            return ResponseHandler.generateResponseError("Termination not found", HttpStatus.NOT_FOUND);
        }
        return ResponseHandler.generateResponseSuccess("", termination);
    }

    @PostMapping(value = "/search")
    public ResponseEntity<Object> search(
            @RequestBody TerminationsSearchDTO terminationsSearchDTO,
            @RequestParam(required = false, defaultValue = "false") boolean exact) {
        Pagination pagination = terminationsSearchDTO.getPagination();
        List<String> listFields = ClassUtils.getAllPropertyNames(Contracts.class);

        if (!pagination.isValidSortField(listFields)) {
            return ResponseHandler.generateResponseError(
                    "sortFiels invalid. In list: " + StringUtils.join(listFields, ','), HttpStatus.BAD_REQUEST);
        }
        Pageable pageable = pagination.convertToPageable();
        Page<TerminationsDTO> paged = terminationsService.searchPaged(terminationsSearchDTO.getDto(), pageable, exact);
        PagedResponse<TerminationsDTO> response = new PagedResponse<>(
                paged.getContent(),
                paged.getNumber(),
                paged.getSize(),
                paged.getTotalElements(),
                paged.getTotalPages(),
                paged.isLast());
        return ResponseHandler.generateResponseSuccess("", response);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody @Validated Terminations terminations) {
        // validate parameters
        if (StringUtils.isEmpty(terminations.getTerminationnumber())) {
            return ResponseHandler.generateResponseError(
                    "Invalid parameters.Termination Number not null", HttpStatus.BAD_REQUEST);
        }
        if (terminations.getEmployeeid() != null && !employeesService.existsById(terminations.getEmployeeid())) {
            return ResponseHandler.generateResponseError("Employee not exists", HttpStatus.BAD_REQUEST);
        }
        ////////////////////////////////
        int count = terminationsService.insert(terminations);
        if (count == 0) {
            return ResponseHandler.generateResponseError("Save Termination fail", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseHandler.generateResponseSuccess("Suessfully created", null);
    }

    @PostMapping("/update")
    public ResponseEntity<Object> update(@RequestBody @Validated Terminations terminations) {
        JSONObject jsonObject = ClassUtils.newJSONObject(terminations);
        // validate parameters
        if (StringUtils.isEmpty(terminations.getTerminationnumber())) {
            return ResponseHandler.generateResponseError(
                    "Invalid parameters. Termination Number not null", HttpStatus.BAD_REQUEST);
        }
        if (terminations.getTerminationid() == null
                || !terminationsService.existsById(terminations.getTerminationid())) {
            return ResponseHandler.generateResponseError(
                    "Invalid parameters. Termination Id not null", HttpStatus.BAD_REQUEST);
        }

        if (jsonObject != null
                && ClassUtils.existsParameter(jsonObject, "employeeid")
                && terminations.getEmployeeid() != null
                && !employeesService.existsById(terminations.getEmployeeid())) {
            return ResponseHandler.generateResponseError("Employee not exists", HttpStatus.BAD_REQUEST);
        }
        ////////////////////////////////
        int count = terminationsService.udpate(terminations);
        if (count == 0) {
            return ResponseHandler.generateResponseError("Save Contract fail", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseHandler.generateResponseSuccess("Suessfully updated", null);
    }

    @PostMapping("/delete")
    public ResponseEntity<Object> delete(@RequestParam(name = "designateid", required = true) UUID designateid) {
        if (terminationsService.deleteByPrimaryKey(designateid) == 0) {
            return ResponseHandler.generateResponseError("Designation ID not found", HttpStatus.NOT_FOUND);
        }
        return ResponseHandler.generateResponseSuccess("Suessfully deleted", null);
    }

    @PostMapping("/deleteByIds")
    public ResponseEntity<Object> deleteByIds(@RequestBody List<UUID> listTerminationids) {
        if (terminationsService.deleteByPrimaryKeys(listTerminationids) == 0) {
            return ResponseHandler.generateResponseError("Designation ID not found", HttpStatus.NOT_FOUND);
        }
        return ResponseHandler.generateResponseSuccess("Suessfully deleted", null);
    }
}
