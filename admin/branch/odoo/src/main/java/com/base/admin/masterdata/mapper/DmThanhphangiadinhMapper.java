package com.base.admin.masterdata.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import com.base.admin.masterdata.entity.DmThanhphangiadinh;

@Mapper
public interface DmThanhphangiadinhMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DmThanhphangiadinh row);

    int insertSelective(DmThanhphangiadinh row);

    DmThanhphangiadinh selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DmThanhphangiadinh row);

    int updateByPrimaryKey(DmThanhphangiadinh row);

    long countPaged(@Param("search") DmThanhphangiadinh search, @Param("exact") boolean exact);

    List<DmThanhphangiadinh> searchPaged(
            @Param("search") DmThanhphangiadinh search,
            @Param("pageable") Pageable pageable,
            @Param("exact") boolean exact);
}
