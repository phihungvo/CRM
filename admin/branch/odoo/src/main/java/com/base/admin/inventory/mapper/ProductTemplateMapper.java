package com.base.admin.inventory.mapper;

import java.util.UUID;

import com.base.admin.inventory.entity.ProductTemplate;

public interface ProductTemplateMapper {
    int deleteByPrimaryKey(UUID id);

    int insert(ProductTemplate productTemplate);

    int insertSelective(ProductTemplate productTemplate);

    ProductTemplate selectByPrimaryKey(UUID id);

    int updateByPrimaryKeySelective(ProductTemplate productTemplate);

    int updateByPrimaryKey(ProductTemplate productTemplate);
}
