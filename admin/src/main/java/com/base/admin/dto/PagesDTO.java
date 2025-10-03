package com.base.admin.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PagesDTO {
    List<PermissionsDTO> permissions;
    private UUID pageid;
    private UUID moduleid;
    private UUID roleid;
    private UUID parentpageid;
    private String pagename;
    private String href;
    private String icon;
    private String description;
    private Boolean istitle;
    private Integer position;
    private Boolean active;
    private boolean isselected;
}
