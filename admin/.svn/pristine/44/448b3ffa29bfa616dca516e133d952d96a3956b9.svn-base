package com.base.admin.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Builder
@Setter
@Getter
public class Organizations {
    private UUID organizationid;

    private UUID parentorganizationid;

    private String organizationname;

    private Date createdate;

    private Date modifieddate;

    private String userupdate;

    private Boolean active;

    public Organizations(UUID organizationid, String organizationname, Boolean active) {
        this.organizationid = organizationid;
        this.organizationname = organizationname;
        this.active = active;
    }

    public Organizations(UUID organizationid, UUID parentorganizationid, String organizationname, Date createdate, Date modifieddate, String userupdate, Boolean active) {
        this.organizationid = organizationid;
        this.parentorganizationid = parentorganizationid;
        this.organizationname = organizationname;
        this.createdate = createdate;
        this.modifieddate = modifieddate;
        this.userupdate = userupdate;
        this.active = active;
    }

//    public void updateFromDTO(OrganizationsDTO dto) {
//        this.organizationid = dto.getOrganizationid();
//        this.parentorganizationid = (dto.getParentorganizationid() == null? this.organizationid : dto.getParentorganizationid());
//        this.organizationname = dto.getOrganizationname();
////        this.modifieddate = modifieddate;
////        this.userupdate = userupdate;
//        this.active = (dto.getActive() == null ? (this.active == null ? false : this.active) : dto.getActive());
//    }
}