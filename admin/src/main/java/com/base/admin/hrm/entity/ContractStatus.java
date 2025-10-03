package com.base.admin.hrm.entity;

import lombok.*;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ContractStatus {
    private Integer contractstatusid;

    private String contractstatusname;

    private Integer position;

    private Boolean isFavorite;

    private Boolean isSystem;
}