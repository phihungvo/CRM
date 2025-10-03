package com.base.admin.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Builder
@Setter
@Getter
public class RolesModules {
    private UUID roleid;

    private UUID moduleid;

    public RolesModules(UUID roleid, UUID moduleid) {
        this.roleid = roleid;
        this.moduleid = moduleid;
    }
}