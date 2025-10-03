package com.base.admin.hrm.mapper;

import com.base.admin.hrm.entity.Avatars;

import java.util.List;
import java.util.UUID;

public interface AvatarsMapper {
    int deleteByPrimaryKey(UUID userid);

    int insert(Avatars record);

    int insertSelective(Avatars record);

    Avatars selectByPrimaryKey(UUID userid);

    int updateByPrimaryKeySelective(Avatars record);

    int updateByPrimaryKeyWithBLOBs(Avatars record);

    int updateByPrimaryKey(Avatars record);

    List<Avatars> selectByPrimaryKeys(List<UUID> userIds);
}