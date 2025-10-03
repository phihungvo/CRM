package com.base.admin.inventory.service.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.base.admin.inventory.dto.request.ProductProductDTO;
import com.base.admin.inventory.dto.request.ProductProductUpdateDTO;
import com.base.admin.inventory.entity.ProductProduct;
import com.base.admin.inventory.mapper.ProductProductMapper;
import com.base.admin.inventory.mapstruct.ProductProductMapstruct;
import com.base.admin.inventory.service.ProductProductService;

@Service
public class ProductProductServiceImpl implements ProductProductService {
    private final ProductProductMapstruct productProductMapstruct;
    private final ProductProductMapper productProductMapper;

    public ProductProductServiceImpl(
            ProductProductMapstruct productProductMapstruct, ProductProductMapper productProductMapper) {
        this.productProductMapstruct = productProductMapstruct;
        this.productProductMapper = productProductMapper;
    }

    @Override
    public int create(ProductProductDTO request) {
        ProductProduct productProduct = productProductMapstruct.toEntity(request);
        return productProductMapper.insert(productProduct);
    }

    @Override
    public int create(ProductProduct request) {
        int count = productProductMapper.insert(request);
        return count;
    }

    @Override
    public ProductProduct findById(UUID id) {
        return productProductMapper.selectByPrimaryKey(id);
    }

    @Override
    public int update(ProductProductUpdateDTO request) {
        ProductProduct productProduct = new ProductProduct();

        productProductMapstruct.updateFromDTO(productProduct, request);
        return productProductMapper.updateByPrimaryKeySelective(productProduct);
    }

    @Override
    public int deleteById(UUID id) {
        return productProductMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int unActiveProduct(UUID productId) {
        ProductProduct productProduct = new ProductProduct();
        productProduct.setId(productId);
        productProduct.setActive(false);

        int count = productProductMapper.updateByPrimaryKeySelective(productProduct);
        return count;
    }

    @Override
    public int activeProduct(UUID productId) {
        ProductProduct productProduct = new ProductProduct();
        productProduct.setId(productId);
        productProduct.setActive(true);

        int count = productProductMapper.updateByPrimaryKeySelective(productProduct);
        return count;
    }
}
