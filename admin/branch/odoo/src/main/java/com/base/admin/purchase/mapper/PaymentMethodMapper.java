package com.base.admin.purchase.mapper;

import com.base.admin.purchase.entity.PaymentMethod;

public interface PaymentMethodMapper {
    int deleteByPrimaryKey(Object id);

    int insert(PaymentMethod record);

    int insertSelective(PaymentMethod record);

    PaymentMethod selectByPrimaryKey(Object id);

    int updateByPrimaryKeySelective(PaymentMethod record);

    int updateByPrimaryKey(PaymentMethod record);
}
