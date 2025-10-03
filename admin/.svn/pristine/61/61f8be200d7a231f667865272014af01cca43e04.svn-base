package com.base.admin.hrm.mapper;

import com.base.admin.hrm.dto.DesignationsDTO;
import com.base.admin.hrm.entity.Designations;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

@Mapper
public interface DesignationsMapper {
    int deleteByPrimaryKey(UUID designateid);

    int insert(Designations record);

    int insertSelective(Designations record);

    Designations selectByPrimaryKey(UUID designateid);

    int updateByPrimaryKeySelective(Designations record);

    int updateByPrimaryKey(Designations record);

    DesignationsDTO findById(@Param("designateid") UUID designateid);

    List<DesignationsDTO> searchPaged(@Param("search") DesignationsDTO search, @Param("pageable") Pageable pageable, @Param("exact") boolean exact);

    long countPaged(@Param("search") DesignationsDTO search, @Param("exact") boolean exact);

    @Select("SELECT EXISTS(SELECT 1 FROM designations WHERE designateid=#{designateid,jdbcType=OTHER,typeHandler=UUIDTypeHandler})")
    boolean existsById(@Param("designateid") UUID designateid);

    int deleteByPrimaryKeys(List<UUID> listDesignateids);
}
