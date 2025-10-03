package com.base.admin.purchase.mapper;

import com.base.admin.purchase.entity.IrUiView;

public interface IrUiViewMapper {
    int deleteByPrimaryKey(Object id);

    int insert(IrUiView record);

    int insertSelective(IrUiView record);

    IrUiView selectByPrimaryKey(Object id);

    int updateByPrimaryKeySelective(IrUiView record);

    int updateByPrimaryKey(IrUiView record);
}
