package com.base.admin.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Builder
@Setter
@Getter
public class UsersAuthorities {
    private UUID userid;

    private UUID authorityid;

    public UsersAuthorities(UUID userid, UUID authorityid) {
        this.userid = userid;
        this.authorityid = authorityid;
    }
}