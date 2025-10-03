package com.base.admin.inventory.mapper;

import java.util.UUID;

import com.base.admin.inventory.entity.StockPickingType;

public interface StockPickingTypeMapper {
    int deleteByPrimaryKey(UUID id);

    int insert(StockPickingType record);

    int insertSelective(StockPickingType record);

    StockPickingType selectByPrimaryKey(UUID id);

    int updateByPrimaryKeySelective(StockPickingType record);

    int updateByPrimaryKey(StockPickingType record);
}
