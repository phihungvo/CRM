package com.base.admin.hrm.service;

import java.util.List;
import java.util.UUID;

import com.base.admin.hrm.entity.Avatars;

public interface AvatarService {
    Avatars getBase64avatarByEmployeeId(UUID userid);

    List<Avatars> getBase64avatarsByUserIds(List<UUID> userIds);
}
