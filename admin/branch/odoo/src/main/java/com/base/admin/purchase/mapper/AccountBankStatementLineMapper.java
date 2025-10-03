package com.base.admin.purchase.mapper;

import com.base.admin.purchase.entity.AccountBankStatementLine;

public interface AccountBankStatementLineMapper {
    int deleteByPrimaryKey(Object id);

    int insert(AccountBankStatementLine record);

    int insertSelective(AccountBankStatementLine record);

    AccountBankStatementLine selectByPrimaryKey(Object id);

    int updateByPrimaryKeySelective(AccountBankStatementLine record);

    int updateByPrimaryKey(AccountBankStatementLine record);
}
