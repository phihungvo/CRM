package com.base.admin.inventory.entity;

import java.util.UUID;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

/**
 * product_template
 * @author
 */
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductTemplate extends ModelEntity {
    String name;

    UUID categoryId;

    UUID uomId;

    String type;

    Boolean active;
}
