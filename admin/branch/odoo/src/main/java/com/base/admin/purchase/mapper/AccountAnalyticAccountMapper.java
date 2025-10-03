package com.base.admin.purchase.mapper;

import com.base.admin.purchase.entity.AccountAnalyticAccount;

public interface AccountAnalyticAccountMapper {
    int deleteByPrimaryKey(Object id);

    int insert(AccountAnalyticAccount record);

    int insertSelective(AccountAnalyticAccount record);

    AccountAnalyticAccount selectByPrimaryKey(Object id);

    int updateByPrimaryKeySelective(AccountAnalyticAccount record);

    int updateByPrimaryKey(AccountAnalyticAccount record);
}
