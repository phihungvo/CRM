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
import com.base.admin.masterdata.dto.DmNoicapSearchDTO;
import com.base.admin.masterdata.entity.DmNoicap;
import com.base.admin.masterdata.service.DmNoicapService;
import com.base.admin.utils.ClassUtils;

@RestController
@RequestMapping("/api/v1/catalog/dmnoicap")
public class DmNoicapController {
    private final DmNoicapService dmNoicapService;

    public DmNoicapController(DmNoicapService dmNoicapService) {
        this.dmNoicapService = dmNoicapService;
    }

    @PostMapping("/findById")
    public ResponseEntity<Object> findById(@RequestParam(name = "id", required = true) Integer id) {
        DmNoicap noicap = dmNoicapService.selectByPrimaryKey(id);
        if (noicap == null) {
            return ResponseHandler.generateResponseError("Dantoc not found", HttpStatus.NOT_FOUND);
        }
        return ResponseHandler.generateResponseSuccess("", noicap);
    }

    @PostMapping(value = "/search")
    public ResponseEntity<Object> search(
            @RequestBody DmNoicapSearchDTO dmNoicapSearchDTO,
            @RequestParam(required = false, defaultValue = "false") boolean exact) {
        Pagination pagination = dmNoicapSearchDTO.getPagination();
        List<String> listFields = ClassUtils.getAllPropertyNames(DmNoicap.class);

        if (!pagination.isValidSortField(listFields)) {
            return ResponseHandler.generateResponseError(
                    "sortFiels invalid. In list: " + StringUtils.join(listFields, ','), HttpStatus.BAD_REQUEST);
        }
        Pageable pageable = pagination.convertToPageable();
        Page<DmNoicap> paged = dmNoicapService.searchPaged(dmNoicapSearchDTO.getDto(), pageable, exact);
        PagedResponse<DmNoicap> response = new PagedResponse<>(
                paged.getContent(),
                paged.getNumber(),
                paged.getSize(),
                paged.getTotalElements(),
                paged.getTotalPages(),
                paged.isLast());
        return ResponseHandler.generateResponseSuccess("", response);
    }
}
