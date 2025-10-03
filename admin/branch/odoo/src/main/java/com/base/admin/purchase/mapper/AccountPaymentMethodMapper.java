package com.base.admin.purchase.mapper;

import com.base.admin.purchase.entity.AccountPaymentMethod;

public interface AccountPaymentMethodMapper {
    int deleteByPrimaryKey(Object id);

    int insert(AccountPaymentMethod record);

    int insertSelective(AccountPaymentMethod record);

    AccountPaymentMethod selectByPrimaryKey(Object id);

    int updateByPrimaryKeySelective(AccountPaymentMethod record);

    int updateByPrimaryKey(AccountPaymentMethod record);
}
