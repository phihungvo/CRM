package com.base.admin.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.base.admin.jwt.JwtUsers;

@Mapper
public interface JwtUsersMapper {
    JwtUsers loadJwtUserByUsername(@Param("username") String username);
}
