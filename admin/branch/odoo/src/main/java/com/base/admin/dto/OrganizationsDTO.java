package com.base.admin.dto;

import java.util.UUID;

import com.base.admin.entity.Organizations;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrganizationsDTO {
    private UUID organizationid;

    private UUID parentorganizationid;

    private String organizationname;

    private Boolean active;

    public Organizations newEntity() {
        return Organizations.builder()
                .organizationid(UUID.randomUUID())
                .parentorganizationid(this.parentorganizationid)
                .organizationname(this.organizationname)
                .active(this.active == null || this.active)
                .build();
    }
}
