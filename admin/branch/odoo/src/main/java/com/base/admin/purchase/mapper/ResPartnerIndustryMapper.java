package com.base.admin.purchase.mapper;

import com.base.admin.purchase.entity.ResPartnerIndustry;

public interface ResPartnerIndustryMapper {
    int deleteByPrimaryKey(Object id);

    int insert(ResPartnerIndustry record);

    int insertSelective(ResPartnerIndustry record);

    ResPartnerIndustry selectByPrimaryKey(Object id);

    int updateByPrimaryKeySelective(ResPartnerIndustry record);

    int updateByPrimaryKey(ResPartnerIndustry record);
}
