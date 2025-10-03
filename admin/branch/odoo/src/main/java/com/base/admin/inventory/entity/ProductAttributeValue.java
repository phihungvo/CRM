package com.base.admin.inventory.entity;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

/**
 * product_attribute_value
 * @author
 */
@Getter
@Setter
public class ProductAttributeValue extends ModelEntity {
    private UUID attributeId;

    private String name;
}
