package com.base.admin.jwt;

import com.base.admin.entity.Authorities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.Set;
import java.util.UUID;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JwtUsers {

    private UUID userid;

    private UUID organizationid;

    private String username;

    @JsonIgnore
    private String password;

    private String fullname;

    private String jobtitle;

    private Boolean lockout;

    private Integer usertype;

    private Integer status;

    private Set<Authorities> authorities;

}
