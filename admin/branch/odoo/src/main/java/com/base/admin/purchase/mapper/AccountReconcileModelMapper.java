package com.base.admin.purchase.mapper;

import com.base.admin.purchase.entity.AccountReconcileModel;

public interface AccountReconcileModelMapper {
    int deleteByPrimaryKey(Object id);

    int insert(AccountReconcileModel record);

    int insertSelective(AccountReconcileModel record);

    AccountReconcileModel selectByPrimaryKey(Object id);

    int updateByPrimaryKeySelective(AccountReconcileModel record);

    int updateByPrimaryKey(AccountReconcileModel record);
}
