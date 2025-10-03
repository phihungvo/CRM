package com.base.admin.mapper;

import java.util.List;
import java.util.UUID;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.base.admin.entity.Rolemodulepage;

@Mapper
public interface RolemodulepageMapper {
    int deleteByPrimaryKey(
            @Param("roleid") UUID roleid, @Param("moduleid") UUID moduleid, @Param("pageid") UUID pageid);

    int insert(Rolemodulepage row);

    int insertSelective(Rolemodulepage row);

    int saveAll(@Param("list") List<Rolemodulepage> list);

    @Delete("DELETE FROM rolemodulepage")
    int deleteAll();

    int updateFieldSelectted(Rolemodulepage row);

    @Delete(
            "DELETE FROM rolemodulepage WHERE roleid=#{roleid,jdbcType=OTHER,typeHandler=UUIDTypeHandler} AND moduleid=#{moduleid,jdbcType=OTHER,typeHandler=UUIDTypeHandler}")
    int deleteByRoleIdAndModuleId(@Param("roleid") UUID roleid, @Param("moduleid") UUID moduleid);
}
