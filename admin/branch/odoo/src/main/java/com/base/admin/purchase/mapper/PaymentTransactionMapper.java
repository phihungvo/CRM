package com.base.admin.purchase.mapper;

import com.base.admin.purchase.entity.PaymentTransaction;

public interface PaymentTransactionMapper {
    int deleteByPrimaryKey(Object id);

    int insert(PaymentTransaction record);

    int insertSelective(PaymentTransaction record);

    PaymentTransaction selectByPrimaryKey(Object id);

    int updateByPrimaryKeySelective(PaymentTransaction record);

    int updateByPrimaryKey(PaymentTransaction record);
}
