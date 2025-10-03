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
import com.base.admin.hrm.entity.ContractTime;
import com.base.admin.hrm.service.ContractTimeService;
import com.base.admin.utils.ClassUtils;

@RequestMapping("/api/v1/hrm/contracttime")
@RestController
public class ContractTimeController {
    private final ContractTimeService contractTimeService;

    public ContractTimeController(ContractTimeService contractTimeService) {
        this.contractTimeService = contractTimeService;
    }

    @PostMapping("/findById")
    public ResponseEntity<Object> findById(
            @RequestParam(name = "contracttimeid", required = true) Integer contracttimeid) {
        ContractTime contractTime = contractTimeService.findById(contracttimeid);
        if (contractTime == null) {
            return ResponseHandler.generateResponseError("Contract Time not found", HttpStatus.NOT_FOUND);
        }
        return ResponseHandler.generateResponseSuccess("", contractTime);
    }

    @PostMapping(value = "/search")
    public ResponseEntity<Object> search(@RequestBody Pagination pagination) {
        List<String> listFields = ClassUtils.getAllPropertyNames(ContractTime.class);

        if (!pagination.isValidSortField(listFields)) {
            return ResponseHandler.generateResponseError(
                    "sortFiels invalid. In list: " + StringUtils.join(listFields, ','), HttpStatus.BAD_REQUEST);
        }
        Pageable pageable = pagination.convertToPageable();
        Page<ContractTime> paged = contractTimeService.searchPaged(pageable);
        PagedResponse<ContractTime> response = new PagedResponse<>(
                paged.getContent(),
                paged.getNumber(),
                paged.getSize(),
                paged.getTotalElements(),
                paged.getTotalPages(),
                paged.isLast());
        return ResponseHandler.generateResponseSuccess("", response);
    }
}
