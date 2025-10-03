package com.base.admin.dto.authentication;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserInfoDTO {
    private UUID userid;
    private String username;
    private String fullname;
    private String jobtitle;
    private Integer usertype;
    private Integer status;

    // ad TYpe
    private List<OrgInfoDTO> orgs;
}
