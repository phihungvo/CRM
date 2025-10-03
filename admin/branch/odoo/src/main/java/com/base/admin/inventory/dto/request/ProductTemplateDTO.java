package com.base.admin.inventory.dto.request;

import java.util.UUID;

import com.base.admin.inventory.entity.ProductTemplate;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

/**
 * Dto for the entity {@link ProductTemplate}
 */
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductTemplateDTO {
    String name;

    UUID categoryId;

    UUID uomId;

    String type;
}
