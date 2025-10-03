package com.base.admin.purchase.mapper;

import com.base.admin.purchase.entity.AccountMoveLine;

public interface AccountMoveLineMapper {
    int deleteByPrimaryKey(Object id);

    int insert(AccountMoveLine record);

    int insertSelective(AccountMoveLine record);

    AccountMoveLine selectByPrimaryKey(Object id);

    int updateByPrimaryKeySelective(AccountMoveLine record);

    int updateByPrimaryKey(AccountMoveLine record);
}
