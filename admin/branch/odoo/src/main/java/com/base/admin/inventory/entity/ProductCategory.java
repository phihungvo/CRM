package com.base.admin.inventory.entity;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

/**
 * product_category
 *
 * @author
 */
@Setter
@Getter
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class ProductCategory extends ModelEntity {

    String name;

    UUID parentId;

    Integer sequence;
}
