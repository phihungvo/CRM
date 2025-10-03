package com.base.admin.masterdata.controller;

import com.base.admin.dto.PagedResponse;
import com.base.admin.dto.Pagination;
import com.base.admin.handler.ResponseHandler;
import com.base.admin.masterdata.dto.DmLoaigiaytoSearchDTO;
import com.base.admin.masterdata.entity.DmLoaigiayto;
import com.base.admin.masterdata.service.DmLoaigiaytoService;
import com.base.admin.utils.ClassUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/catalog/dmloaigiayto")
public class DmLoaigiaytoController {

    private final DmLoaigiaytoService dmLoaigiaytoService;

    public DmLoaigiaytoController(DmLoaigiaytoService dmLoaigiaytoService) {
        this.dmLoaigiaytoService = dmLoaigiaytoService;
    }

    @PostMapping("/findById")
    public ResponseEntity<Object> findById(@RequestParam(name = "id", required = true) Integer id) {
        DmLoaigiayto loaigiayto = dmLoaigiaytoService.selectByPrimaryKey(id);
        if (loaigiayto == null) {
            return ResponseHandler.generateResponseError("Dantoc not found", HttpStatus.NOT_FOUND);
        }
        return ResponseHandler.generateResponseSuccess("", loaigiayto);
    }

    @PostMapping(value = "/search")
    public ResponseEntity<Object> search(@RequestBody DmLoaigiaytoSearchDTO dmLoaigiaytoSearchDTO, @RequestParam(required = false, defaultValue = "false") boolean exact) {
        Pagination pagination = dmLoaigiaytoSearchDTO.getPagination();
        List<String> listFields = ClassUtils.getAllPropertyNames(DmLoaigiayto.class);

        if (!pagination.isValidSortField(listFields)) {
            return ResponseHandler.generateResponseError("sortFiels invalid. In list: " + StringUtils.join(listFields, ','), HttpStatus.BAD_REQUEST);
        }
        Pageable pageable = pagination.convertToPageable();
        Page<DmLoaigiayto> paged = dmLoaigiaytoService.searchPaged(dmLoaigiaytoSearchDTO.getDto(), pageable, exact);
        PagedResponse<DmLoaigiayto> response = new PagedResponse<>(paged.getContent(), paged.getNumber(), paged.getSize(), paged.getTotalElements(), paged.getTotalPages(), paged.isLast());
        return ResponseHandler.generateResponseSuccess("", response);
    }
}
