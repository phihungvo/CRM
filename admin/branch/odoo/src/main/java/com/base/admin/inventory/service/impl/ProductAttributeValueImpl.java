package com.base.admin.inventory.service.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.base.admin.inventory.dto.request.ProductAttributeValueDTO;
import com.base.admin.inventory.dto.request.ProductAttributeValueUpdateDTO;
import com.base.admin.inventory.entity.ProductAttributeValue;
import com.base.admin.inventory.mapper.ProductAttributeValueMapper;
import com.base.admin.inventory.mapstruct.ProductAttributeValueMapstruct;
import com.base.admin.inventory.service.ProductAttributeValueService;

@Service
public class ProductAttributeValueImpl implements ProductAttributeValueService {
    private final ProductAttributeValueMapper productAttributeValueMapper;
    private final ProductAttributeValueMapstruct productAttributeValueMapstruct;

    public ProductAttributeValueImpl(
            ProductAttributeValueMapper productAttributeValueMapper,
            ProductAttributeValueMapstruct productAttributeValueMapstruct) {
        this.productAttributeValueMapper = productAttributeValueMapper;
        this.productAttributeValueMapstruct = productAttributeValueMapstruct;
    }

    @Override
    public int create(ProductAttributeValueDTO request) {
        ProductAttributeValue productAttributeValue = productAttributeValueMapstruct.toEntity(request);
        return productAttributeValueMapper.insert(productAttributeValue);
    }

    @Override
    public int deleteById(UUID productAttributeValueId) {
        return productAttributeValueMapper.deleteByPrimaryKey(productAttributeValueId);
    }

    @Override
    public int update(ProductAttributeValueUpdateDTO request) {
        var productAttributeValue = new ProductAttributeValue();
        productAttributeValueMapstruct.updateByDTO(productAttributeValue, request);
        return productAttributeValueMapper.updateByPrimaryKeySelective(productAttributeValue);
    }
}
