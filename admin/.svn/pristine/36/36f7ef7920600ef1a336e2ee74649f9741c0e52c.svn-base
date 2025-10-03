package com.base.admin.masterdata.controller;

import com.base.admin.dto.PagedResponse;
import com.base.admin.dto.Pagination;
import com.base.admin.handler.ResponseHandler;
import com.base.admin.masterdata.dto.DmLoaihopdongSearchDTO;
import com.base.admin.masterdata.entity.DmLoaihopdong;
import com.base.admin.masterdata.service.DmLoaihopdongService;
import com.base.admin.utils.ClassUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/catalog/dmloaihopdong")
public class DmLoaihopdongController {

    private final DmLoaihopdongService dmLoaihopdongService;

    public DmLoaihopdongController(DmLoaihopdongService dmLoaihopdongService) {
        this.dmLoaihopdongService = dmLoaihopdongService;
    }

    @PostMapping("/findById")
    public ResponseEntity<Object> findById(@RequestParam(name = "id", required = true) Integer id) {
        DmLoaihopdong loaihopdong = dmLoaihopdongService.selectByPrimaryKey(id);
        if (loaihopdong == null) {
            return ResponseHandler.generateResponseError("Dantoc not found", HttpStatus.NOT_FOUND);
        }
        return ResponseHandler.generateResponseSuccess("", loaihopdong);
    }

    @PostMapping(value = "/search")
    public ResponseEntity<Object> search(@RequestBody DmLoaihopdongSearchDTO dmLoaihopdongSearchDTO, @RequestParam(required = false, defaultValue = "false") boolean exact) {
        Pagination pagination = dmLoaihopdongSearchDTO.getPagination();
        List<String> listFields = ClassUtils.getAllPropertyNames(DmLoaihopdong.class);

        if (!pagination.isValidSortField(listFields)) {
            return ResponseHandler.generateResponseError("sortFiels invalid. In list: " + StringUtils.join(listFields, ','), HttpStatus.BAD_REQUEST);
        }
        Pageable pageable = pagination.convertToPageable();
        Page<DmLoaihopdong> paged = dmLoaihopdongService.searchPaged(dmLoaihopdongSearchDTO.getDto(), pageable, exact);
        PagedResponse<DmLoaihopdong> response = new PagedResponse<>(paged.getContent(), paged.getNumber(), paged.getSize(), paged.getTotalElements(), paged.getTotalPages(), paged.isLast());
        return ResponseHandler.generateResponseSuccess("", response);
    }
}
