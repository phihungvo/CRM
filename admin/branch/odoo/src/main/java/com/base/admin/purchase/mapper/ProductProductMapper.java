package com.base.admin.purchase.mapper;

import com.base.admin.purchase.entity.ProductProduct;

public interface ProductProductMapper {
    int deleteByPrimaryKey(Object id);

    int insert(ProductProduct record);

    int insertSelective(ProductProduct record);

    ProductProduct selectByPrimaryKey(Object id);

    int updateByPrimaryKeySelective(ProductProduct record);

    int updateByPrimaryKey(ProductProduct record);
}
