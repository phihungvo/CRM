package com.base.admin.mapper;

import java.util.List;
import java.util.UUID;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.base.admin.entity.RolesModules;

@Mapper
public interface RolesModulesMapper {
    @Select(
            "SELECT EXISTS(SELECT 1 FROM roles_modules WHERE roleid=#{roleid,jdbcType=OTHER,typeHandler=UUIDTypeHandler} AND moduleid=#{moduleid,jdbcType=OTHER,typeHandler=UUIDTypeHandler})")
    boolean existsById(@Param("roleid") UUID roleid, @Param("moduleid") UUID moduleid);

    int insert(RolesModules row);

    @Delete("DELETE FROM roles_modules")
    int deleteAll();

    int saveAll(@Param("list") List<RolesModules> list);

    @Delete(
            "DELETE FROM roles_modules WHERE roleid IN (SELECT roles_modules.roleid FROM roles_modules INNER JOIN roles ON roles_modules.roleid = roles.roleid WHERE roles.organizationid = #{organizationid,jdbcType=OTHER,typeHandler=UUIDTypeHandler})")
    int deleteByOrganizationId(@Param("organizationid") UUID organizationid);

    //    @Delete("DELETE FROM roles_modules WHERE roleid=#{roleid,jdbcType=OTHER,typeHandler=UUIDTypeHandler} AND
    // moduleid=#{moduleid,jdbcType=OTHER,typeHandler=UUIDTypeHandler}")
    int deleteById(@Param("roleid") UUID roleid, @Param("moduleid") UUID moduleid);

    @Delete("DELETE FROM roles_modules WHERE roleid=#{roleid,jdbcType=OTHER,typeHandler=UUIDTypeHandler}")
    int deleteByRoleId(@Param("roleid") UUID roleid);

    int deleteListByIds(@Param("list") List<RolesModules> list);

    List<RolesModules> findAll();
}
