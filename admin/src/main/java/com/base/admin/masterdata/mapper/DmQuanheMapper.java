package com.base.admin.masterdata.mapper;

import com.base.admin.masterdata.entity.DmQuanhe;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Mapper
public interface DmQuanheMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DmQuanhe row);

    int insertSelective(DmQuanhe row);

    DmQuanhe selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DmQuanhe row);

    int updateByPrimaryKey(DmQuanhe row);

    long countPaged(@Param("search") DmQuanhe search, @Param("exact") boolean exact);

    List<DmQuanhe> searchPaged(@Param("search") DmQuanhe search, @Param("pageable") Pageable pageable, @Param("exact") boolean exact);
}