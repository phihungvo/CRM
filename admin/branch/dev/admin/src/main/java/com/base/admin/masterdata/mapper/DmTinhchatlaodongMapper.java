package com.base.admin.masterdata.mapper;

import com.base.admin.masterdata.entity.DmTinhchatlaodong;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Mapper
public interface DmTinhchatlaodongMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DmTinhchatlaodong row);

    int insertSelective(DmTinhchatlaodong row);

    DmTinhchatlaodong selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DmTinhchatlaodong row);

    int updateByPrimaryKey(DmTinhchatlaodong row);

    long countPaged(@Param("search") DmTinhchatlaodong search, @Param("exact") boolean exact);

    List<DmTinhchatlaodong> searchPaged(@Param("search") DmTinhchatlaodong search, @Param("pageable") Pageable pageable, @Param("exact") boolean exact);
}