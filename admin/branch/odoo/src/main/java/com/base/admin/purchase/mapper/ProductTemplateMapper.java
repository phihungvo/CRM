package com.base.admin.purchase.mapper;

import com.base.admin.purchase.entity.ProductTemplate;

public interface ProductTemplateMapper {
    int deleteByPrimaryKey(Object id);

    int insert(ProductTemplate record);

    int insertSelective(ProductTemplate record);

    ProductTemplate selectByPrimaryKey(Object id);

    int updateByPrimaryKeySelective(ProductTemplate record);

    int updateByPrimaryKey(ProductTemplate record);
}
