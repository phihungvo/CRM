package com.base.admin.inventory.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.base.admin.inventory.dto.request.ProductProductDTO;
import com.base.admin.inventory.dto.request.ProductProductUpdateDTO;
import com.base.admin.inventory.entity.ProductProduct;
import com.base.admin.inventory.mapstruct.config.MapstructConfig;

@Mapper(config = MapstructConfig.class)
public interface ProductProductMapstruct extends EntityMapper<ProductProductDTO, ProductProduct> {
    void updateFromDTO(@MappingTarget ProductProduct productProduct, ProductProductUpdateDTO request);
}
