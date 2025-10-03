package com.base.admin.masterdata.controller;

import com.base.admin.dto.PagedResponse;
import com.base.admin.dto.Pagination;
import com.base.admin.handler.ResponseHandler;
import com.base.admin.masterdata.dto.CityDTO;
import com.base.admin.masterdata.dto.DistrictDTO;
import com.base.admin.masterdata.dto.WardDTO;
import com.base.admin.masterdata.service.DmTinhthanhService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/catalog/dmtinhthanh")
public class DmTinhthanhController {
    private final DmTinhthanhService dmTinhthanhService;

    public DmTinhthanhController(DmTinhthanhService dmTinhthanhService) {
        this.dmTinhthanhService = dmTinhthanhService;
    }

    @PostMapping("/listCities")
    public ResponseEntity<Object> listCities(@RequestBody Pagination pagination) {
        Pageable pageable = pagination.convertToPageable();
        Page<CityDTO> paged = dmTinhthanhService.listCities(pageable);
        PagedResponse<CityDTO> response = new PagedResponse<>(paged.getContent(), paged.getNumber(), paged.getSize(), paged.getTotalElements(), paged.getTotalPages(), paged.isLast());
        return ResponseHandler.generateResponseSuccess("", response);
    }

    @PostMapping("/listDistricts")
    public ResponseEntity<Object> listDistrict(@RequestBody Pagination pagination, @RequestParam(name = "cityid", required = true) String cityid) {
        Pageable pageable = pagination.convertToPageable();
        Page<DistrictDTO> paged = dmTinhthanhService.listDistrictByCityId(pageable, cityid);
        PagedResponse<DistrictDTO> response = new PagedResponse<>(paged.getContent(), paged.getNumber(), paged.getSize(), paged.getTotalElements(), paged.getTotalPages(), paged.isLast());
        return ResponseHandler.generateResponseSuccess("", response);
    }

    @PostMapping("/listWards")
    public ResponseEntity<Object> listWards(@RequestBody Pagination pagination, @RequestParam(name = "cityid", required = true) String cityid, @RequestParam(name = "districtid", required = true) String districtid) {
        Pageable pageable = pagination.convertToPageable();
        Page<WardDTO> paged = dmTinhthanhService.listWardsByCityIdAndDistrictId(pageable, cityid, districtid);
        PagedResponse<WardDTO> response = new PagedResponse<>(paged.getContent(), paged.getNumber(), paged.getSize(), paged.getTotalElements(), paged.getTotalPages(), paged.isLast());
        return ResponseHandler.generateResponseSuccess("", response);
    }

}
