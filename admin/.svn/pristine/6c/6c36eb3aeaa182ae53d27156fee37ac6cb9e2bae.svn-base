package com.base.admin.dto;

import com.base.admin.entity.Roles;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class RolesDTO {
    private UUID roleid;

    private UUID organizationid;

    private String rolename;

    private String description;

    private Integer roletype;

    private Boolean active;

    public Roles newEntity() {
        return Roles.builder()
                .roleid(UUID.randomUUID())
                .organizationid(this.organizationid)
                .rolename(this.rolename)
                .description(this.description)
                .roletype(this.roletype)
                .createdate(new Date())
                .active(this.active == null || this.active)
                .build();
    }
}
