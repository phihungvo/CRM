package com.base.admin.masterdata.entity;

import lombok.*;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DmTinhtrangbaohiem {
    private Integer id;

    private String description;

    private Boolean isSystem;
    private Integer position;
}