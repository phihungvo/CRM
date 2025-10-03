package com.base.admin.inventory.service.impl;

import com.base.admin.inventory.dto.request.AttributeDTO;
import com.base.admin.inventory.dto.request.ProductProductDTO;
import com.base.admin.inventory.dto.request.ProductTemplateDTO;
import com.base.admin.inventory.entity.*;
import com.base.admin.inventory.mapper.ProductAttributeLineMapper;
import com.base.admin.inventory.mapper.ProductAttributeMapper;
import com.base.admin.inventory.mapper.ProductAttributeValueMapper;
import com.base.admin.inventory.mapper.ProductTemplateMapper;
import com.base.admin.inventory.mapstruct.ProductTemplateMapstruct;
import com.base.admin.inventory.service.ProductProductService;
import com.base.admin.inventory.service.ProductTemplateService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ProductTemplateServiceImpl implements ProductTemplateService {
    private final ProductTemplateMapper productTemplateMapper;
    private final ProductTemplateMapstruct productTemplateMapstruct;
    private final ProductProductService productProductService;
    private final ProductAttributeMapper productAttributeMapper;
    private final ProductAttributeValueMapper productAttributeValueMapper;
    private final ProductAttributeLineMapper productAttributeLineMapper;

    public ProductTemplateServiceImpl(
            ProductTemplateMapper productTemplateMapper,
            ProductTemplateMapstruct productTemplateMapstruct,
            ProductProductService productProductService,
            ProductAttributeMapper productAttributeMapper,
            ProductAttributeValueMapper productAttributeValueMapper,
            ProductAttributeLineMapper productAttributeLineMapper) {
        this.productTemplateMapper = productTemplateMapper;
        this.productTemplateMapstruct = productTemplateMapstruct;
        this.productProductService = productProductService;
        this.productAttributeMapper = productAttributeMapper;
        this.productAttributeValueMapper = productAttributeValueMapper;
        this.productAttributeLineMapper = productAttributeLineMapper;
    }

    @Override
    public int create(ProductTemplateDTO request) {
        ProductTemplate productTemplate = productTemplateMapstruct.toEntity(request);
        int count = productTemplateMapper.insert(productTemplate);
        if (count != 0) {
            // create product_product
            var productProductDTO = ProductProductDTO.builder()
                    .productTmplId(productTemplate.getId())
                    .active(true)
                    .build();
            int result = productProductService.create(productProductDTO);

            // if create product_product faild
            if (result == 0) {
                productTemplateMapper.deleteByPrimaryKey(productTemplate.getId());
                return 0;
            }
        }
        return count;
    }

    @Override
    public ProductTemplate findById(UUID id) {
        return productTemplateMapper.selectByPrimaryKey(id);
    }

    @Override
    public int deleteById(UUID id) {
        return productTemplateMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(ProductTemplate request) {
        return productTemplateMapper.updateByPrimaryKey(request);
    }

    @Override
    @Transactional
    public int createAttributes(UUID templateId, List<AttributeDTO> requestList) {
        int result = 0;
        // Kiểm tra product_template tồn tại hay chưa
        ProductTemplate productTemplate = productTemplateMapper.selectByPrimaryKey(templateId);
        if (productTemplate == null) {
            return 0;
        }
        // Tạo mới product_product
        var productProduct = new ProductProduct();
        productProduct.setId(UUID.randomUUID());
        productProduct.setProductTmplId(productTemplate.getId());
        productProduct.setActive(true);

        productProductService.create(productProduct);

        for (var request : requestList) {

            // Kiểm tra xem attribute đã tồn tại chưa
            ProductAttribute attribute = productAttributeMapper.selectAttributeByName(request.getAttributeName());
            if (attribute == null) {
                // Tạo mới attribute
                attribute = new ProductAttribute();
                attribute.setId(UUID.randomUUID());
                attribute.setName(request.getAttributeName());
                productAttributeMapper.insert(attribute);
            }

            // Kiểm tra xem attribute_value đã tồn tại chưa
            List<UUID> valueIds = new ArrayList<>();
            for (String value : request.getAttributeValue()) {
                ProductAttributeValue productAttributeValue =
                        productAttributeValueMapper.seletAttributeValueByName(value);
                if (productAttributeValue == null) {
                    // Tạo mới attribute_value
                    productAttributeValue = new ProductAttributeValue();
                    productAttributeValue.setId(UUID.randomUUID());
                    productAttributeValue.setAttributeId(attribute.getId());
                    productAttributeValue.setName(value);
                    productAttributeValueMapper.insert(productAttributeValue);
                }
                valueIds.add(productAttributeValue.getId());
            }

            // Tạo mới ProductAttributeLine
            for (UUID valueId : valueIds) {
                ProductAttributeLine productAttributeLine = new ProductAttributeLine();
                productAttributeLine.setId(UUID.randomUUID());
                productAttributeLine.setProductId(productProduct.getId());
                productAttributeLine.setAttributeId(attribute.getId());
                productAttributeLine.setValueId(valueId);

                result += productAttributeLineMapper.insert(productAttributeLine);
            }
        }
        return result;
    }

    @Override
    public int unActive(UUID id) {
        ProductTemplate productTemplate = new ProductTemplate();
        productTemplate.setId(id);
        productTemplate.setActive(false);

        int count = productTemplateMapper.updateByPrimaryKeySelective(productTemplate);
        return count;
    }
}
