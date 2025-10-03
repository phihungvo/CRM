package com.base.admin.hrm.controller;

import com.base.admin.dto.PagedResponse;
import com.base.admin.dto.Pagination;
import com.base.admin.handler.ResponseHandler;
import com.base.admin.hrm.entity.JobTitle;
import com.base.admin.hrm.service.JobTitleService;
import com.base.admin.utils.ClassUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/hrm/jobtitle")
@RestController
public class JobTitleController {
    private final JobTitleService jobTitleService;

    public JobTitleController(JobTitleService jobTitleService) {
        this.jobTitleService = jobTitleService;
    }

    @PostMapping("/findById")
    public ResponseEntity<Object> findById(@RequestParam(name = "jobtitleid", required = true) Integer jobtitleid) {
        JobTitle jobTitle = jobTitleService.findById(jobtitleid);
        if (jobTitle == null) {
            return ResponseHandler.generateResponseError("Job Title not found", HttpStatus.NOT_FOUND);
        }
        return ResponseHandler.generateResponseSuccess("", jobTitle);
    }

    @PostMapping(value = "/search")
    public ResponseEntity<Object> search(@RequestBody Pagination pagination) {
        List<String> listFields = ClassUtils.getAllPropertyNames(JobTitle.class);

        if (!pagination.isValidSortField(listFields)) {
            return ResponseHandler.generateResponseError("sortFiels invalid. In list: " + StringUtils.join(listFields, ','), HttpStatus.BAD_REQUEST);
        }
        Pageable pageable = pagination.convertToPageable();
        Page<JobTitle> paged = jobTitleService.searchPaged(pageable);
        PagedResponse<JobTitle> response = new PagedResponse<>(paged.getContent(), paged.getNumber(), paged.getSize(), paged.getTotalElements(), paged.getTotalPages(), paged.isLast());
        return ResponseHandler.generateResponseSuccess("", response);
    }
}
