package com.base.admin.entity;

import java.util.UUID;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class Tokens {
    private UUID tokenid;

    private UUID userid;

    private String token;

    private Boolean revoked;

    private Boolean expired;
}
