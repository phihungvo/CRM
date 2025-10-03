package com.base.admin.hrm.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccomplishmentObjectdetail {
    private Integer accomplishmentobjectdetailid;

    private String accomplishmentobjectdetailname;

    private Integer position;

    private Boolean isFavorite;

    private Boolean isSystem;
}