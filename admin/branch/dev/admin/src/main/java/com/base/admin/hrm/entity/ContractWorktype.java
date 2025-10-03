package com.base.admin.hrm.entity;

import lombok.*;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ContractWorktype {
    private Integer contractworktypeid;

    private String contractworktypename;

    private Integer position;

    private Boolean isFavorite;

    private Boolean isSystem;
}