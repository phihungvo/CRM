package com.base.admin.dto;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PermissionsDTO {
    @JsonIgnore
    private UUID roleid;

    @JsonIgnore
    private UUID moduleid;

    @JsonIgnore
    private UUID pageid;

    private boolean isselected;
    private UUID actionid;
    private String actionname;
}
