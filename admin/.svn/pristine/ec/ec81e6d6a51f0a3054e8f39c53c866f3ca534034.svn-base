package com.base.admin.mapper;

import com.base.admin.entity.UsersAuthorities;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.UUID;

@Mapper
public interface UsersAuthoritiesMapper {
    int insert(UsersAuthorities row);

    int saveAll(@Param("list") List<UsersAuthorities> list);

    int deleteById(@Param("userid") UUID userid, @Param("authorityid") UUID authorityid);

    int deleteListByUserIds(@Param("list") List<UUID> list);

    @Delete("DELETE FROM users_authorities WHERE userid=#{userid,jdbcType=OTHER,typeHandler=UUIDTypeHandler}")
    int deleteByUserId(@Param("userid") UUID userid);

    @Delete("DELETE FROM users_authorities")
    int deleteAll();
}