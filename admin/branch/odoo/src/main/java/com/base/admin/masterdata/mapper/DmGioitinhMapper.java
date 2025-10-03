package com.base.admin.masterdata.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import com.base.admin.masterdata.entity.DmGioitinh;

@Mapper
public interface DmGioitinhMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DmGioitinh row);

    int insertSelective(DmGioitinh row);

    DmGioitinh selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DmGioitinh row);

    int updateByPrimaryKey(DmGioitinh row);

    long countPaged(@Param("search") DmGioitinh search, @Param("exact") boolean exact);

    List<DmGioitinh> searchPaged(
            @Param("search") DmGioitinh search, @Param("pageable") Pageable pageable, @Param("exact") boolean exact);
}
