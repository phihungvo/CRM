package com.base.admin.masterdata.entity;

import lombok.*;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DmTinhthanh {
    private String cityId;

    private String cityName;

    private String districtId;

    private String districtName;

    private String wardId;

    private String wardName;

    private String level;

    private Integer position;

    private Boolean isFavorite;

    private Boolean isSystem;
}
