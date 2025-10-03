package com.base.admin.inventory.service;

import java.util.List;
import java.util.UUID;

import com.base.admin.inventory.dto.request.StockWarehouseDTO;
import com.base.admin.inventory.dto.request.StockWarehouseUpdateDTO;
import com.base.admin.inventory.entity.StockWarehouse;

public interface StockWarehouseService {
    int create(StockWarehouseDTO stockWarehouseDTO);

    List<StockWarehouse> getAll();

    StockWarehouse findById(UUID id);

    int update(StockWarehouseUpdateDTO request);

    int deleteById(UUID id);
}
