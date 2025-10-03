package com.base.admin.mapper;

import com.base.admin.entity.Tokens;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

import java.util.UUID;

@Mapper
public interface TokensMapper {
    int deleteById(UUID tokenid);

    int insert(Tokens row);


    Tokens findById(UUID tokenid);


    int update(Tokens row);

    @Delete("delete from tokens")
    int deleteAll();
}