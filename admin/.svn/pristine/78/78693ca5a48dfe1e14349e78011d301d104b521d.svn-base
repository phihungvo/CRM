package com.base.admin.inventory.service.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.base.admin.inventory.dto.request.ProductCategoryDTO;
import com.base.admin.inventory.entity.ProductCategory;
import com.base.admin.inventory.mapper.ProductCategoryMapper;
import com.base.admin.inventory.mapstruct.ProductCategoryMapstruct;
import com.base.admin.inventory.service.ProductCategoryService;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    private final ProductCategoryMapper productCategoryMapper;
    private final ProductCategoryMapstruct productCategoryMapstruct;

    public ProductCategoryServiceImpl(
            ProductCategoryMapper productCategoryMapper, ProductCategoryMapstruct productCategoryMapstruct) {
        this.productCategoryMapper = productCategoryMapper;
        this.productCategoryMapstruct = productCategoryMapstruct;
    }

    @Override
    public int create(ProductCategoryDTO request) {
        ProductCategory productCategory = productCategoryMapstruct.toEntity(request);
        return productCategoryMapper.insert(productCategory);
    }

    @Override
    public int update(ProductCategory request) {
        return productCategoryMapper.updateByPrimaryKeySelective(request);
    }

    @Override
    public int deleteById(UUID id) {
        return productCategoryMapper.deleteByPrimaryKey(id);
    }
}
