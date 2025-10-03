package com.base.admin.inventory.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

/**
 * res_company
 * @author
 */
@Getter
@Setter
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class ResCompany extends ModelEntity {
    String name;
}
