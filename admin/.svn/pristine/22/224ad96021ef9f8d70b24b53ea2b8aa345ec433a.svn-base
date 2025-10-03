package com.base.admin.masterdata.mapper;

import com.base.admin.masterdata.entity.DmThanhphancanhan;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Mapper
public interface DmThanhphancanhanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DmThanhphancanhan row);

    int insertSelective(DmThanhphancanhan row);

    DmThanhphancanhan selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DmThanhphancanhan row);

    int updateByPrimaryKey(DmThanhphancanhan row);

    long countPaged(@Param("search") DmThanhphancanhan search, @Param("exact") boolean exact);

    List<DmThanhphancanhan> searchPaged(@Param("search") DmThanhphancanhan search, @Param("pageable") Pageable pageable, @Param("exact") boolean exact);
}