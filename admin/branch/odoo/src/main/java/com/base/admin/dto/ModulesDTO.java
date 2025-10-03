package com.base.admin.dto;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ModulesDTO {
    private UUID moduleid;

    private String modulename;

    private String description;

    private Integer position;

    private Integer moduletype;

    private Boolean active;
}
