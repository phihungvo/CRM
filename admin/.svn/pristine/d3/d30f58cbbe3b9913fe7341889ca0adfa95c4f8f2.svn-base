package com.base.admin.masterdata.controller;

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
import com.base.admin.masterdata.dto.DmTinhchatlaodongSearchDTO;
import com.base.admin.masterdata.entity.DmTinhchatlaodong;
import com.base.admin.masterdata.service.DmTinhchatlaodongService;
import com.base.admin.utils.ClassUtils;

@RestController
@RequestMapping("/api/v1/catalog/dmtinhchatlaodong")
public class DmTinhchatlaodongController {
    private final DmTinhchatlaodongService dmTinhchatlaodongService;

    public DmTinhchatlaodongController(DmTinhchatlaodongService dmTinhchatlaodongService) {
        this.dmTinhchatlaodongService = dmTinhchatlaodongService;
    }

    @PostMapping("/findById")
    public ResponseEntity<Object> findById(@RequestParam(name = "id", required = true) Integer id) {
        DmTinhchatlaodong laodong = dmTinhchatlaodongService.selectByPrimaryKey(id);
        if (laodong == null) {
            return ResponseHandler.generateResponseError("Quan he not found", HttpStatus.NOT_FOUND);
        }
        return ResponseHandler.generateResponseSuccess("", laodong);
    }

    @PostMapping(value = "/search")
    public ResponseEntity<Object> search(
            @RequestBody DmTinhchatlaodongSearchDTO dmTinhchatlaodongSearchDTO,
            @RequestParam(required = false, defaultValue = "false") boolean exact) {
        Pagination pagination = dmTinhchatlaodongSearchDTO.getPagination();
        List<String> listFields = ClassUtils.getAllPropertyNames(DmTinhchatlaodong.class);

        if (!pagination.isValidSortField(listFields)) {
            return ResponseHandler.generateResponseError(
                    "sortFiels invalid. In list: " + StringUtils.join(listFields, ','), HttpStatus.BAD_REQUEST);
        }
        Pageable pageable = pagination.convertToPageable();
        Page<DmTinhchatlaodong> paged =
                dmTinhchatlaodongService.searchPaged(dmTinhchatlaodongSearchDTO.getDto(), pageable, exact);
        PagedResponse<DmTinhchatlaodong> response = new PagedResponse<>(
                paged.getContent(),
                paged.getNumber(),
                paged.getSize(),
                paged.getTotalElements(),
                paged.getTotalPages(),
                paged.isLast());
        return ResponseHandler.generateResponseSuccess("", response);
    }
}
