package com.base.admin.hrm.mapper;

import com.base.admin.hrm.dto.DisplacementsDTO;
import com.base.admin.hrm.entity.Displacements;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

@Mapper
public interface DisplacementsMapper {
    int deleteByPrimaryKey(UUID displacementid);

    int insert(Displacements record);

    int insertSelective(Displacements record);

    Displacements selectByPrimaryKey(UUID displacementid);

    int updateByPrimaryKeySelective(Displacements record);

    int updateByPrimaryKey(Displacements record);

    DisplacementsDTO findById(@Param("displacementid") UUID displacementid);

    List<DisplacementsDTO> searchPaged(@Param("search") DisplacementsDTO search, @Param("pageable") Pageable pageable, @Param("exact") boolean exact);

    long countPaged(@Param("search") DisplacementsDTO search, @Param("exact") boolean exact);

    @Select("SELECT EXISTS(SELECT 1 FROM displacements WHERE displacementid=#{displacementid,jdbcType=OTHER,typeHandler=UUIDTypeHandler})")
    boolean existsById(@Param("displacementid") UUID displacementid);

    int deleteByPrimaryKeys(List<UUID> listDisplacementids);
}
