package com.base.admin.hrm.entity;

import lombok.*;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class JobLevel {
    private Integer joblevelid;

    private String joblevelname;

    private Integer position;

    private Boolean isFavorite;

    private Boolean isSystem;
}