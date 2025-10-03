package com.base.admin.hrm.controller;

import com.base.admin.dto.PagedResponse;
import com.base.admin.dto.Pagination;
import com.base.admin.handler.ResponseHandler;
import com.base.admin.hrm.dto.AccomplishmentsDTO;
import com.base.admin.hrm.dto.AccomplishmentsSearchDTO;
import com.base.admin.hrm.entity.Accomplishments;
import com.base.admin.hrm.entity.Contracts;
import com.base.admin.hrm.service.AccomplishmentsService;
import com.base.admin.hrm.service.EmployeesService;
import com.base.admin.utils.ClassUtils;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v1/hrm/accomplishment")
@RestController
public class AccomplishmentController {

    private final AccomplishmentsService accomplishmentsService;
    private final EmployeesService employeesService;

    public AccomplishmentController(AccomplishmentsService accomplishmentsService, EmployeesService employeesService) {
        this.accomplishmentsService = accomplishmentsService;
        this.employeesService = employeesService;
    }

    @PostMapping("/findById")
    public ResponseEntity<Object> findById(@RequestParam(name = "accomplishmentid", required = true) UUID accomplishmentid) {
        AccomplishmentsDTO accomplishment = accomplishmentsService.findById(accomplishmentid);
        if (accomplishment == null) {
            return ResponseHandler.generateResponseError("Accomplishment not found", HttpStatus.NOT_FOUND);
        }
        return ResponseHandler.generateResponseSuccess("", accomplishment);
    }

    @PostMapping(value = "/search")
    public ResponseEntity<Object> search(@RequestBody AccomplishmentsSearchDTO accomplishmentsSearchDTO, @RequestParam(required = false, defaultValue = "false") boolean exact) {
        Pagination pagination = accomplishmentsSearchDTO.getPagination();
        List<String> listFields = ClassUtils.getAllPropertyNames(Contracts.class);

        if (!pagination.isValidSortField(listFields)) {
            return ResponseHandler.generateResponseError("sortFiels invalid. In list: " + StringUtils.join(listFields, ','), HttpStatus.BAD_REQUEST);
        }
        Pageable pageable = pagination.convertToPageable();
        Page<AccomplishmentsDTO> paged = accomplishmentsService.searchPaged(accomplishmentsSearchDTO.getDto(), pageable, exact);
        PagedResponse<AccomplishmentsDTO> response = new PagedResponse<>(paged.getContent(), paged.getNumber(), paged.getSize(), paged.getTotalElements(), paged.getTotalPages(), paged.isLast());
        return ResponseHandler.generateResponseSuccess("", response);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody @Validated Accomplishments accomplishment) {
        //validate parameters
        if (StringUtils.isEmpty(accomplishment.getAccomplishmentnumber()) || StringUtils.isEmpty(accomplishment.getAccomplishmentname())) {
            return ResponseHandler.generateResponseError("Invalid parameters. Accomplishments Number/name not null", HttpStatus.BAD_REQUEST);
        }
        if (accomplishment.getAccomplishmentapproverid() != null && !employeesService.existsById(accomplishment.getAccomplishmentapproverid())) {
            return ResponseHandler.generateResponseError("Employee not exists", HttpStatus.BAD_REQUEST);
        }
        ////////////////////////////////
        int count = accomplishmentsService.insert(accomplishment);
        if (count == 0) {
            return ResponseHandler.generateResponseError("Save Accomplishments fail", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseHandler.generateResponseSuccess("Suessfully created", null);

    }

    @PostMapping("/update")
    public ResponseEntity<Object> update(@RequestBody @Validated Accomplishments accomplishment) {
        JSONObject jsonObject = ClassUtils.newJSONObject(accomplishment);
        //validate parameters
        if (accomplishment.getAccomplishmentid() == null) {
            return ResponseHandler.generateResponseError("Invalid parameters. Accomplishments id not null", HttpStatus.BAD_REQUEST);
        }
        if (jsonObject != null && ClassUtils.existsParameter(jsonObject, "accomplishmentapproverid") && !employeesService.existsById(accomplishment.getAccomplishmentapproverid())) {
            return ResponseHandler.generateResponseError("Employee not exists", HttpStatus.BAD_REQUEST);
        }
        ////////////////////////////////
        int count = accomplishmentsService.udpate(accomplishment);
        if (count == 0) {
            return ResponseHandler.generateResponseError("Save Accomplishments fail", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseHandler.generateResponseSuccess("Suessfully updated", null);

    }

    @PostMapping("/delete")
    public ResponseEntity<Object> delete(@RequestParam(name = "accomplishmentid", required = true) UUID accomplishmentid) {
        if (accomplishmentsService.deleteById(accomplishmentid) == 0) {
            return ResponseHandler.generateResponseError("Accomplishments not found", HttpStatus.NOT_FOUND);
        }
        return ResponseHandler.generateResponseSuccess("Suessfully deleted", null);
    }
}
