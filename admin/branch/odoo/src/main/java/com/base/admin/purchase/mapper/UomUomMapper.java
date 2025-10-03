package com.base.admin.purchase.mapper;

import com.base.admin.purchase.entity.UomUom;

public interface UomUomMapper {
    int deleteByPrimaryKey(Object id);

    int insert(UomUom record);

    int insertSelective(UomUom record);

    UomUom selectByPrimaryKey(Object id);

    int updateByPrimaryKeySelective(UomUom record);

    int updateByPrimaryKey(UomUom record);
}
