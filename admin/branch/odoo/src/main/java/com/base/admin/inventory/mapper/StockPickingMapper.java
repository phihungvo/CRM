package com.base.admin.inventory.mapper;

import java.util.UUID;

import com.base.admin.inventory.entity.StockPicking;

public interface StockPickingMapper {
    int deleteByPrimaryKey(UUID id);

    int insert(StockPicking record);

    int insertSelective(StockPicking record);

    StockPicking selectByPrimaryKey(UUID id);

    int updateByPrimaryKeySelective(StockPicking record);

    int updateByPrimaryKey(StockPicking record);
}
