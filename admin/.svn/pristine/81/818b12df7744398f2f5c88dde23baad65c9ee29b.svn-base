package com.base.admin.masterdata.mapper;

import com.base.admin.masterdata.entity.DmLoaihopdong;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Mapper
public interface DmLoaihopdongMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DmLoaihopdong row);

    int insertSelective(DmLoaihopdong row);

    DmLoaihopdong selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DmLoaihopdong row);

    int updateByPrimaryKey(DmLoaihopdong row);

    long countPaged(@Param("search") DmLoaihopdong search, @Param("exact") boolean exact);

    List<DmLoaihopdong> searchPaged(@Param("search") DmLoaihopdong search, @Param("pageable") Pageable pageable, @Param("exact") boolean exact);
}