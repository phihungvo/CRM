package com.base.admin.hrm.controller;

import com.base.admin.dto.PagedResponse;
import com.base.admin.dto.Pagination;
import com.base.admin.handler.ResponseHandler;
import com.base.admin.hrm.dto.TerminationReasonDTO;
import com.base.admin.hrm.service.TerminationReasonService;
import com.base.admin.utils.ClassUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/hrm/terminationreason")
@RestController
public class TerminationReasonController {

    private final TerminationReasonService terminationReasonService;

    public TerminationReasonController(TerminationReasonService terminationReasonService) {
        this.terminationReasonService = terminationReasonService;
    }

    @PostMapping("/findById")
    public ResponseEntity<Object> findById(@RequestParam(name = "terminationreasonid", required = true) Integer terminationreasonid) {
        TerminationReasonDTO terminationReason = terminationReasonService.findById(terminationreasonid);
        if (terminationReason == null) {
            return ResponseHandler.generateResponseError("Termination reason not found", HttpStatus.NOT_FOUND);
        }
        return ResponseHandler.generateResponseSuccess("", terminationReason);
    }

    @PostMapping(value = "/search")
    public ResponseEntity<Object> search(@RequestBody Pagination pagination) {
        List<String> listFields = ClassUtils.getAllPropertyNames(TerminationReasonDTO.class);

        if (!pagination.isValidSortField(listFields)) {
            return ResponseHandler.generateResponseError("sortFiels invalid. In list: " + StringUtils.join(listFields, ','), HttpStatus.BAD_REQUEST);
        }
        Pageable pageable = pagination.convertToPageable();
        Page<TerminationReasonDTO> paged = terminationReasonService.searchPaged(pageable);
        PagedResponse<TerminationReasonDTO> response = new PagedResponse<>(paged.getContent(), paged.getNumber(), paged.getSize(), paged.getTotalElements(), paged.getTotalPages(), paged.isLast());
        return ResponseHandler.generateResponseSuccess("", response);
    }
}
