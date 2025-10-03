package com.base.admin.masterdata.mapper;

import com.base.admin.masterdata.entity.DmNganhnghe;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Mapper
public interface DmNganhngheMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DmNganhnghe row);

    int insertSelective(DmNganhnghe row);

    DmNganhnghe selectByPrimaryKey(Integer id);

    long countPaged(@Param("search") DmNganhnghe search, @Param("exact") boolean exact);

    List<DmNganhnghe> searchPaged(@Param("search") DmNganhnghe search, @Param("pageable") Pageable pageable, @Param("exact") boolean exact);
}