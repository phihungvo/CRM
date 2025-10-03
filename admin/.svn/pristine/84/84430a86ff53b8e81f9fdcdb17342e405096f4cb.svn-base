package com.base.admin.masterdata.mapper;

import com.base.admin.masterdata.entity.DmTongiao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Mapper
public interface DmTongiaoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DmTongiao row);

    int insertSelective(DmTongiao row);

    DmTongiao selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DmTongiao row);

    int updateByPrimaryKey(DmTongiao row);

    long countPaged(@Param("search") DmTongiao search, @Param("exact") boolean exact);

    List<DmTongiao> searchPaged(@Param("search") DmTongiao search, @Param("pageable") Pageable pageable, @Param("exact") boolean exact);
}