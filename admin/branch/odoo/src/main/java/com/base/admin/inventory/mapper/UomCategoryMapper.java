package com.base.admin.inventory.mapper;

import com.base.admin.inventory.entity.UomCategory;

public interface UomCategoryMapper {
    int deleteByPrimaryKey(Object id);

    int insert(UomCategory record);

    int insertSelective(UomCategory record);

    UomCategory selectByPrimaryKey(Object id);

    int updateByPrimaryKeySelective(UomCategory record);

    int updateByPrimaryKey(UomCategory record);
}
