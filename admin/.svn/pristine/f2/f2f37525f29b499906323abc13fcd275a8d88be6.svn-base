package com.base.admin.masterdata.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import com.base.admin.masterdata.entity.DmXeploai;

@Mapper
public interface DmXeploaiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DmXeploai row);

    int insertSelective(DmXeploai row);

    DmXeploai selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DmXeploai row);

    int updateByPrimaryKey(DmXeploai row);

    long countPaged(@Param("search") DmXeploai search, @Param("exact") boolean exact);

    List<DmXeploai> searchPaged(
            @Param("search") DmXeploai search, @Param("pageable") Pageable pageable, @Param("exact") boolean exact);
}
