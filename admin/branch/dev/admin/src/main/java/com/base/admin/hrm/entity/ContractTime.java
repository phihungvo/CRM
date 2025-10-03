package com.base.admin.hrm.entity;

import lombok.*;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ContractTime {
    private Integer contracttimeid;

    private String contractimename;

    private Integer position;

    private Boolean isFavorite;

    private Boolean isSystem;
}