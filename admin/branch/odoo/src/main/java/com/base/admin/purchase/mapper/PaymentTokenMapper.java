package com.base.admin.purchase.mapper;

import com.base.admin.purchase.entity.PaymentToken;

public interface PaymentTokenMapper {
    int deleteByPrimaryKey(Object id);

    int insert(PaymentToken record);

    int insertSelective(PaymentToken record);

    PaymentToken selectByPrimaryKey(Object id);

    int updateByPrimaryKeySelective(PaymentToken record);

    int updateByPrimaryKey(PaymentToken record);
}
