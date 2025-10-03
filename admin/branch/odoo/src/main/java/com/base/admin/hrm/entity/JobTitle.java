package com.base.admin.hrm.entity;

import lombok.*;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class JobTitle {
    private Integer jobtitleid;

    private String jobtitlename;

    private Integer position;

    private Boolean isFavorite;

    private Boolean isSystem;
}
