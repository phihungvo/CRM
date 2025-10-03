package com.base.admin.masterdata.mapper;

import com.base.admin.masterdata.entity.DmTinhtranghonnhan;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Mapper
public interface DmTinhtranghonnhanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DmTinhtranghonnhan row);

    int insertSelective(DmTinhtranghonnhan row);

    DmTinhtranghonnhan selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DmTinhtranghonnhan row);

    int updateByPrimaryKey(DmTinhtranghonnhan row);

    long countPaged(@Param("search") DmTinhtranghonnhan search, @Param("exact") boolean exact);

    List<DmTinhtranghonnhan> searchPaged(@Param("search") DmTinhtranghonnhan search, @Param("pageable") Pageable pageable, @Param("exact") boolean exact);
}