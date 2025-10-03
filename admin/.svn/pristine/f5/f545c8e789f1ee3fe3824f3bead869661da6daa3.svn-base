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
import com.base.admin.hrm.entity.ContractType;
import com.base.admin.hrm.service.ContractTypeService;
import com.base.admin.utils.ClassUtils;

@RequestMapping("/api/v1/hrm/contracttype")
@RestController
public class ContractTypeController {
    private final ContractTypeService contractTypeService;

    public ContractTypeController(ContractTypeService contractTypeService) {
        this.contractTypeService = contractTypeService;
    }

    @PostMapping("/findById")
    public ResponseEntity<Object> findById(
            @RequestParam(name = "contracttypeid", required = true) Integer contracttypeid) {
        ContractType contractType = contractTypeService.findById(contracttypeid);
        if (contractType == null) {
            return ResponseHandler.generateResponseError("Contract Type not found", HttpStatus.NOT_FOUND);
        }
        return ResponseHandler.generateResponseSuccess("", contractType);
    }

    @PostMapping(value = "/search")
    public ResponseEntity<Object> search(@RequestBody Pagination pagination) {
        List<String> listFields = ClassUtils.getAllPropertyNames(ContractType.class);

        if (!pagination.isValidSortField(listFields)) {
            return ResponseHandler.generateResponseError(
                    "sortFiels invalid. In list: " + StringUtils.join(listFields, ','), HttpStatus.BAD_REQUEST);
        }
        Pageable pageable = pagination.convertToPageable();
        Page<ContractType> paged = contractTypeService.searchPaged(pageable);
        PagedResponse<ContractType> response = new PagedResponse<>(
                paged.getContent(),
                paged.getNumber(),
                paged.getSize(),
                paged.getTotalElements(),
                paged.getTotalPages(),
                paged.isLast());
        return ResponseHandler.generateResponseSuccess("", response);
    }
}
