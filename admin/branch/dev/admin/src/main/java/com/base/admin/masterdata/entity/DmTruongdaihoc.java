package com.base.admin.masterdata.entity;

import lombok.*;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DmTruongdaihoc {
    private Integer id;

    private String universityName;

    private String code;

    private Integer position;

    private Boolean isFavorite;

    private Boolean isSystem;
}