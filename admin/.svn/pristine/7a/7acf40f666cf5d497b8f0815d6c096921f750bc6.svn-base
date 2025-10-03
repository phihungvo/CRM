package com.base.admin.hrm.mapper;

import com.base.admin.hrm.dto.DismissionsDTO;
import com.base.admin.hrm.entity.Dismissions;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

@Mapper
public interface DismissionsMapper {
    int deleteByPrimaryKey(UUID dismissionid);

    int insert(Dismissions record);

    int insertSelective(Dismissions record);

    Dismissions selectByPrimaryKey(UUID dismissionid);

    int updateByPrimaryKeySelective(Dismissions record);

    int updateByPrimaryKey(Dismissions record);

    DismissionsDTO findById(@Param("dismissionid") UUID dismissionid);

    List<DismissionsDTO> searchPaged(@Param("search") DismissionsDTO search, @Param("pageable") Pageable pageable, @Param("exact") boolean exact);

    long countPaged(@Param("search") DismissionsDTO search, @Param("exact") boolean exact);

    @Select("SELECT EXISTS(SELECT 1 FROM dismissions WHERE dismissionid=#{dismissionid,jdbcType=OTHER,typeHandler=UUIDTypeHandler})")
    boolean existsById(@Param("dismissionid") UUID dismissionid);

    int deleteByPrimaryKeys(List<UUID> listDismissionids);
}
