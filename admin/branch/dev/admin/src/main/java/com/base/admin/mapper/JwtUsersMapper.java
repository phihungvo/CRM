package com.base.admin.mapper;

import com.base.admin.jwt.JwtUsers;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface JwtUsersMapper {
    JwtUsers loadJwtUserByUsername(@Param("username") String username);
}