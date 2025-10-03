package com.base.admin.masterdata.controller;

import com.base.admin.dto.PagedResponse;
import com.base.admin.dto.Pagination;
import com.base.admin.handler.ResponseHandler;
import com.base.admin.masterdata.dto.DmNganhangSearchDTO;
import com.base.admin.masterdata.entity.DmNganhang;
import com.base.admin.masterdata.service.DmNganhangService;
import com.base.admin.utils.ClassUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/catalog/dmnganhang")
public class DmNganhangController {
    private final DmNganhangService dmNganhangService;

    public DmNganhangController(DmNganhangService dmNganhangService) {
        this.dmNganhangService = dmNganhangService;
    }

    @PostMapping("/findById")
    public ResponseEntity<Object> findById(@RequestParam(name = "id", required = true) Integer id) {
        DmNganhang nganhang = dmNganhangService.selectByPrimaryKey(id);
        if (nganhang == null) {
            return ResponseHandler.generateResponseError("Nganhang not found", HttpStatus.NOT_FOUND);
        }
        return ResponseHandler.generateResponseSuccess("", nganhang);
    }

    @PostMapping(value = "/search")
    public ResponseEntity<Object> search(@RequestBody DmNganhangSearchDTO dmNganhangSearchDTO, @RequestParam(required = false, defaultValue = "false") boolean exact) {
        Pagination pagination = dmNganhangSearchDTO.getPagination();
        List<String> listFields = ClassUtils.getAllPropertyNames(DmNganhang.class);

        if (!pagination.isValidSortField(listFields)) {
            return ResponseHandler.generateResponseError("sortFiels invalid. In list: " + StringUtils.join(listFields, ','), HttpStatus.BAD_REQUEST);
        }
        Pageable pageable = pagination.convertToPageable();
        Page<DmNganhang> paged = dmNganhangService.searchPaged(dmNganhangSearchDTO.getDto(), pageable, exact);
        PagedResponse<DmNganhang> response = new PagedResponse<>(paged.getContent(), paged.getNumber(), paged.getSize(), paged.getTotalElements(), paged.getTotalPages(), paged.isLast());
        return ResponseHandler.generateResponseSuccess("", response);
    }
}
