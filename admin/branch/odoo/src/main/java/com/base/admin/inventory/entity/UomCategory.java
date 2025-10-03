package com.base.admin.inventory.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

/**
 * uom_category
 * @author
 */
@Setter
@Getter
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class UomCategory extends ModelEntity {

    String name;
}
