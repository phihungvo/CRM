package com.base.admin.hrm.dto;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.*;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UnitItemDTO {
    private UUID unitid;
    private UUID parentunitid;
    private String unitcode;
    private Integer unitlevelid;
    private String unitname;
    private int level;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<UnitItemDTO> childItem;
}
