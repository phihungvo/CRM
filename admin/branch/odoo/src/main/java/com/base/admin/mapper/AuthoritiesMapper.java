package com.base.admin.mapper;

import java.util.List;
import java.util.UUID;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.base.admin.entity.Authorities;

@Mapper
public interface AuthoritiesMapper {
    Authorities findById(UUID authorityid);

    int insert(Authorities row);

    int saveAll(@Param("list") List<Authorities> list);

    int update(Authorities row);

    int deleteById(UUID authorityid);

    @Delete("DELETE FROM authorities")
    int deleteAll();

    List<UUID> getIdsByName(@Param("list") List<String> list);
}
