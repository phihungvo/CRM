package com.base.admin.mapper;

import java.util.UUID;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

import com.base.admin.entity.Tokens;

@Mapper
public interface TokensMapper {
    int deleteById(UUID tokenid);

    int insert(Tokens row);

    Tokens findById(UUID tokenid);

    int update(Tokens row);

    @Delete("delete from tokens")
    int deleteAll();
}
