package com.base.admin.hrm.controller;

import com.base.admin.dto.PagedResponse;
import com.base.admin.dto.Pagination;
import com.base.admin.handler.ResponseHandler;
import com.base.admin.hrm.entity.JobLevel;
import com.base.admin.hrm.service.JobLevelService;
import com.base.admin.utils.ClassUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/hrm/joblevel")
@RestController
public class JobLevelController {

    private final JobLevelService jobLevelService;

    public JobLevelController(JobLevelService jobLevelService) {
        this.jobLevelService = jobLevelService;
    }

    @PostMapping("/findById")
    public ResponseEntity<Object> findById(@RequestParam(name = "joblevelid", required = true) Integer joblevelid) {
        JobLevel jobLevel = jobLevelService.findById(joblevelid);
        if (jobLevel == null) {
            return ResponseHandler.generateResponseError("Job Level not found", HttpStatus.NOT_FOUND);
        }
        return ResponseHandler.generateResponseSuccess("", jobLevel);
    }

    @PostMapping(value = "/search")
    public ResponseEntity<Object> search(@RequestBody Pagination pagination) {
        List<String> listFields = ClassUtils.getAllPropertyNames(JobLevel.class);

        if (!pagination.isValidSortField(listFields)) {
            return ResponseHandler.generateResponseError("sortFiels invalid. In list: " + StringUtils.join(listFields, ','), HttpStatus.BAD_REQUEST);
        }
        Pageable pageable = pagination.convertToPageable();
        Page<JobLevel> paged = jobLevelService.searchPaged(pageable);
        PagedResponse<JobLevel> response = new PagedResponse<>(paged.getContent(), paged.getNumber(), paged.getSize(), paged.getTotalElements(), paged.getTotalPages(), paged.isLast());
        return ResponseHandler.generateResponseSuccess("", response);
    }
}
