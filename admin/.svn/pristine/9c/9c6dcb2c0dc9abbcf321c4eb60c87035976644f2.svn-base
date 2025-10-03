package com.base.admin.masterdata.controller;

import com.base.admin.dto.PagedResponse;
import com.base.admin.dto.Pagination;
import com.base.admin.handler.ResponseHandler;
import com.base.admin.masterdata.dto.DmTrangthailamviecSearchDTO;
import com.base.admin.masterdata.entity.DmTrangthailamviec;
import com.base.admin.masterdata.service.DmTrangthailamviecService;
import com.base.admin.utils.ClassUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/catalog/dmtrangthailamviec")
public class DmTrangthailamviecController {
    private final DmTrangthailamviecService dmTrangthailamviecService;

    public DmTrangthailamviecController(DmTrangthailamviecService dmTrangthailamviecService) {
        this.dmTrangthailamviecService = dmTrangthailamviecService;
    }

    @PostMapping("/findById")
    public ResponseEntity<Object> findById(@RequestParam(name = "id", required = true) Integer id) {
        DmTrangthailamviec trangthailamviec = dmTrangthailamviecService.selectByPrimaryKey(id);
        if (trangthailamviec == null) {
            return ResponseHandler.generateResponseError("Trang thai lam viec not found", HttpStatus.NOT_FOUND);
        }
        return ResponseHandler.generateResponseSuccess("", trangthailamviec);
    }

    @PostMapping(value = "/search")
    public ResponseEntity<Object> search(@RequestBody DmTrangthailamviecSearchDTO dmTrangthailamviecSearchDTO, @RequestParam(required = false, defaultValue = "false") boolean exact) {
        Pagination pagination = dmTrangthailamviecSearchDTO.getPagination();
        List<String> listFields = ClassUtils.getAllPropertyNames(DmTrangthailamviec.class);

        if (!pagination.isValidSortField(listFields)) {
            return ResponseHandler.generateResponseError("sortFiels invalid. In list: " + StringUtils.join(listFields, ','), HttpStatus.BAD_REQUEST);
        }
        Pageable pageable = pagination.convertToPageable();
        Page<DmTrangthailamviec> paged = dmTrangthailamviecService.searchPaged(dmTrangthailamviecSearchDTO.getDto(), pageable, exact);
        PagedResponse<DmTrangthailamviec> response = new PagedResponse<>(paged.getContent(), paged.getNumber(), paged.getSize(), paged.getTotalElements(), paged.getTotalPages(), paged.isLast());
        return ResponseHandler.generateResponseSuccess("", response);
    }
}
