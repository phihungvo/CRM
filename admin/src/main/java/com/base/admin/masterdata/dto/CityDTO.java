package com.base.admin.masterdata.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CityDTO {
    private String cityId;

    private String cityName;

    private Integer position;

    private Boolean isFavorite;

    private Boolean isSystem;
}
