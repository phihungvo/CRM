package com.base.admin.hrm.mapper;

import com.base.admin.hrm.dto.AccomplishmentsDTO;
import com.base.admin.hrm.entity.Accomplishments;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

@Mapper
public interface AccomplishmentsMapper {
    int deleteByPrimaryKey(UUID accomplishmentid);

    int insert(Accomplishments record);

    int insertSelective(Accomplishments record);

    Accomplishments selectByPrimaryKey(UUID accomplishmentid);

    int updateByPrimaryKeySelective(Accomplishments record);

    int updateByPrimaryKey(Accomplishments record);

    AccomplishmentsDTO findById(@Param("accomplishmentid") UUID accomplishmentid);

    List<AccomplishmentsDTO> searchPaged(@Param("search") AccomplishmentsDTO search, @Param("pageable") Pageable pageable, @Param("exact") boolean exact);

    long countPaged(@Param("search") AccomplishmentsDTO search, @Param("exact") boolean exact);

}