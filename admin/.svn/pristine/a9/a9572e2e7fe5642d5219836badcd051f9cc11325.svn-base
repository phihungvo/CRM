package com.base.admin.inventory.service.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.base.admin.inventory.dto.request.ProductAttributeDTO;
import com.base.admin.inventory.entity.ProductAttribute;
import com.base.admin.inventory.mapper.ProductAttributeMapper;
import com.base.admin.inventory.mapstruct.ProductAttributeMapstruct;
import com.base.admin.inventory.service.ProductAttributeService;

@Service
public class ProductAttributeServiceImpl implements ProductAttributeService {
    private final ProductAttributeMapper productAttributeMapper;
    private final ProductAttributeMapstruct productAttributeMapstruct;

    public ProductAttributeServiceImpl(
            ProductAttributeMapper productAttributeMapper, ProductAttributeMapstruct productAttributeMapstruct) {
        this.productAttributeMapper = productAttributeMapper;
        this.productAttributeMapstruct = productAttributeMapstruct;
    }

    @Override
    public int create(ProductAttributeDTO request) {
        ProductAttribute productAttribute = productAttributeMapstruct.toEntity(request);
        return productAttributeMapper.insert(productAttribute);
    }

    @Override
    public ProductAttribute findById(UUID productAttributeId) {
        return productAttributeMapper.selectByPrimaryKey(productAttributeId);
    }

    @Override
    public int update(ProductAttribute request) {
        return productAttributeMapper.updateByPrimaryKey(request);
    }

    @Override
    public int deleteById(UUID id) {
        return productAttributeMapper.deleteByPrimaryKey(id);
    }
}
