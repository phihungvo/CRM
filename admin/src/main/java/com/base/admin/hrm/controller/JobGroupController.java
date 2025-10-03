package com.base.admin.hrm.controller;

import com.base.admin.dto.PagedResponse;
import com.base.admin.dto.Pagination;
import com.base.admin.handler.ResponseHandler;
import com.base.admin.hrm.entity.JobGroup;
import com.base.admin.hrm.service.JobGroupService;
import com.base.admin.utils.ClassUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/hrm/jobgroup")
@RestController
public class JobGroupController {
    private final JobGroupService jobGroupService;

    public JobGroupController(JobGroupService jobGroupService) {
        this.jobGroupService = jobGroupService;
    }

    @PostMapping("/findById")
    public ResponseEntity<Object> findById(@RequestParam(name = "jobgroupid", required = true) Integer jobgroupid) {
        JobGroup jobGroup = jobGroupService.findById(jobgroupid);
        if (jobGroup == null) {
            return ResponseHandler.generateResponseError("Job Group not found", HttpStatus.NOT_FOUND);
        }
        return ResponseHandler.generateResponseSuccess("", jobGroup);
    }

    @PostMapping(value = "/search")
    public ResponseEntity<Object> search(@RequestBody Pagination pagination) {
        List<String> listFields = ClassUtils.getAllPropertyNames(JobGroup.class);

        if (!pagination.isValidSortField(listFields)) {
            return ResponseHandler.generateResponseError("sortFiels invalid. In list: " + StringUtils.join(listFields, ','), HttpStatus.BAD_REQUEST);
        }
        Pageable pageable = pagination.convertToPageable();
        Page<JobGroup> paged = jobGroupService.searchPaged(pageable);
        PagedResponse<JobGroup> response = new PagedResponse<>(paged.getContent(), paged.getNumber(), paged.getSize(), paged.getTotalElements(), paged.getTotalPages(), paged.isLast());
        return ResponseHandler.generateResponseSuccess("", response);
    }
}
