package com.base.admin.masterdata.controller;

import com.base.admin.dto.PagedResponse;
import com.base.admin.dto.Pagination;
import com.base.admin.handler.ResponseHandler;
import com.base.admin.masterdata.dto.DmNganhngheSearchDTO;
import com.base.admin.masterdata.entity.DmNganhnghe;
import com.base.admin.masterdata.service.DmNganhngheService;
import com.base.admin.utils.ClassUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/catalog/dmnganhnghe")
public class DmNganhngheController {

    private final DmNganhngheService dmNganhngheService;

    public DmNganhngheController(DmNganhngheService dmNganhngheService) {
        this.dmNganhngheService = dmNganhngheService;
    }

    @PostMapping("/findById")
    public ResponseEntity<Object> findById(@RequestParam(name = "id", required = true) Integer id) {
        DmNganhnghe nganhnghe = dmNganhngheService.selectByPrimaryKey(id);
        if (nganhnghe == null) {
            return ResponseHandler.generateResponseError("Dantoc not found", HttpStatus.NOT_FOUND);
        }
        return ResponseHandler.generateResponseSuccess("", nganhnghe);
    }

    @PostMapping(value = "/search")
    public ResponseEntity<Object> search(@RequestBody DmNganhngheSearchDTO dmNganhngheSearchDTO, @RequestParam(required = false, defaultValue = "false") boolean exact) {
        Pagination pagination = dmNganhngheSearchDTO.getPagination();
        List<String> listFields = ClassUtils.getAllPropertyNames(DmNganhnghe.class);

        if (!pagination.isValidSortField(listFields)) {
            return ResponseHandler.generateResponseError("sortFiels invalid. In list: " + StringUtils.join(listFields, ','), HttpStatus.BAD_REQUEST);
        }
        Pageable pageable = pagination.convertToPageable();
        Page<DmNganhnghe> paged = dmNganhngheService.searchPaged(dmNganhngheSearchDTO.getDto(), pageable, exact);
        PagedResponse<DmNganhnghe> response = new PagedResponse<>(paged.getContent(), paged.getNumber(), paged.getSize(), paged.getTotalElements(), paged.getTotalPages(), paged.isLast());
        return ResponseHandler.generateResponseSuccess("", response);
    }
}
