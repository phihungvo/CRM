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
import com.base.admin.hrm.entity.UnitLevel;
import com.base.admin.hrm.service.UnitLevelService;
import com.base.admin.utils.ClassUtils;

@RequestMapping("/api/v1/hrm/unitlevel")
@RestController
public class UnitLevelController {
    private final UnitLevelService unitLevelService;

    public UnitLevelController(UnitLevelService unitLevelService) {
        this.unitLevelService = unitLevelService;
    }

    @PostMapping("/findById")
    public ResponseEntity<Object> findById(@RequestParam(name = "unitlevelid", required = true) Integer unitlevelid) {
        UnitLevel unitLevel = unitLevelService.findById(unitlevelid);
        if (unitLevel == null) {
            return ResponseHandler.generateResponseError("Job level not found", HttpStatus.NOT_FOUND);
        }
        return ResponseHandler.generateResponseSuccess("", unitLevel);
    }

    @PostMapping(value = "/search")
    public ResponseEntity<Object> search(
            @RequestBody Pagination pagination, @RequestParam(name = "level", required = true) Integer level) {
        List<String> listFields = ClassUtils.getAllPropertyNames(UnitLevel.class);

        if (!pagination.isValidSortField(listFields)) {
            return ResponseHandler.generateResponseError(
                    "sortFiels invalid. In list: " + StringUtils.join(listFields, ','), HttpStatus.BAD_REQUEST);
        }
        Pageable pageable = pagination.convertToPageable();
        Page<UnitLevel> paged = unitLevelService.searchPaged(level, pageable);
        PagedResponse<UnitLevel> response = new PagedResponse<>(
                paged.getContent(),
                paged.getNumber(),
                paged.getSize(),
                paged.getTotalElements(),
                paged.getTotalPages(),
                paged.isLast());
        return ResponseHandler.generateResponseSuccess("", response);
    }
}
