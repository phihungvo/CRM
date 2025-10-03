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
import com.base.admin.hrm.dto.ContractSearchDTO;
import com.base.admin.hrm.dto.ContractsDTO;
import com.base.admin.hrm.entity.Contracts;
import com.base.admin.hrm.service.ContractsService;
import com.base.admin.hrm.service.EmployeesService;
import com.base.admin.utils.ClassUtils;

@RequestMapping("/api/v1/hrm/contract")
@RestController
public class ContractController {
    private final ContractsService contractsService;
    private final EmployeesService employeesService;

    public ContractController(ContractsService contractsService, EmployeesService employeesService) {
        this.contractsService = contractsService;
        this.employeesService = employeesService;
    }

    @PostMapping("/findById")
    public ResponseEntity<Object> findById(@RequestParam(name = "contractid", required = true) UUID contractid) {
        ContractsDTO contract = contractsService.findById(contractid);
        if (contract == null) {
            return ResponseHandler.generateResponseError("Contract not found", HttpStatus.NOT_FOUND);
        }
        return ResponseHandler.generateResponseSuccess("", contract);
    }

    @PostMapping(value = "/search")
    public ResponseEntity<Object> search(
            @RequestBody ContractSearchDTO contractSearchDTO,
            @RequestParam(required = false, defaultValue = "false") boolean exact) {
        Pagination pagination = contractSearchDTO.getPagination();
        List<String> listFields = ClassUtils.getAllPropertyNames(Contracts.class);

        if (!pagination.isValidSortField(listFields)) {
            return ResponseHandler.generateResponseError(
                    "sortFields invalid. In list: " + StringUtils.join(listFields, ','), HttpStatus.BAD_REQUEST);
        }
        Pageable pageable = pagination.convertToPageable();
        Page<ContractsDTO> paged = contractsService.searchPaged(contractSearchDTO.getDto(), pageable, exact);
        PagedResponse<ContractsDTO> response = new PagedResponse<>(
                paged.getContent(),
                paged.getNumber(),
                paged.getSize(),
                paged.getTotalElements(),
                paged.getTotalPages(),
                paged.isLast());
        return ResponseHandler.generateResponseSuccess("", response);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody @Validated ContractsDTO contractsDTO) {
        // validate parameters
        if (StringUtils.isEmpty(contractsDTO.getContractno())) {
            return ResponseHandler.generateResponseError(
                    "Invalid parameters. Contract Number not null", HttpStatus.BAD_REQUEST);
        }
        if (contractsDTO.getEmployeeid() != null && !employeesService.existsById(contractsDTO.getEmployeeid())) {
            return ResponseHandler.generateResponseError("Employee not exists", HttpStatus.BAD_REQUEST);
        }
        ////////////////////////////////
        int count = contractsService.addContractsDTO(contractsDTO);
        if (count == 0) {
            return ResponseHandler.generateResponseError("Save Contract fail", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseHandler.generateResponseSuccess("Suessfully created", null);
    }

    @PostMapping("/update")
    public ResponseEntity<Object> update(@RequestBody @Validated ContractsDTO contractsDTO) {
        JSONObject jsonObject = ClassUtils.newJSONObject(contractsDTO);
        // validate parameters
        if (StringUtils.isEmpty(contractsDTO.getContractno())) {
            return ResponseHandler.generateResponseError(
                    "Invalid parameters. Contract Number not null", HttpStatus.BAD_REQUEST);
        }
        if (contractsDTO.getContractid() == null || !contractsService.existsById(contractsDTO.getContractid())) {
            return ResponseHandler.generateResponseError(
                    "Invalid parameters. Contract Id not null", HttpStatus.BAD_REQUEST);
        }

        if (jsonObject != null
                && ClassUtils.existsParameter(jsonObject, "employeeid")
                && contractsDTO.getEmployeeid() != null
                && !employeesService.existsById(contractsDTO.getEmployeeid())) {
            return ResponseHandler.generateResponseError("Employee not exists", HttpStatus.BAD_REQUEST);
        }
        ////////////////////////////////
        int count = contractsService.udpate(contractsDTO);
        if (count == 0) {
            return ResponseHandler.generateResponseError("Save Contract fail", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseHandler.generateResponseSuccess("Suessfully updated", null);
    }

    @PostMapping("/delete")
    public ResponseEntity<Object> delete(@RequestParam(name = "contractid", required = true) UUID contractid) {
        if (contractsService.deleteById(contractid) == 0) {
            return ResponseHandler.generateResponseError("Contract not found", HttpStatus.NOT_FOUND);
        }
        return ResponseHandler.generateResponseSuccess("Suessfully deleted", null);
    }

    @PostMapping("/deleteByIds")
    public ResponseEntity<Object> deleteByIds(@RequestBody List<UUID> lístContractids) {
        if (contractsService.deleteByIds(lístContractids) == 0) {
            return ResponseHandler.generateResponseError("Contract not found", HttpStatus.NOT_FOUND);
        }
        return ResponseHandler.generateResponseSuccess("Suessfully deleted", null);
    }
}
