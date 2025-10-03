package com.base.admin.mapper;

import java.util.List;
import java.util.UUID;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.base.admin.entity.UsersRoles;

@Mapper
public interface UsersRolesMapper {
    @Select(
            "SELECT EXISTS(SELECT 1 FROM users_roles WHERE userid=#{userid,jdbcType=OTHER,typeHandler=UUIDTypeHandler} AND roleid=#{roleid,jdbcType=OTHER,typeHandler=UUIDTypeHandler})")
    boolean existsById(@Param("userid") UUID userid, @Param("roleid") UUID roleid);

    int insert(UsersRoles row);

    int saveAll(@Param("list") List<UsersRoles> list);

    int deleteListByUserIds(@Param("list") List<UUID> list);

    @Delete("DELETE FROM users_roles WHERE userid=#{userid,jdbcType=OTHER,typeHandler=UUIDTypeHandler}")
    int deleteByUserId(@Param("userid") UUID userid);

    @Delete(
            "DELETE FROM users_roles WHERE roleid IN (SELECT users_roles.roleid  FROM users_roles INNER JOIN roles ON users_roles.roleid = roles.roleid  WHERE roles.organizationid = #{organizationid,jdbcType=OTHER,typeHandler=UUIDTypeHandler})")
    int deleteByOrganizationId(@Param("organizationid") UUID organizationid);

    int deleteById(@Param("userid") UUID userid, @Param("roleid") UUID roleid);

    @Delete("DELETE FROM users_roles WHERE roleid=#{roleid,jdbcType=OTHER,typeHandler=UUIDTypeHandler}")
    int deleteByRoleId(@Param("roleid") UUID roleid);

    int deleteListByIds(@Param("list") List<UsersRoles> list);

    @Delete("DELETE FROM users_roles")
    int deleteAll();
}
