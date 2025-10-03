package com.base.admin.masterdata.controller;

import com.base.admin.dto.PagedResponse;
import com.base.admin.dto.Pagination;
import com.base.admin.handler.ResponseHandler;
import com.base.admin.masterdata.dto.DmThanhphancanhanSearchDTO;
import com.base.admin.masterdata.entity.DmThanhphancanhan;
import com.base.admin.masterdata.service.DmThanhphancanhanService;
import com.base.admin.utils.ClassUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/catalog/dmthanhphancanhan")
public class DmThanhphancanhanController {

    private final DmThanhphancanhanService dmThanhphancanhanService;

    public DmThanhphancanhanController(DmThanhphancanhanService dmThanhphancanhanService) {
        this.dmThanhphancanhanService = dmThanhphancanhanService;
    }

    @PostMapping("/findById")
    public ResponseEntity<Object> findById(@RequestParam(name = "id", required = true) Integer id) {
        DmThanhphancanhan canhan = dmThanhphancanhanService.selectByPrimaryKey(id);
        if (canhan == null) {
            return ResponseHandler.generateResponseError("Quan he not found", HttpStatus.NOT_FOUND);
        }
        return ResponseHandler.generateResponseSuccess("", canhan);
    }

    @PostMapping(value = "/search")
    public ResponseEntity<Object> search(@RequestBody DmThanhphancanhanSearchDTO dmThanhphancanhanSearchDTO, @RequestParam(required = false, defaultValue = "false") boolean exact) {
        Pagination pagination = dmThanhphancanhanSearchDTO.getPagination();
        List<String> listFields = ClassUtils.getAllPropertyNames(DmThanhphancanhan.class);

        if (!pagination.isValidSortField(listFields)) {
            return ResponseHandler.generateResponseError("sortFiels invalid. In list: " + StringUtils.join(listFields, ','), HttpStatus.BAD_REQUEST);
        }
        Pageable pageable = pagination.convertToPageable();
        Page<DmThanhphancanhan> paged = dmThanhphancanhanService.searchPaged(dmThanhphancanhanSearchDTO.getDto(), pageable, exact);
        PagedResponse<DmThanhphancanhan> response = new PagedResponse<>(paged.getContent(), paged.getNumber(), paged.getSize(), paged.getTotalElements(), paged.getTotalPages(), paged.isLast());
        return ResponseHandler.generateResponseSuccess("", response);
    }
}
