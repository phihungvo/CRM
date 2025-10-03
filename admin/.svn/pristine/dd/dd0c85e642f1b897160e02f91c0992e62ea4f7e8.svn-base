package com.base.admin.masterdata.mapper;

import com.base.admin.masterdata.dto.CityDTO;
import com.base.admin.masterdata.dto.DistrictDTO;
import com.base.admin.masterdata.dto.WardDTO;
import com.base.admin.masterdata.entity.DmTinhthanh;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Mapper
public interface DmTinhthanhMapper {
    int insert(DmTinhthanh row);

    int insertSelective(DmTinhthanh row);

    DmTinhthanh selectByPrimaryKey(String id);

    long countPaged(@Param("search") DmTinhthanh search, @Param("exact") boolean exact);

    List<DmTinhthanh> searchPaged(@Param("search") DmTinhthanh search, @Param("pageable") Pageable pageable, @Param("exact") boolean exact);

    long countlistCities();

    List<CityDTO> listCities(@Param("pageable") Pageable pageable);

    long countDistrictByCityId(@Param("cityid") String cityid);

    List<DistrictDTO> listDistrictByCityId(@Param("pageable") Pageable pageable, @Param("cityid") String cityid);

    long countWardsByCityIdAndDistrictId(@Param("cityid") String cityid, @Param("districtid") String districtid);

    List<WardDTO> listWardsByCityIdAndDistrictId(@Param("pageable") Pageable pageable, @Param("cityid") String cityid, @Param("districtid") String districtid);
}