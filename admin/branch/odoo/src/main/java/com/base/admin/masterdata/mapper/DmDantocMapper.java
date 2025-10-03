package com.base.admin.masterdata.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import com.base.admin.masterdata.entity.DmDantoc;

@Mapper
public interface DmDantocMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DmDantoc row);

    int insertSelective(DmDantoc row);

    DmDantoc selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DmDantoc row);

    int updateByPrimaryKey(DmDantoc row);

    long countPaged(@Param("search") DmDantoc search, @Param("exact") boolean exact);

    List<DmDantoc> searchPaged(
            @Param("search") DmDantoc search, @Param("pageable") Pageable pageable, @Param("exact") boolean exact);
}
