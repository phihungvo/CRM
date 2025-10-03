package com.base.admin.dto;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MenuInitDTO {
    private UUID id;
    private String pagename;
    private String modulename;
    private Boolean istitle;
    private String href;
    private String icon;
    private Integer order;
    private Boolean active;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<MenuInitDTO> childMenu;
}
