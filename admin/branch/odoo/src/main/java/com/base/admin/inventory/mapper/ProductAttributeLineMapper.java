package com.base.admin.inventory.mapper;

import com.base.admin.inventory.entity.ProductAttributeLine;

public interface ProductAttributeLineMapper {
    int deleteByPrimaryKey(Object id);

    int insert(ProductAttributeLine record);

    int insertSelective(ProductAttributeLine record);

    ProductAttributeLine selectByPrimaryKey(Object id);

    int updateByPrimaryKeySelective(ProductAttributeLine record);

    int updateByPrimaryKey(ProductAttributeLine record);
}
