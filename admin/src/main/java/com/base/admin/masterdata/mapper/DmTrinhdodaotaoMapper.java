package com.base.admin.masterdata.mapper;

import com.base.admin.masterdata.entity.DmTrinhdodaotao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Mapper
public interface DmTrinhdodaotaoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DmTrinhdodaotao row);

    int insertSelective(DmTrinhdodaotao row);

    DmTrinhdodaotao selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DmTrinhdodaotao row);

    int updateByPrimaryKey(DmTrinhdodaotao row);

    long countPaged(@Param("search") DmTrinhdodaotao search, @Param("exact") boolean exact);

    List<DmTrinhdodaotao> searchPaged(@Param("search") DmTrinhdodaotao search, @Param("pageable") Pageable pageable, @Param("exact") boolean exact);
}