package com.base.admin.hrm.service;

import com.base.admin.hrm.entity.Avatars;
import com.base.admin.hrm.mapper.AvatarsMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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
