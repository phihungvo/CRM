package com.base.admin.masterdata.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import com.base.admin.masterdata.entity.DmNganhang;

@Mapper
public interface DmNganhangMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DmNganhang record);

    DmNganhang selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(DmNganhang record);

    long countPaged(@Param("search") DmNganhang search, @Param("exact") boolean exact);

    List<DmNganhang> searchPaged(
            @Param("search") DmNganhang search, @Param("pageable") Pageable pageable, @Param("exact") boolean exact);
}
