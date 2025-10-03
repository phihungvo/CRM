package com.base.admin.masterdata.controller;

import com.base.admin.dto.PagedResponse;
import com.base.admin.dto.Pagination;
import com.base.admin.handler.ResponseHandler;
import com.base.admin.masterdata.dto.DmTongiaoSearchDTO;
import com.base.admin.masterdata.entity.DmTongiao;
import com.base.admin.masterdata.service.DmTongiaoService;
import com.base.admin.utils.ClassUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/catalog/dmtongiao")
public class DmTongiaoController {
    private final DmTongiaoService dmTongiaoService;

    public DmTongiaoController(DmTongiaoService dmTongiaoService) {
        this.dmTongiaoService = dmTongiaoService;
    }

    @PostMapping("/findById")
    public ResponseEntity<Object> findById(@RequestParam(name = "id", required = true) Integer id) {
        DmTongiao tongiao = dmTongiaoService.selectByPrimaryKey(id);
        if (tongiao == null) {
            return ResponseHandler.generateResponseError("Bao hiem not found", HttpStatus.NOT_FOUND);
        }
        return ResponseHandler.generateResponseSuccess("", tongiao);
    }

    @PostMapping(value = "/search")
    public ResponseEntity<Object> search(@RequestBody DmTongiaoSearchDTO dmTongiaoSearchDTO, @RequestParam(required = false, defaultValue = "false") boolean exact) {
        Pagination pagination = dmTongiaoSearchDTO.getPagination();
        List<String> listFields = ClassUtils.getAllPropertyNames(DmTongiao.class);

        if (!pagination.isValidSortField(listFields)) {
            return ResponseHandler.generateResponseError("sortFiels invalid. In list: " + StringUtils.join(listFields, ','), HttpStatus.BAD_REQUEST);
        }
        Pageable pageable = pagination.convertToPageable();
        Page<DmTongiao> paged = dmTongiaoService.searchPaged(dmTongiaoSearchDTO.getDto(), pageable, exact);
        PagedResponse<DmTongiao> response = new PagedResponse<>(paged.getContent(), paged.getNumber(), paged.getSize(), paged.getTotalElements(), paged.getTotalPages(), paged.isLast());
        return ResponseHandler.generateResponseSuccess("", response);
    }
}
