package com.base.admin.masterdata.controller;

import com.base.admin.dto.PagedResponse;
import com.base.admin.dto.Pagination;
import com.base.admin.handler.ResponseHandler;
import com.base.admin.masterdata.dto.DmThanhphangiadinhSearchDTO;
import com.base.admin.masterdata.entity.DmThanhphangiadinh;
import com.base.admin.masterdata.service.DmThanhphangiadinhService;
import com.base.admin.utils.ClassUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/catalog/dmthanhphangiadinh")
public class DmThanhphangiadinhController {
    private final DmThanhphangiadinhService dmThanhphangiadinhService;

    public DmThanhphangiadinhController(DmThanhphangiadinhService dmThanhphangiadinhService) {
        this.dmThanhphangiadinhService = dmThanhphangiadinhService;
    }

    @PostMapping("/findById")
    public ResponseEntity<Object> findById(@RequestParam(name = "id", required = true) Integer id) {
        DmThanhphangiadinh giadinh = dmThanhphangiadinhService.selectByPrimaryKey(id);
        if (giadinh == null) {
            return ResponseHandler.generateResponseError("Quan he not found", HttpStatus.NOT_FOUND);
        }
        return ResponseHandler.generateResponseSuccess("", giadinh);
    }

    @PostMapping(value = "/search")
    public ResponseEntity<Object> search(@RequestBody DmThanhphangiadinhSearchDTO dmThanhphangiadinhSearchDTO, @RequestParam(required = false, defaultValue = "false") boolean exact) {
        Pagination pagination = dmThanhphangiadinhSearchDTO.getPagination();
        List<String> listFields = ClassUtils.getAllPropertyNames(DmThanhphangiadinh.class);

        if (!pagination.isValidSortField(listFields)) {
            return ResponseHandler.generateResponseError("sortFiels invalid. In list: " + StringUtils.join(listFields, ','), HttpStatus.BAD_REQUEST);
        }
        Pageable pageable = pagination.convertToPageable();
        Page<DmThanhphangiadinh> paged = dmThanhphangiadinhService.searchPaged(dmThanhphangiadinhSearchDTO.getDto(), pageable, exact);
        PagedResponse<DmThanhphangiadinh> response = new PagedResponse<>(paged.getContent(), paged.getNumber(), paged.getSize(), paged.getTotalElements(), paged.getTotalPages(), paged.isLast());
        return ResponseHandler.generateResponseSuccess("", response);
    }
}
