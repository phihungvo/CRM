package com.base.admin.hrm.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.base.admin.hrm.entity.Avatars;
import com.base.admin.hrm.mapper.AvatarsMapper;

@Service
public class AvatarServiceImpl implements AvatarService {
    private final AvatarsMapper avatarsMapper;

    public AvatarServiceImpl(AvatarsMapper avatarsMapper) {
        this.avatarsMapper = avatarsMapper;
    }

    @Override
    public Avatars getBase64avatarByEmployeeId(UUID userid) {
        return avatarsMapper.selectByPrimaryKey(userid);
    }

    @Override
    public List<Avatars> getBase64avatarsByUserIds(List<UUID> userIds) {
        return avatarsMapper.selectByPrimaryKeys(userIds);
    }
}
