package com.base.admin.masterdata.mapper;

import com.base.admin.masterdata.entity.DmGioitinh;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Mapper
public interface DmGioitinhMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DmGioitinh row);

    int insertSelective(DmGioitinh row);

    DmGioitinh selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DmGioitinh row);

    int updateByPrimaryKey(DmGioitinh row);

    long countPaged(@Param("search") DmGioitinh search, @Param("exact") boolean exact);

    List<DmGioitinh> searchPaged(@Param("search") DmGioitinh search, @Param("pageable") Pageable pageable, @Param("exact") boolean exact);
}