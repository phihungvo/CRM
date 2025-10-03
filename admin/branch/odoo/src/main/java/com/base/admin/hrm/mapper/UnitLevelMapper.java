package com.base.admin.hrm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import com.base.admin.hrm.entity.UnitLevel;

@Mapper
public interface UnitLevelMapper {
    int deleteByPrimaryKey(Integer unitlevelid);

    int insert(UnitLevel row);

    int insertSelective(UnitLevel row);

    UnitLevel selectByPrimaryKey(Integer unitlevelid);

    int updateByPrimaryKeySelective(UnitLevel row);

    int updateByPrimaryKey(UnitLevel row);

    long countPaged(@Param("level") Integer level);

    List<UnitLevel> searchPaged(@Param("level") Integer level, @Param("pageable") Pageable pageable);
}
