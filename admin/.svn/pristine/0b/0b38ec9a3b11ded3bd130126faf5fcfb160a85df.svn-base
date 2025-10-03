package com.base.admin.masterdata.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import com.base.admin.masterdata.entity.DmNganhnghe;

@Mapper
public interface DmNganhngheMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DmNganhnghe row);

    int insertSelective(DmNganhnghe row);

    DmNganhnghe selectByPrimaryKey(Integer id);

    long countPaged(@Param("search") DmNganhnghe search, @Param("exact") boolean exact);

    List<DmNganhnghe> searchPaged(
            @Param("search") DmNganhnghe search, @Param("pageable") Pageable pageable, @Param("exact") boolean exact);
}
