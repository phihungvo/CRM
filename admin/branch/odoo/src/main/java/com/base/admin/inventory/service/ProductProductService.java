package com.base.admin.inventory.service;

import java.util.UUID;

import com.base.admin.inventory.dto.request.ProductProductDTO;
import com.base.admin.inventory.dto.request.ProductProductUpdateDTO;
import com.base.admin.inventory.entity.ProductProduct;

public interface ProductProductService {
    int create(ProductProductDTO request);

    int create(ProductProduct request);

    ProductProduct findById(UUID id);

    int update(ProductProductUpdateDTO request);

    int deleteById(UUID id);

    int unActiveProduct(UUID productId);

    int activeProduct(UUID productId);
}
