package com.base.admin.purchase.mapper;

import com.base.admin.purchase.entity.AccountPartialReconcile;

public interface AccountPartialReconcileMapper {
    int deleteByPrimaryKey(Object id);

    int insert(AccountPartialReconcile record);

    int insertSelective(AccountPartialReconcile record);

    AccountPartialReconcile selectByPrimaryKey(Object id);

    int updateByPrimaryKeySelective(AccountPartialReconcile record);

    int updateByPrimaryKey(AccountPartialReconcile record);
}
