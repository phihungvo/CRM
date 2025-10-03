package com.base.admin.dto.authentication;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrgInfoDTO {
    private UUID organizationid;
    private String organizationname;
    private Boolean isDefault;
}
