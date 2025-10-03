package com.base.admin.purchase.mapper;

import com.base.admin.purchase.entity.AccountPaymentTerm;

public interface AccountPaymentTermMapper {
    int deleteByPrimaryKey(Object id);

    int insert(AccountPaymentTerm record);

    int insertSelective(AccountPaymentTerm record);

    AccountPaymentTerm selectByPrimaryKey(Object id);

    int updateByPrimaryKeySelective(AccountPaymentTerm record);

    int updateByPrimaryKey(AccountPaymentTerm record);
}
