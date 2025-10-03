package com.base.admin.masterdata.controller;

import com.base.admin.dto.PagedResponse;
import com.base.admin.dto.Pagination;
import com.base.admin.handler.ResponseHandler;
import com.base.admin.masterdata.dto.DmTinhtrangbaohiemSearchDTO;
import com.base.admin.masterdata.entity.DmTinhtrangbaohiem;
import com.base.admin.masterdata.service.DmTinhtrangbaohiemService;
import com.base.admin.utils.ClassUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/catalog/dmtinhtrangbaohiem")
public class DmTinhtrangbaohiemController {
    private final DmTinhtrangbaohiemService dmTinhtrangbaohiemService;

    public DmTinhtrangbaohiemController(DmTinhtrangbaohiemService dmTinhtrangbaohiemService) {
        this.dmTinhtrangbaohiemService = dmTinhtrangbaohiemService;
    }

    @PostMapping("/findById")
    public ResponseEntity<Object> findById(@RequestParam(name = "id", required = true) Integer id) {
        DmTinhtrangbaohiem baohiem = dmTinhtrangbaohiemService.selectByPrimaryKey(id);
        if (baohiem == null) {
            return ResponseHandler.generateResponseError("Bao hiem not found", HttpStatus.NOT_FOUND);
        }
        return ResponseHandler.generateResponseSuccess("", baohiem);
    }

    @PostMapping(value = "/search")
    public ResponseEntity<Object> search(@RequestBody DmTinhtrangbaohiemSearchDTO dmTinhtrangbaohiemSearchDTO, @RequestParam(required = false, defaultValue = "false") boolean exact) {
        Pagination pagination = dmTinhtrangbaohiemSearchDTO.getPagination();
        List<String> listFields = ClassUtils.getAllPropertyNames(DmTinhtrangbaohiem.class);

        if (!pagination.isValidSortField(listFields)) {
            return ResponseHandler.generateResponseError("sortFiels invalid. In list: " + StringUtils.join(listFields, ','), HttpStatus.BAD_REQUEST);
        }
        Pageable pageable = pagination.convertToPageable();
        Page<DmTinhtrangbaohiem> paged = dmTinhtrangbaohiemService.searchPaged(dmTinhtrangbaohiemSearchDTO.getDto(), pageable, exact);
        PagedResponse<DmTinhtrangbaohiem> response = new PagedResponse<>(paged.getContent(), paged.getNumber(), paged.getSize(), paged.getTotalElements(), paged.getTotalPages(), paged.isLast());
        return ResponseHandler.generateResponseSuccess("", response);
    }
}
