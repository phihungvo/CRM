package com.base.admin.masterdata.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import com.base.admin.masterdata.entity.DmNoicap;

@Mapper
public interface DmNoicapMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DmNoicap row);

    int insertSelective(DmNoicap row);

    DmNoicap selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DmNoicap row);

    int updateByPrimaryKey(DmNoicap row);

    long countPaged(@Param("search") DmNoicap search, @Param("exact") boolean exact);

    List<DmNoicap> searchPaged(
            @Param("search") DmNoicap search, @Param("pageable") Pageable pageable, @Param("exact") boolean exact);
}
