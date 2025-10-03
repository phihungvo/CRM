package com.base.admin.masterdata.controller;

import com.base.admin.dto.PagedResponse;
import com.base.admin.dto.Pagination;
import com.base.admin.handler.ResponseHandler;
import com.base.admin.masterdata.dto.DmTinhtranghonnhanSearchDTO;
import com.base.admin.masterdata.entity.DmTinhtranghonnhan;
import com.base.admin.masterdata.service.DmTinhtranghonnhanService;
import com.base.admin.utils.ClassUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/catalog/dmtinhtranghonnhan")
public class DmTinhtranghonnhanController {
    private final DmTinhtranghonnhanService dmTinhtranghonnhanService;

    public DmTinhtranghonnhanController(DmTinhtranghonnhanService dmTinhtranghonnhanService) {
        this.dmTinhtranghonnhanService = dmTinhtranghonnhanService;
    }

    @PostMapping("/findById")
    public ResponseEntity<Object> findById(@RequestParam(name = "id", required = true) Integer id) {
        DmTinhtranghonnhan honnhan = dmTinhtranghonnhanService.selectByPrimaryKey(id);
        if (honnhan == null) {
            return ResponseHandler.generateResponseError("Bao hiem not found", HttpStatus.NOT_FOUND);
        }
        return ResponseHandler.generateResponseSuccess("", honnhan);
    }

    @PostMapping(value = "/search")
    public ResponseEntity<Object> search(@RequestBody DmTinhtranghonnhanSearchDTO dmTinhtranghonnhanSearchDTO, @RequestParam(required = false, defaultValue = "false") boolean exact) {
        Pagination pagination = dmTinhtranghonnhanSearchDTO.getPagination();
        List<String> listFields = ClassUtils.getAllPropertyNames(DmTinhtranghonnhan.class);

        if (!pagination.isValidSortField(listFields)) {
            return ResponseHandler.generateResponseError("sortFiels invalid. In list: " + StringUtils.join(listFields, ','), HttpStatus.BAD_REQUEST);
        }
        Pageable pageable = pagination.convertToPageable();
        Page<DmTinhtranghonnhan> paged = dmTinhtranghonnhanService.searchPaged(dmTinhtranghonnhanSearchDTO.getDto(), pageable, exact);
        PagedResponse<DmTinhtranghonnhan> response = new PagedResponse<>(paged.getContent(), paged.getNumber(), paged.getSize(), paged.getTotalElements(), paged.getTotalPages(), paged.isLast());
        return ResponseHandler.generateResponseSuccess("", response);
    }

}
