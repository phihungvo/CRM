package com.base.admin.masterdata.entity;

import lombok.*;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DmNganhnghe {
    private Integer id;

    private String facutyName;

    private String code;

    private Integer position;

    private Boolean isFavorite;

    private Boolean isSystem;
}