package com.base.admin.purchase.mapper;

import com.base.admin.purchase.entity.PurchaseOrderLine;

public interface PurchaseOrderLineMapper {
    int deleteByPrimaryKey(Object id);

    int insert(PurchaseOrderLine record);

    int insertSelective(PurchaseOrderLine record);

    PurchaseOrderLine selectByPrimaryKey(Object id);

    int updateByPrimaryKeySelective(PurchaseOrderLine record);

    int updateByPrimaryKey(PurchaseOrderLine record);
}
