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
import com.base.admin.masterdata.dto.DmXeploaiSearchDTO;
import com.base.admin.masterdata.entity.DmXeploai;
import com.base.admin.masterdata.service.DmXeploaiService;
import com.base.admin.utils.ClassUtils;

@RestController
@RequestMapping("/api/v1/catalog/dmxeploai")
public class DmXeploaiController {
    private final DmXeploaiService dmXeploaiService;

    public DmXeploaiController(DmXeploaiService dmXeploaiService) {
        this.dmXeploaiService = dmXeploaiService;
    }

    @PostMapping("/findById")
    public ResponseEntity<Object> findById(@RequestParam(name = "id", required = true) Integer id) {
        DmXeploai xeploai = dmXeploaiService.selectByPrimaryKey(id);
        if (xeploai == null) {
            return ResponseHandler.generateResponseError("Trang thai lam viec not found", HttpStatus.NOT_FOUND);
        }
        return ResponseHandler.generateResponseSuccess("", xeploai);
    }

    @PostMapping(value = "/search")
    public ResponseEntity<Object> search(
            @RequestBody DmXeploaiSearchDTO dmXeploaiSearchDTO,
            @RequestParam(required = false, defaultValue = "false") boolean exact) {
        Pagination pagination = dmXeploaiSearchDTO.getPagination();
        List<String> listFields = ClassUtils.getAllPropertyNames(DmXeploai.class);

        if (!pagination.isValidSortField(listFields)) {
            return ResponseHandler.generateResponseError(
                    "sortFiels invalid. In list: " + StringUtils.join(listFields, ','), HttpStatus.BAD_REQUEST);
        }
        Pageable pageable = pagination.convertToPageable();
        Page<DmXeploai> paged = dmXeploaiService.searchPaged(dmXeploaiSearchDTO.getDto(), pageable, exact);
        PagedResponse<DmXeploai> response = new PagedResponse<>(
                paged.getContent(),
                paged.getNumber(),
                paged.getSize(),
                paged.getTotalElements(),
                paged.getTotalPages(),
                paged.isLast());
        return ResponseHandler.generateResponseSuccess("", response);
    }
}
