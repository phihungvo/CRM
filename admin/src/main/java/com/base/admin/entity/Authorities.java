package com.base.admin.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Builder
@Setter
@Getter
public class Authorities {
    private UUID authorityid;

    private String authorityname;

    public Authorities(String authorityname) {
        this.authorityname = authorityname;
    }

    public Authorities(UUID authorityid, String authorityname) {
        this.authorityid = authorityid;
        this.authorityname = authorityname;
    }
}