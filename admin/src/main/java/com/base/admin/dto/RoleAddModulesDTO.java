package com.base.admin.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class RoleAddModulesDTO {
    private UUID roleid;
    private List<UUID> moduleid;
}
