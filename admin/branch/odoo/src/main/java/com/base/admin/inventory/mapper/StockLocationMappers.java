package com.base.admin.inventory.mapper;

import java.util.UUID;

import com.base.admin.inventory.entity.StockLocation;

public interface StockLocationMappers {
    int deleteByPrimaryKey(UUID id);

    int insert(StockLocation record);

    int insertSelective(StockLocation record);

    StockLocation selectByPrimaryKey(UUID id);

    int updateByPrimaryKeySelective(StockLocation record);

    int updateByPrimaryKey(StockLocation record);
}
