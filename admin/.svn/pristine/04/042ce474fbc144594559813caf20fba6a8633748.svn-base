package com.base.admin.entity;

import java.util.UUID;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class Modules {
    private UUID moduleid;

    private String modulename;

    private String description;

    private Integer position;

    private Integer moduletype;

    private Boolean active;

    public Modules(
            UUID moduleid,
            String modulename,
            String description,
            Integer position,
            Integer moduletype,
            Boolean active) {
        this.moduleid = moduleid;
        this.modulename = modulename;
        this.description = description;
        this.position = position;
        this.moduletype = moduletype;
        this.active = active;
    }

    public Modules(UUID moduleid, String modulename, String description, Integer moduletype, Integer position) {
        this.moduleid = moduleid;
        this.modulename = modulename;
        this.description = description;
        this.moduletype = moduletype;
        this.position = position;
        this.active = true;
    }
}
