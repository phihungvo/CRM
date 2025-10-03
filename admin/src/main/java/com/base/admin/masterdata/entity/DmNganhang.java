package com.base.admin.masterdata.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * dm_nganhang
 *
 * @author
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DmNganhang {
    private Integer id;

    private String en;

    private String description;

    private Boolean isSystem;

    private Integer position;
}