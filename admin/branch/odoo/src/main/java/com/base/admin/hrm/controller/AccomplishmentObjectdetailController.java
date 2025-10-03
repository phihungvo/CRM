package com.base.admin.hrm.controller;

import java.util.List;

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
import com.base.admin.hrm.dto.AccomplishmentObjectdetailDTO;
import com.base.admin.hrm.dto.TextRequestDTO;
import com.base.admin.hrm.entity.AccomplishmentObjectdetail;
import com.base.admin.hrm.service.AccomplishmentObjectdetailService;
import com.base.admin.utils.ClassUtils;

@RequestMapping("/api/v1/hrm/accomplishmentobjectdetail")
@RestController
public class AccomplishmentObjectdetailController {
    private final AccomplishmentObjectdetailService accomplishmentObjectdetailService;

    public AccomplishmentObjectdetailController(AccomplishmentObjectdetailService accomplishmentObjectdetailService) {
        this.accomplishmentObjectdetailService = accomplishmentObjectdetailService;
    }

    @PostMapping("/findById")
    public ResponseEntity<Object> findById(
            @RequestParam(name = "accomplishmentobjectdetailid") Integer accomplishmentobjectdetailid) {
        AccomplishmentObjectdetailDTO accomplishmentObjectdetail =
                accomplishmentObjectdetailService.findById(accomplishmentobjectdetailid);
        if (accomplishmentObjectdetail == null) {
            return ResponseHandler.generateResponseError(
                    "Accomplishment Object detail not found", HttpStatus.NOT_FOUND);
        }
        return ResponseHandler.generateResponseSuccess("", accomplishmentObjectdetail);
    }

    @PostMapping(value = "/search")
    public ResponseEntity<Object> search(@RequestBody Pagination pagination) {
        List<String> listFields = ClassUtils.getAllPropertyNames(AccomplishmentObjectdetailDTO.class);

        if (!pagination.isValidSortField(listFields)) {
            return ResponseHandler.generateResponseError(
                    "sortFiels invalid. In list: " + StringUtils.join(listFields, ','), HttpStatus.BAD_REQUEST);
        }
        Pageable pageable = pagination.convertToPageable();
        Page<AccomplishmentObjectdetailDTO> paged = accomplishmentObjectdetailService.searchPaged(pageable);
        PagedResponse<AccomplishmentObjectdetailDTO> response = new PagedResponse<>(
                paged.getContent(),
                paged.getNumber(),
                paged.getSize(),
                paged.getTotalElements(),
                paged.getTotalPages(),
                paged.isLast());
        return ResponseHandler.generateResponseSuccess("", response);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody TextRequestDTO name) {
        // validate parameters
        if (StringUtils.isEmpty(name.getText()) || accomplishmentObjectdetailService.existByName(name.getText())) {
            return ResponseHandler.generateResponseError(
                    "Invalid parameters. AccomplishmentObjectdetail name not null or existed", HttpStatus.BAD_REQUEST);
        }
        ////////////////////////////////
        int count = accomplishmentObjectdetailService.addRecord(name.getText());
        if (count == 0) {
            return ResponseHandler.generateResponseError("Save Accomplishments fail", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseHandler.generateResponseSuccess("Suessfully created", null);
    }

    @PostMapping("/update")
    public ResponseEntity<Object> update(
            @RequestBody @Validated AccomplishmentObjectdetail accomplishmentObjectdetail) {
        JSONObject jsonObject = ClassUtils.newJSONObject(accomplishmentObjectdetail);
        // validate parameters
        if (accomplishmentObjectdetail.getAccomplishmentobjectdetailid() == null) {
            return ResponseHandler.generateResponseError(
                    "Invalid parameters. AccomplishmentObjectdetail id not null", HttpStatus.BAD_REQUEST);
        }
        ////////////////////////////////
        int count = accomplishmentObjectdetailService.udpate(accomplishmentObjectdetail);
        if (count == 0) {
            return ResponseHandler.generateResponseError("Save Accomplishments fail", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseHandler.generateResponseSuccess("Suessfully updated", null);
    }

    @PostMapping("/delete")
    public ResponseEntity<Object> delete(
            @RequestParam(name = "accomplishmentobjectdetailid") Integer accomplishmentobjectdetailid) {
        if (accomplishmentObjectdetailService.deleteById(accomplishmentobjectdetailid) == 0) {
            return ResponseHandler.generateResponseError("Accomplishments not found", HttpStatus.NOT_FOUND);
        }
        return ResponseHandler.generateResponseSuccess("Suessfully deleted", null);
    }
}
