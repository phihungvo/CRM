package com.base.admin.inventory.dto.request;

import java.util.UUID;

import com.base.admin.inventory.entity.ProductProduct;

import lombok.*;
import lombok.experimental.FieldDefaults;

/**
 * Dto for the entity {@link ProductProduct}
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductProductDTO {
    UUID productTmplId;

    Boolean active;
}
