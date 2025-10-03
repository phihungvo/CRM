package com.base.admin.purchase.mapper;

import com.base.admin.purchase.entity.AccountJournal;

public interface AccountJournalMapper {
    int deleteByPrimaryKey(Object id);

    int insert(AccountJournal record);

    int insertSelective(AccountJournal record);

    AccountJournal selectByPrimaryKey(Object id);

    int updateByPrimaryKeySelective(AccountJournal record);

    int updateByPrimaryKey(AccountJournal record);
}
