package com.base.admin.masterdata.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import com.base.admin.masterdata.entity.DmTruongdaihoc;

@Mapper
public interface DmTruongdaihocMapper {
    int insert(DmTruongdaihoc row);

    int insertSelective(DmTruongdaihoc row);

    DmTruongdaihoc selectByPrimaryKey(Integer id);

    long countPaged(@Param("search") DmTruongdaihoc search, @Param("exact") boolean exact);

    List<DmTruongdaihoc> searchPaged(
            @Param("search") DmTruongdaihoc search,
            @Param("pageable") Pageable pageable,
            @Param("exact") boolean exact);
}
