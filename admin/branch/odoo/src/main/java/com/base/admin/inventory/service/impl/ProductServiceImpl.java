package com.base.admin.inventory.service.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.base.admin.inventory.dto.request.ProductDTO;
import com.base.admin.inventory.dto.request.ProductUpdateDTO;
import com.base.admin.inventory.entity.Product;
import com.base.admin.inventory.mapper.ProductMapper;
import com.base.admin.inventory.mapstruct.ProductMapstruct;
import com.base.admin.inventory.service.ProductService;

import lombok.experimental.FieldDefaults;

@Service
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
public class ProductServiceImpl implements ProductService {
    ProductMapper productMapper;

    ProductMapstruct productMapstruct;

    public ProductServiceImpl(ProductMapper productMapper, ProductMapstruct productMapstruct) {
        this.productMapper = productMapper;
        this.productMapstruct = productMapstruct;
    }

    @Override
    public int create(ProductDTO productDTO) {
        Product product = productMapstruct.toEntity(productDTO);
        return productMapper.insert(product);
    }

    @Override
    public Product findById(UUID id) {
        return productMapper.selectByPrimaryKey(id);
    }

    @Override
    public int update(ProductUpdateDTO request) {
        Product product = new Product();
        productMapstruct.updateByDTO(product, request);
        return productMapper.updateByPrimaryKey(product);
    }

    @Override
    public int delete(UUID id) {
        return productMapper.deleteByPrimaryKey(id);
    }
}
