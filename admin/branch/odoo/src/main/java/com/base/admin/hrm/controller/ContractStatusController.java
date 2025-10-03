package com.base.admin.hrm.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.base.admin.dto.PagedResponse;
import com.base.admin.dto.Pagination;
import com.base.admin.handler.ResponseHandler;
import com.base.admin.hrm.entity.ContractStatus;
import com.base.admin.hrm.service.ContractStatusService;
import com.base.admin.utils.ClassUtils;

@RequestMapping("/api/v1/hrm/contractstatus")
@RestController
public class ContractStatusController {
    private final ContractStatusService contractStatusService;

    public ContractStatusController(ContractStatusService contractStatusService) {
        this.contractStatusService = contractStatusService;
    }

    @PostMapping("/findById")
    public ResponseEntity<Object> findById(
            @RequestParam(name = "contractstatusid", required = true) Integer contractstatusid) {
        ContractStatus contractStatus = contractStatusService.findById(contractstatusid);
        if (contractStatus == null) {
            return ResponseHandler.generateResponseError("Contract status not found", HttpStatus.NOT_FOUND);
        }
        return ResponseHandler.generateResponseSuccess("", contractStatus);
    }

    @PostMapping(value = "/search")
    public ResponseEntity<Object> search(@RequestBody Pagination pagination) {
        List<String> listFields = ClassUtils.getAllPropertyNames(ContractStatus.class);

        if (!pagination.isValidSortField(listFields)) {
            return ResponseHandler.generateResponseError(
                    "sortFiels invalid. In list: " + StringUtils.join(listFields, ','), HttpStatus.BAD_REQUEST);
        }
        Pageable pageable = pagination.convertToPageable();
        Page<ContractStatus> paged = contractStatusService.searchPaged(pageable);
        PagedResponse<ContractStatus> response = new PagedResponse<>(
                paged.getContent(),
                paged.getNumber(),
                paged.getSize(),
                paged.getTotalElements(),
                paged.getTotalPages(),
                paged.isLast());
        return ResponseHandler.generateResponseSuccess("", response);
    }
}
