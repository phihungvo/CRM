package com.base.admin.masterdata.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import com.base.admin.masterdata.entity.DmTrangthailamviec;

@Mapper
public interface DmTrangthailamviecMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DmTrangthailamviec row);

    int insertSelective(DmTrangthailamviec row);

    DmTrangthailamviec selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DmTrangthailamviec row);

    int updateByPrimaryKey(DmTrangthailamviec row);

    long countPaged(@Param("search") DmTrangthailamviec search, @Param("exact") boolean exact);

    List<DmTrangthailamviec> searchPaged(
            @Param("search") DmTrangthailamviec search,
            @Param("pageable") Pageable pageable,
            @Param("exact") boolean exact);
}
