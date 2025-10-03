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
import com.base.admin.hrm.dto.JobPositionSearchDTO;
import com.base.admin.hrm.entity.JobPosition;
import com.base.admin.hrm.service.JobPositionService;
import com.base.admin.utils.ClassUtils;

@RequestMapping("/api/v1/hrm/jobposition")
@RestController
public class JobPositionController {
    private final JobPositionService jobPositionService;

    public JobPositionController(JobPositionService jobPositionService) {
        this.jobPositionService = jobPositionService;
    }

    @PostMapping("/findById")
    public ResponseEntity<Object> findById(@RequestParam(name = "jobcode", required = true) String jobcode) {
        JobPosition jobPosition = jobPositionService.findById(jobcode);
        if (jobPosition == null) {
            return ResponseHandler.generateResponseError("Job Code not found", HttpStatus.NOT_FOUND);
        }
        return ResponseHandler.generateResponseSuccess("", jobPosition);
    }

    @PostMapping(value = "/search")
    public ResponseEntity<Object> search(
            @RequestBody JobPositionSearchDTO jobPositionSearchDTO,
            @RequestParam(required = false, defaultValue = "false") boolean exact) {
        Pagination pagination = jobPositionSearchDTO.getPagination();
        List<String> listFields = ClassUtils.getAllPropertyNames(JobPosition.class);

        if (!pagination.isValidSortField(listFields)) {
            return ResponseHandler.generateResponseError(
                    "sortFiels invalid. In list: " + StringUtils.join(listFields, ','), HttpStatus.BAD_REQUEST);
        }
        Pageable pageable = pagination.convertToPageable();
        Page<JobPosition> paged = jobPositionService.searchPaged(jobPositionSearchDTO.getDto(), pageable, exact);
        PagedResponse<JobPosition> response = new PagedResponse<>(
                paged.getContent(),
                paged.getNumber(),
                paged.getSize(),
                paged.getTotalElements(),
                paged.getTotalPages(),
                paged.isLast());
        return ResponseHandler.generateResponseSuccess("", response);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody @Validated JobPosition jobPosition) {
        // validate parameters
        if (StringUtils.isEmpty(jobPosition.getJobcode()) || StringUtils.isEmpty(jobPosition.getJobname())) {
            return ResponseHandler.generateResponseError(
                    "Invalid parameters. Job code, Job name not null", HttpStatus.BAD_REQUEST);
        }
        if (jobPositionService.existsByJobcodeORJobname(jobPosition.getJobcode(), jobPosition.getJobname())) {
            return ResponseHandler.generateResponseError("Job code OR Job name already exists", HttpStatus.BAD_REQUEST);
        }
        ////////////////////////////////
        int count = jobPositionService.addJobPosition(jobPosition);
        if (count == 0) {
            return ResponseHandler.generateResponseError("Save Job Position fail", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseHandler.generateResponseSuccess("Suessfully created", null);
    }

    @PostMapping("/update")
    public ResponseEntity<Object> update(@RequestBody @Validated JobPosition jobPosition) {
        JSONObject jsonObject = ClassUtils.newJSONObject(jobPosition);
        // validate parameters
        if (StringUtils.isEmpty(jobPosition.getJobcode())) {
            return ResponseHandler.generateResponseError(
                    "Invalid parameters. Job code not null", HttpStatus.BAD_REQUEST);
        }

        if (jsonObject != null
                && ClassUtils.existsParameter(jsonObject, "jobname")
                && jobPosition.getJobname() != null
                && jobPositionService.existsByJobNameAndDifferentJobCode(
                        jobPosition.getJobname(), jobPosition.getJobcode())) {
            return ResponseHandler.generateResponseError("Job Name already exists", HttpStatus.BAD_REQUEST);
        }
        ////////////////////////////////
        int count = jobPositionService.update(jobPosition);
        if (count == 0) {
            return ResponseHandler.generateResponseError("Save Job Position fail", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseHandler.generateResponseSuccess("Suessfully updated", null);
    }

    @PostMapping("/delete")
    public ResponseEntity<Object> delete(@RequestParam(name = "jobcode", required = true) String jobcode) {
        if (jobPositionService.deleteById(jobcode) == 0) {
            return ResponseHandler.generateResponseError("Job Position not found", HttpStatus.NOT_FOUND);
        }
        return ResponseHandler.generateResponseSuccess("Suessfully deleted", null);
    }
}
