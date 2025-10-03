package com.base.admin.inventory.mapper;

import java.util.List;
import java.util.UUID;

import com.base.admin.inventory.entity.StockWarehouse;

public interface StockWarehouseMapper {
    int deleteByPrimaryKey(UUID id);

    int insert(StockWarehouse record);

    List<StockWarehouse> findAll();

    int insertSelective(StockWarehouse record);

    StockWarehouse selectByPrimaryKey(UUID id);

    int updateByPrimaryKeySelective(StockWarehouse record);

    int updateByPrimaryKey(StockWarehouse record);
}
