package com.base.admin.purchase.mapper;

import com.base.admin.purchase.entity.IrModel;

public interface IrModelMapper {
    int deleteByPrimaryKey(Object id);

    int insert(IrModel record);

    int insertSelective(IrModel record);

    IrModel selectByPrimaryKey(Object id);

    int updateByPrimaryKeySelective(IrModel record);

    int updateByPrimaryKey(IrModel record);
}
