package com.base.admin.inventory.dto.request;

import com.base.admin.inventory.entity.ProductAttribute;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

/**
 * Dto for the entity {@link ProductAttribute}
 */
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductAttributeDTO {
    String name;
}
