package com.base.admin.purchase.mapper;

import com.base.admin.purchase.entity.AccountAccount;

public interface AccountAccountMapper {
    int deleteByPrimaryKey(Object id);

    int insert(AccountAccount record);

    int insertSelective(AccountAccount record);

    AccountAccount selectByPrimaryKey(Object id);

    int updateByPrimaryKeySelective(AccountAccount record);

    int updateByPrimaryKey(AccountAccount record);
}
