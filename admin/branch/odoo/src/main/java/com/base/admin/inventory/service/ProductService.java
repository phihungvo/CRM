package com.base.admin.inventory.service;

import java.util.UUID;

import com.base.admin.inventory.dto.request.ProductDTO;
import com.base.admin.inventory.dto.request.ProductUpdateDTO;
import com.base.admin.inventory.entity.Product;

public interface ProductService {
    int create(ProductDTO productDTO);

    Product findById(UUID id);

    int update(ProductUpdateDTO request);

    int delete(UUID id);
}
