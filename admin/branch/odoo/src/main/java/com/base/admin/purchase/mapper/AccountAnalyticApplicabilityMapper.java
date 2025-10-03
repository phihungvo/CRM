package com.base.admin.purchase.mapper;

import com.base.admin.purchase.entity.AccountAnalyticApplicability;

public interface AccountAnalyticApplicabilityMapper {
    int deleteByPrimaryKey(Object id);

    int insert(AccountAnalyticApplicability record);

    int insertSelective(AccountAnalyticApplicability record);

    AccountAnalyticApplicability selectByPrimaryKey(Object id);

    int updateByPrimaryKeySelective(AccountAnalyticApplicability record);

    int updateByPrimaryKey(AccountAnalyticApplicability record);
}
