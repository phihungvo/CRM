/**
 * @mbg.generated generator on Fri Mar 22 12:34:29 ICT 2024
 */
package com.base.admin.masterdata.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.base.admin.masterdata.dto.CityDTO;
import com.base.admin.masterdata.dto.DistrictDTO;
import com.base.admin.masterdata.dto.WardDTO;
import com.base.admin.masterdata.entity.DmTinhthanh;

public interface DmTinhthanhService {
    DmTinhthanh selectByPrimaryKey(String id);

    int insert(DmTinhthanh row);

    int insertSelective(DmTinhthanh row);

    Page<DmTinhthanh> searchPaged(DmTinhthanh search, Pageable pageable, boolean exact);

    Page<CityDTO> listCities(Pageable pageable);

    Page<DistrictDTO> listDistrictByCityId(Pageable pageable, String cityid);

    Page<WardDTO> listWardsByCityIdAndDistrictId(Pageable pageable, String cityid, String districtid);
}
