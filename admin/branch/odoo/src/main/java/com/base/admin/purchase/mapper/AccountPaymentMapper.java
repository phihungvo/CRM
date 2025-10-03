package com.base.admin.purchase.mapper;

import com.base.admin.purchase.entity.AccountPayment;

public interface AccountPaymentMapper {
    int deleteByPrimaryKey(Object id);

    int insert(AccountPayment record);

    int insertSelective(AccountPayment record);

    AccountPayment selectByPrimaryKey(Object id);

    int updateByPrimaryKeySelective(AccountPayment record);

    int updateByPrimaryKey(AccountPayment record);
}
