package com.base.admin.mapper;

import com.base.admin.entity.Actions;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.UUID;

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