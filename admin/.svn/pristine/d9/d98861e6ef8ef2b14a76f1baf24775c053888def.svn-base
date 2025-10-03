package com.base.admin.mapper;

import java.util.List;
import java.util.UUID;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.base.admin.entity.Permissions;

@Mapper
public interface PermissionsMapper {
    int deleteByPrimaryKey(
            @Param("roleid") UUID roleid,
            @Param("moduleid") UUID moduleid,
            @Param("pageid") UUID pageid,
            @Param("actionid") UUID actionid);

    int insert(Permissions row);

    int insertSelective(Permissions row);

    @Delete("delete from permissions")
    int deleteAll();

    int saveAll(@Param("list") List<Permissions> list);

    @Delete(
            "DELETE FROM permissions WHERE roleid=#{roleid,jdbcType=OTHER,typeHandler=UUIDTypeHandler} AND moduleid=#{moduleid,jdbcType=OTHER,typeHandler=UUIDTypeHandler}")
    int deleteByRoleIdAndModuleId(@Param("roleid") UUID roleid, @Param("moduleid") UUID moduleid);

    int updateListPermission(@Param("list") List<Permissions> list);
}
