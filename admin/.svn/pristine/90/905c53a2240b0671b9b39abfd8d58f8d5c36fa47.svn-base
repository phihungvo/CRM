package com.base.admin.mapper;

import java.util.List;
import java.util.UUID;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.base.admin.entity.Actions;

@Mapper
public interface ActionsMapper {
    int deleteByPrimaryKey(@Param("actionid") UUID actionid, @Param("resourceid") UUID resourceid);

    int insert(Actions row);

    int insertSelective(Actions row);

    Actions selectByPrimaryKey(@Param("actionid") UUID actionid, @Param("resourceid") UUID resourceid);

    int updateByPrimaryKeySelective(Actions row);

    int updateByPrimaryKey(Actions row);

    @Delete("delete from actions")
    int deleteAll();

    int saveAll(@Param("list") List<Actions> list);

    List<UUID> findActionIdByResourceid(@Param("resourceid") UUID resourceid);
}
