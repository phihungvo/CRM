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
import com.base.admin.masterdata.dto.DmQuanheSearchDTO;
import com.base.admin.masterdata.entity.DmQuanhe;
import com.base.admin.masterdata.service.DmQuanheService;
import com.base.admin.utils.ClassUtils;

@RestController
@RequestMapping("/api/v1/catalog/dmquanhe")
public class DmQuanheController {

    private final DmQuanheService dmQuanheService;

    public DmQuanheController(DmQuanheService dmQuanheService) {
        this.dmQuanheService = dmQuanheService;
    }

    @PostMapping("/findById")
    public ResponseEntity<Object> findById(@RequestParam(name = "id", required = true) Integer id) {
        DmQuanhe quanhe = dmQuanheService.selectByPrimaryKey(id);
        if (quanhe == null) {
            return ResponseHandler.generateResponseError("Quan he not found", HttpStatus.NOT_FOUND);
        }
        return ResponseHandler.generateResponseSuccess("", quanhe);
    }

    @PostMapping(value = "/search")
    public ResponseEntity<Object> search(
            @RequestBody DmQuanheSearchDTO dmQuanheSearchDTO,
            @RequestParam(required = false, defaultValue = "false") boolean exact) {
        Pagination pagination = dmQuanheSearchDTO.getPagination();
        List<String> listFields = ClassUtils.getAllPropertyNames(DmQuanhe.class);

        if (!pagination.isValidSortField(listFields)) {
            return ResponseHandler.generateResponseError(
                    "sortFiels invalid. In list: " + StringUtils.join(listFields, ','), HttpStatus.BAD_REQUEST);
        }
        Pageable pageable = pagination.convertToPageable();
        Page<DmQuanhe> paged = dmQuanheService.searchPaged(dmQuanheSearchDTO.getDto(), pageable, exact);
        PagedResponse<DmQuanhe> response = new PagedResponse<>(
                paged.getContent(),
                paged.getNumber(),
                paged.getSize(),
                paged.getTotalElements(),
                paged.getTotalPages(),
                paged.isLast());
        return ResponseHandler.generateResponseSuccess("", response);
    }
}
