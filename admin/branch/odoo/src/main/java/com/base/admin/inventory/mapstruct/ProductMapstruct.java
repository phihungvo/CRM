package com.base.admin.inventory.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.base.admin.inventory.dto.request.ProductDTO;
import com.base.admin.inventory.dto.request.ProductUpdateDTO;
import com.base.admin.inventory.entity.Product;
import com.base.admin.inventory.mapstruct.config.MapstructConfig;

@Mapper(config = MapstructConfig.class)
public interface ProductMapstruct extends EntityMapper<ProductDTO, Product> {
    void updateByDTO(@MappingTarget Product product, ProductUpdateDTO productUpdateDTO);
}
