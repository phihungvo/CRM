package com.base.admin.inventory.mapper;

import java.util.UUID;

import com.base.admin.inventory.entity.StockInventory;

public interface StockInventoryMappers {
    int deleteByPrimaryKey(UUID id);

    int insert(StockInventory record);

    int insertSelective(StockInventory record);

    StockInventory selectByPrimaryKey(UUID id);

    int updateByPrimaryKeySelective(StockInventory record);

    int updateByPrimaryKey(StockInventory record);
}
