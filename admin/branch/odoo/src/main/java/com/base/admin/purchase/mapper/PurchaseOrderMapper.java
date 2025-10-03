package com.base.admin.purchase.mapper;

import com.base.admin.purchase.entity.PurchaseOrder;

public interface PurchaseOrderMapper {
    int deleteByPrimaryKey(Object id);

    int insert(PurchaseOrder record);

    int insertSelective(PurchaseOrder record);

    PurchaseOrder selectByPrimaryKey(Object id);

    int updateByPrimaryKeySelective(PurchaseOrder record);

    int updateByPrimaryKey(PurchaseOrder record);
}
