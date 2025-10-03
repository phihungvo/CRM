package com.base.admin.entity;

import java.util.UUID;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class Pages {
    private UUID pageid;

    private UUID moduleid;

    private UUID parentpageid;

    private String pagename;

    private String href;

    private String icon;

    private String description;

    private Boolean istitle;

    private Integer position;

    private Boolean active;

    public Pages(
            UUID pageid,
            UUID moduleid,
            UUID parentpageid,
            String pagename,
            String href,
            String icon,
            String description,
            Boolean istitle,
            Integer position,
            Boolean active) {
        this.pageid = pageid;
        this.moduleid = moduleid;
        this.parentpageid = parentpageid;
        this.pagename = pagename;
        this.href = href;
        this.icon = icon;
        this.description = description;
        this.istitle = istitle;
        this.position = position;
        this.active = active;
    }
}
