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
import com.base.admin.masterdata.dto.DmDantocSearchDTO;
import com.base.admin.masterdata.entity.DmDantoc;
import com.base.admin.masterdata.service.DmDantocService;
import com.base.admin.utils.ClassUtils;

@RestController
@RequestMapping("/api/v1/catalog/dmdantoc")
public class DmDantocController {
    private final DmDantocService dmDantocService;

    public DmDantocController(DmDantocService dmDantocService) {
        this.dmDantocService = dmDantocService;
    }

    @PostMapping("/findById")
    public ResponseEntity<Object> findById(@RequestParam(name = "id", required = true) Integer id) {
        DmDantoc dantoc = dmDantocService.selectByPrimaryKey(id);
        if (dantoc == null) {
            return ResponseHandler.generateResponseError("Dantoc not found", HttpStatus.NOT_FOUND);
        }
        return ResponseHandler.generateResponseSuccess("", dantoc);
    }

    @PostMapping(value = "/search")
    public ResponseEntity<Object> search(
            @RequestBody DmDantocSearchDTO dmDantocSearchDTO,
            @RequestParam(required = false, defaultValue = "false") boolean exact) {
        Pagination pagination = dmDantocSearchDTO.getPagination();
        List<String> listFields = ClassUtils.getAllPropertyNames(DmDantoc.class);

        if (!pagination.isValidSortField(listFields)) {
            return ResponseHandler.generateResponseError(
                    "sortFiels invalid. In list: " + StringUtils.join(listFields, ','), HttpStatus.BAD_REQUEST);
        }
        Pageable pageable = pagination.convertToPageable();
        Page<DmDantoc> paged = dmDantocService.searchPaged(dmDantocSearchDTO.getDto(), pageable, exact);
        PagedResponse<DmDantoc> response = new PagedResponse<>(
                paged.getContent(),
                paged.getNumber(),
                paged.getSize(),
                paged.getTotalElements(),
                paged.getTotalPages(),
                paged.isLast());
        return ResponseHandler.generateResponseSuccess("", response);
    }
}
