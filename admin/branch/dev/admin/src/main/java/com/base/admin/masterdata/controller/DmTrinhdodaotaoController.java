package com.base.admin.masterdata.controller;

import com.base.admin.dto.PagedResponse;
import com.base.admin.dto.Pagination;
import com.base.admin.handler.ResponseHandler;
import com.base.admin.masterdata.dto.DmTrinhdodaotaoSearchDTO;
import com.base.admin.masterdata.entity.DmTrinhdodaotao;
import com.base.admin.masterdata.service.DmTrinhdodaotaoService;
import com.base.admin.utils.ClassUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/catalog/dmtrinhdodaotao")
public class DmTrinhdodaotaoController {
    private final DmTrinhdodaotaoService dmTrinhdodaotaoService;

    public DmTrinhdodaotaoController(DmTrinhdodaotaoService dmTrinhdodaotaoService) {
        this.dmTrinhdodaotaoService = dmTrinhdodaotaoService;
    }

    @PostMapping("/findById")
    public ResponseEntity<Object> findById(@RequestParam(name = "id", required = true) Integer id) {
        DmTrinhdodaotao trinhdo = dmTrinhdodaotaoService.selectByPrimaryKey(id);
        if (trinhdo == null) {
            return ResponseHandler.generateResponseError("Trang thai lam viec not found", HttpStatus.NOT_FOUND);
        }
        return ResponseHandler.generateResponseSuccess("", trinhdo);
    }

    @PostMapping(value = "/search")
    public ResponseEntity<Object> search(@RequestBody DmTrinhdodaotaoSearchDTO dmTrinhdodaotaoSearchDTO, @RequestParam(required = false, defaultValue = "false") boolean exact) {
        Pagination pagination = dmTrinhdodaotaoSearchDTO.getPagination();
        List<String> listFields = ClassUtils.getAllPropertyNames(DmTrinhdodaotao.class);

        if (!pagination.isValidSortField(listFields)) {
            return ResponseHandler.generateResponseError("sortFiels invalid. In list: " + StringUtils.join(listFields, ','), HttpStatus.BAD_REQUEST);
        }
        Pageable pageable = pagination.convertToPageable();
        Page<DmTrinhdodaotao> paged = dmTrinhdodaotaoService.searchPaged(dmTrinhdodaotaoSearchDTO.getDto(), pageable, exact);
        PagedResponse<DmTrinhdodaotao> response = new PagedResponse<>(paged.getContent(), paged.getNumber(), paged.getSize(), paged.getTotalElements(), paged.getTotalPages(), paged.isLast());
        return ResponseHandler.generateResponseSuccess("", response);
    }
}
