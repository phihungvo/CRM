package com.base.admin.inventory.service;

import java.util.List;
import java.util.UUID;

import com.base.admin.inventory.dto.request.AttributeDTO;
import com.base.admin.inventory.dto.request.ProductTemplateDTO;
import com.base.admin.inventory.entity.ProductTemplate;

public interface ProductTemplateService {
    int create(ProductTemplateDTO request);

    ProductTemplate findById(UUID id);

    int deleteById(UUID id);

    int update(ProductTemplate request);

    int createAttributes(UUID templateId, List<AttributeDTO> request);

    int unActive(UUID id);
}
