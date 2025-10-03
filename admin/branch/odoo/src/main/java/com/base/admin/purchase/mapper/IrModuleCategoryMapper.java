package com.base.admin.purchase.mapper;

import com.base.admin.purchase.entity.IrModuleCategory;

public interface IrModuleCategoryMapper {
    int deleteByPrimaryKey(Object id);

    int insert(IrModuleCategory record);

    int insertSelective(IrModuleCategory record);

    IrModuleCategory selectByPrimaryKey(Object id);

    int updateByPrimaryKeySelective(IrModuleCategory record);

    int updateByPrimaryKey(IrModuleCategory record);
}
