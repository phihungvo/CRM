package com.base.admin.masterdata.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import com.base.admin.masterdata.entity.DmTinhtranghonnhan;

@Mapper
public interface DmTinhtranghonnhanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DmTinhtranghonnhan row);

    int insertSelective(DmTinhtranghonnhan row);

    DmTinhtranghonnhan selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DmTinhtranghonnhan row);

    int updateByPrimaryKey(DmTinhtranghonnhan row);

    long countPaged(@Param("search") DmTinhtranghonnhan search, @Param("exact") boolean exact);

    List<DmTinhtranghonnhan> searchPaged(
            @Param("search") DmTinhtranghonnhan search,
            @Param("pageable") Pageable pageable,
            @Param("exact") boolean exact);
}
