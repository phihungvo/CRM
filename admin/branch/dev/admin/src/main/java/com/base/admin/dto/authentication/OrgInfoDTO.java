package com.base.admin.dto.authentication;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrgInfoDTO {
    private UUID organizationid;
    private String organizationname;
    private Boolean isDefault;
}
