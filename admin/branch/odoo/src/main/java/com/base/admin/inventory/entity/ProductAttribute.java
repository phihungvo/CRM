package com.base.admin.inventory.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * product_attribute
 * @author
 */
@Setter
@Getter
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class ProductAttribute extends ModelEntity {
    String name;
}
