package com.base.admin.masterdata.controller;

import com.base.admin.dto.PagedResponse;
import com.base.admin.dto.Pagination;
import com.base.admin.handler.ResponseHandler;
import com.base.admin.masterdata.dto.DmTruongdaihocSearchDTO;
import com.base.admin.masterdata.entity.DmTruongdaihoc;
import com.base.admin.masterdata.service.DmTruongdaihocService;
import com.base.admin.utils.ClassUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/catalog/dmtruongdaihoc")
public class DmTruongdaihocController {

    private final DmTruongdaihocService dmTruongdaihocService;

    public DmTruongdaihocController(DmTruongdaihocService dmTruongdaihocService) {
        this.dmTruongdaihocService = dmTruongdaihocService;
    }

    @PostMapping("/findById")
    public ResponseEntity<Object> findById(@RequestParam(name = "id", required = true) Integer id) {
        DmTruongdaihoc truong = dmTruongdaihocService.selectByPrimaryKey(id);
        if (truong == null) {
            return ResponseHandler.generateResponseError("Truong not found", HttpStatus.NOT_FOUND);
        }
        return ResponseHandler.generateResponseSuccess("", truong);
    }

    @PostMapping(value = "/search")
    public ResponseEntity<Object> search(@RequestBody DmTruongdaihocSearchDTO dmTruongdaihocSearchDTO, @RequestParam(required = false, defaultValue = "false") boolean exact) {
        Pagination pagination = dmTruongdaihocSearchDTO.getPagination();
        List<String> listFields = ClassUtils.getAllPropertyNames(DmTruongdaihoc.class);

        if (!pagination.isValidSortField(listFields)) {
            return ResponseHandler.generateResponseError("sortFiels invalid. In list: " + StringUtils.join(listFields, ','), HttpStatus.BAD_REQUEST);
        }
        Pageable pageable = pagination.convertToPageable();
        Page<DmTruongdaihoc> paged = dmTruongdaihocService.searchPaged(dmTruongdaihocSearchDTO.getDto(), pageable, exact);
        PagedResponse<DmTruongdaihoc> response = new PagedResponse<>(paged.getContent(), paged.getNumber(), paged.getSize(), paged.getTotalElements(), paged.getTotalPages(), paged.isLast());
        return ResponseHandler.generateResponseSuccess("", response);
    }
}
