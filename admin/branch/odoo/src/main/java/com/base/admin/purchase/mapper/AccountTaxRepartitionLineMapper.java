package com.base.admin.purchase.mapper;

import com.base.admin.purchase.entity.AccountTaxRepartitionLine;

public interface AccountTaxRepartitionLineMapper {
    int deleteByPrimaryKey(Object id);

    int insert(AccountTaxRepartitionLine record);

    int insertSelective(AccountTaxRepartitionLine record);

    AccountTaxRepartitionLine selectByPrimaryKey(Object id);

    int updateByPrimaryKeySelective(AccountTaxRepartitionLine record);

    int updateByPrimaryKey(AccountTaxRepartitionLine record);
}
