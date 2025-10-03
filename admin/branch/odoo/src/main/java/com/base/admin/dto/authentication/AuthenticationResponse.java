package com.base.admin.dto.authentication;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuthenticationResponse {

    @JsonProperty("access_token")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String accessToken;

    @JsonProperty("userinfo")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private UserInfoDTO userinfo;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("menus")
    private List<MenuDTO> menus;
}
