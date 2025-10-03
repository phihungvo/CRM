package com.base.admin.purchase.mapper;

import com.base.admin.purchase.entity.AccountCashRounding;

public interface AccountCashRoundingMapper {
    int deleteByPrimaryKey(Object id);

    int insert(AccountCashRounding record);

    int insertSelective(AccountCashRounding record);

    AccountCashRounding selectByPrimaryKey(Object id);

    int updateByPrimaryKeySelective(AccountCashRounding record);

    int updateByPrimaryKey(AccountCashRounding record);
}
