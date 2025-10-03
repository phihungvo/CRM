package com.base.admin.inventory.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.base.admin.inventory.dto.request.ProductAttributeValueDTO;
import com.base.admin.inventory.dto.request.ProductAttributeValueUpdateDTO;
import com.base.admin.inventory.entity.ProductAttributeValue;
import com.base.admin.inventory.mapstruct.config.MapstructConfig;

/**
 * Mapper for the entity {@link ProductAttributeValue} and its DTO called {@link ProductAttributeValueDTO}.
 */
@Mapper(config = MapstructConfig.class)
public interface ProductAttributeValueMapstruct extends EntityMapper<ProductAttributeValueDTO, ProductAttributeValue> {
    void updateByDTO(
            @MappingTarget ProductAttributeValue productAttributeValue, ProductAttributeValueUpdateDTO request);
}
