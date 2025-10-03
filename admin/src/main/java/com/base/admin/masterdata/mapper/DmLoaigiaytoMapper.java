package com.base.admin.masterdata.mapper;

import com.base.admin.masterdata.entity.DmLoaigiayto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Mapper
public interface DmLoaigiaytoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DmLoaigiayto row);

    int insertSelective(DmLoaigiayto row);

    DmLoaigiayto selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DmLoaigiayto row);

    int updateByPrimaryKey(DmLoaigiayto row);

    long countPaged(@Param("search") DmLoaigiayto search, @Param("exact") boolean exact);

    List<DmLoaigiayto> searchPaged(@Param("search") DmLoaigiayto search, @Param("pageable") Pageable pageable, @Param("exact") boolean exact);
}