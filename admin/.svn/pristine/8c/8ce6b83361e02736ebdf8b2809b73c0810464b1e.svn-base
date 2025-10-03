package com.base.admin.dto.authentication;

import com.base.admin.dto.PermissionsDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;


@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MenuDTO {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    List<PermissionsDTO> permissions;
    private UUID pageid;
    private UUID parentpageid;
    private String pagename;
    private String href;
    private String icon;
    private String description;
    private Boolean istitle;
    private Integer position;
    private Boolean active;
    @JsonIgnore
    private UUID roleid;
    @JsonIgnore
    private UUID moduleid;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<MenuDTO> childMenu;
}
