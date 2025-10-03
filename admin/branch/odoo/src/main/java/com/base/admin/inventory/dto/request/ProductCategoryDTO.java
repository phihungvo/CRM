package com.base.admin.inventory.dto.request;

import java.util.UUID;

import com.base.admin.inventory.entity.ProductCategory;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

/**
 * Dto for the entity {@link ProductCategory}
 */
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductCategoryDTO {

    String name;

    UUID parentId;

    Integer sequence;
}
