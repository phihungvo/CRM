package com.base.admin.masterdata.entity;

import lombok.*;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DmGioitinh {
    private Integer id;

    private String description;

    private Boolean isSystem;
    private Integer position;
}
