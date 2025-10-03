package com.base.admin.purchase.mapper;

import com.base.admin.purchase.entity.MailAliasDomain;

public interface MailAliasDomainMapper {
    int deleteByPrimaryKey(Object id);

    int insert(MailAliasDomain record);

    int insertSelective(MailAliasDomain record);

    MailAliasDomain selectByPrimaryKey(Object id);

    int updateByPrimaryKeySelective(MailAliasDomain record);

    int updateByPrimaryKey(MailAliasDomain record);
}
