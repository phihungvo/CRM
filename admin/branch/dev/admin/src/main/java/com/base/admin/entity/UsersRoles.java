package com.base.admin.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Builder
@Setter
@Getter
public class UsersRoles {
    private UUID userid;

    private UUID roleid;

    public UsersRoles(UUID userid, UUID roleid) {
        this.userid = userid;
        this.roleid = roleid;
    }
}