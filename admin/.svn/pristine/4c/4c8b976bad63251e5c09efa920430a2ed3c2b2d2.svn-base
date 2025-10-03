package com.base.admin.masterdata.controller;

import com.base.admin.dto.PagedResponse;
import com.base.admin.dto.Pagination;
import com.base.admin.handler.ResponseHandler;
import com.base.admin.masterdata.dto.DmGioitinhSearchDTO;
import com.base.admin.masterdata.entity.DmGioitinh;
import com.base.admin.masterdata.service.DmGioitinhService;
import com.base.admin.utils.ClassUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/catalog/dmgioitinh")
public class DmGioitinhController {

    private final DmGioitinhService dmGioitinhService;

    public DmGioitinhController(DmGioitinhService dmGioitinhService) {
        this.dmGioitinhService = dmGioitinhService;
    }

    @PostMapping("/findById")
    public ResponseEntity<Object> findById(@RequestParam(name = "id", required = true) Integer id) {
        DmGioitinh gioitinh = dmGioitinhService.selectByPrimaryKey(id);
        if (gioitinh == null) {
            return ResponseHandler.generateResponseError("Dantoc not found", HttpStatus.NOT_FOUND);
        }
        return ResponseHandler.generateResponseSuccess("", gioitinh);
    }

    @PostMapping(value = "/search")
    public ResponseEntity<Object> search(@RequestBody DmGioitinhSearchDTO dmGioitinhSearchDTO, @RequestParam(required = false, defaultValue = "false") boolean exact) {
        Pagination pagination = dmGioitinhSearchDTO.getPagination();
        List<String> listFields = ClassUtils.getAllPropertyNames(DmGioitinh.class);

        if (!pagination.isValidSortField(listFields)) {
            return ResponseHandler.generateResponseError("sortFiels invalid. In list: " + StringUtils.join(listFields, ','), HttpStatus.BAD_REQUEST);
        }
        Pageable pageable = pagination.convertToPageable();
        Page<DmGioitinh> paged = dmGioitinhService.searchPaged(dmGioitinhSearchDTO.getDto(), pageable, exact);
        PagedResponse<DmGioitinh> response = new PagedResponse<>(paged.getContent(), paged.getNumber(), paged.getSize(), paged.getTotalElements(), paged.getTotalPages(), paged.isLast());
        return ResponseHandler.generateResponseSuccess("", response);
    }
}
