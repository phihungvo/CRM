package com.base.admin.inventory.entity;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

/**
 * product_attribute_line
 * @author
 */
@Getter
@Setter
public class ProductAttributeLine extends ModelEntity {
    private UUID productId;

    private UUID attributeId;

    private UUID valueId;
}
