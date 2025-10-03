package com.base.admin.purchase.mapper;

import com.base.admin.purchase.entity.ResCurrency;

public interface ResCurrencyMapper {
    int deleteByPrimaryKey(Object id);

    int insert(ResCurrency record);

    int insertSelective(ResCurrency record);

    ResCurrency selectByPrimaryKey(Object id);

    int updateByPrimaryKeySelective(ResCurrency record);

    int updateByPrimaryKey(ResCurrency record);
}
