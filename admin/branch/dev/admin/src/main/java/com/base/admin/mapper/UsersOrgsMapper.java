package com.base.admin.mapper;

import com.base.admin.entity.UsersOrgs;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.UUID;

@Mapper
public interface UsersOrgsMapper {
    int insert(UsersOrgs row);

    int saveAll(@Param("list") List<UsersOrgs> list);

    int deleteListByUserIds(@Param("list") List<UUID> list);

    int deleteListByIds(@Param("list") List<UsersOrgs> list);

    @Select("SELECT EXISTS(SELECT 1 FROM users_orgs WHERE organizationid=#{organizationid,jdbcType=OTHER,typeHandler=UUIDTypeHandler} AND userid=#{userid,jdbcType=OTHER,typeHandler=UUIDTypeHandler})")
    boolean existsById(@Param("organizationid") UUID organizationid, @Param("userid") UUID userid);

    @Select("SELECT EXISTS(SELECT 1 FROM users_orgs WHERE organizationid=#{organizationid,jdbcType=OTHER,typeHandler=UUIDTypeHandler})")
    boolean existsByOrganizationId(@Param("organizationid") UUID organizationid);

    int deleteById(@Param("organizationid") UUID organizationid, @Param("userid") UUID userid);

    @Delete("DELETE FROM users_orgs WHERE organizationid=#{organizationid,jdbcType=OTHER,typeHandler=UUIDTypeHandler}")
    int deleteByOrganizationId(@Param("organizationid") UUID organizationid);

    @Delete("DELETE FROM users_orgs WHERE userid=#{userid,jdbcType=OTHER,typeHandler=UUIDTypeHandler}")
    int deleteByUserId(@Param("userid") UUID userid);

    @Delete("DELETE FROM users_orgs")
    int deleteAll();
}