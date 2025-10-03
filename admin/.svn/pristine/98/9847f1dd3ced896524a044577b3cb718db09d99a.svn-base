package com.base.admin.entity;

import java.util.Date;
import java.util.UUID;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class Roles {
    private UUID roleid;

    private UUID organizationid;

    private String rolename;

    private String description;

    private Integer roletype;

    private Date createdate;

    private Date modifieddate;

    private String userupdate;

    private Boolean active;

    public Roles(UUID roleid, UUID organizationId, String rolename, Integer roletype, Boolean active) {
        this.roleid = roleid;
        this.organizationid = organizationId;
        this.rolename = rolename;
        this.roletype = roletype;
        this.active = active;
    }

    public Roles(
            UUID roleid,
            UUID organizationid,
            String rolename,
            String description,
            Integer roletype,
            Date createdate,
            Date modifieddate,
            String userupdate,
            Boolean active) {
        this.roleid = roleid;
        this.organizationid = organizationid;
        this.rolename = rolename;
        this.description = description;
        this.roletype = roletype;
        this.createdate = createdate;
        this.modifieddate = modifieddate;
        this.userupdate = userupdate;
        this.active = active;
    }

    //    public void updateFromDTO(RolesDTO dto) {
    //        JSONObject json = ClassUtils.convertDTOToJSON(dto);
    //        this.roleid = dto.getRoleid();
    //        this.organizationid = (ClassUtils.existsParameter(json, "organizationid") ? dto.getOrganizationid() :
    // this.organizationid);
    //        this.rolename = (ClassUtils.existsParameter(json, "rolename") ? dto.getRolename() : this.rolename);
    //        this.roletype = (ClassUtils.existsParameter(json, "roletype") ? dto.getRoletype() : this.roletype);
    //        this.active = (ClassUtils.existsParameter(json, "active") ? dto.getActive() : this.active);
    //    }
}
