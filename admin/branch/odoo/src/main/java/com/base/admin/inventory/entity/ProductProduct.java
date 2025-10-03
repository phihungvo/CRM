package com.base.admin.inventory.entity;

import java.util.UUID;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

/**
 * product_product
 * @author
 */
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductProduct extends ModelEntity {
    UUID productTmplId;

    Boolean active;
}
