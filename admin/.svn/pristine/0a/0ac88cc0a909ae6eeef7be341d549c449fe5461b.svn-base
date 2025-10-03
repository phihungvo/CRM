/**
 * @mbg.generated generator on Fri Mar 22 12:34:29 ICT 2024
 */
package com.base.admin.masterdata.service;

import com.base.admin.masterdata.dto.CityDTO;
import com.base.admin.masterdata.dto.DistrictDTO;
import com.base.admin.masterdata.dto.WardDTO;
import com.base.admin.masterdata.entity.DmTinhthanh;
import com.base.admin.masterdata.mapper.DmTinhthanhMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DmTinhthanhServiceImpl implements DmTinhthanhService {
    private final DmTinhthanhMapper dmTinhthanhMapper;

    public DmTinhthanhServiceImpl(DmTinhthanhMapper dmTinhthanhMapper) {
        this.dmTinhthanhMapper = dmTinhthanhMapper;
    }

    @Override
    public DmTinhthanh selectByPrimaryKey(String id) {
        return dmTinhthanhMapper.selectByPrimaryKey(id);
    }

    @Override
    public int insert(DmTinhthanh row) {
        return dmTinhthanhMapper.insert(row);
    }

    @Override
    public int insertSelective(DmTinhthanh row) {
        return dmTinhthanhMapper.insertSelective(row);
    }

    @Override
    public Page<DmTinhthanh> searchPaged(DmTinhthanh search, Pageable pageable, boolean exact) {
        long total = 0;
        List<DmTinhthanh> content = dmTinhthanhMapper.searchPaged(search, pageable, exact);
        if (!content.isEmpty()) {
            total = dmTinhthanhMapper.countPaged(search, exact);
        }
        return new PageImpl<>(content, pageable, total);
    }

    @Override
    public Page<CityDTO> listCities(Pageable pageable) {
        long total = 0;
        List<CityDTO> content = dmTinhthanhMapper.listCities(pageable);
        if (!content.isEmpty()) {
            total = dmTinhthanhMapper.countlistCities();
        }
        return new PageImpl<>(content, pageable, total);
    }

    @Override
    public Page<DistrictDTO> listDistrictByCityId(Pageable pageable, String cityid) {
        long total = 0;
        List<DistrictDTO> content = dmTinhthanhMapper.listDistrictByCityId(pageable, cityid);
        if (!content.isEmpty()) {
            total = dmTinhthanhMapper.countDistrictByCityId(cityid);
        }
        return new PageImpl<>(content, pageable, total);
    }

    @Override
    public Page<WardDTO> listWardsByCityIdAndDistrictId(Pageable pageable, String cityid, String districtid) {
        long total = 0;
        List<WardDTO> content = dmTinhthanhMapper.listWardsByCityIdAndDistrictId(pageable, cityid, districtid);
        if (!content.isEmpty()) {
            total = dmTinhthanhMapper.countWardsByCityIdAndDistrictId(cityid, districtid);
        }
        return new PageImpl<>(content, pageable, total);
    }
}