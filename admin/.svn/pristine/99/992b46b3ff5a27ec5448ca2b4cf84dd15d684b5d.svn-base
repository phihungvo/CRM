package com.base.admin.hrm.mapper;

import java.util.List;
import java.util.UUID;

import com.base.admin.hrm.entity.Avatars;

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
