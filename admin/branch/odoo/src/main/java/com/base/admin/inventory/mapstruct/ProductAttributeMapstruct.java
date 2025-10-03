package com.base.admin.inventory.mapstruct;

import org.mapstruct.Mapper;

import com.base.admin.inventory.dto.request.ProductAttributeDTO;
import com.base.admin.inventory.entity.ProductAttribute;
import com.base.admin.inventory.mapstruct.config.MapstructConfig;

/**
 * Mapper for the entity {@link ProductAttribute} and its DTO called {@link ProductAttributeDTO}.
 */
@Mapper(config = MapstructConfig.class)
public interface ProductAttributeMapstruct extends EntityMapper<ProductAttributeDTO, ProductAttribute> {}
