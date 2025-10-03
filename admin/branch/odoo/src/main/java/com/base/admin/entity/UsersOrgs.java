package com.base.admin.entity;

import java.util.UUID;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class UsersOrgs {
    private UUID organizationid;

    private UUID userid;

    public UsersOrgs(UUID organizationid, UUID userid) {
        this.organizationid = organizationid;
        this.userid = userid;
    }
}
