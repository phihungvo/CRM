package com.base.admin.hrm.entity;

import lombok.*;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class JobGroup {
    private Integer jobgroupid;

    private String jobgroupname;

    private Integer position;

    private Boolean isFavorite;

    private Boolean isSystem;
}