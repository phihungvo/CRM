package com.base.admin.inventory.service;

import java.util.UUID;

import com.base.admin.inventory.dto.request.StockInventoryDTO;
import com.base.admin.inventory.dto.request.StockInventoryUpdateDTO;
import com.base.admin.inventory.entity.StockInventory;

public interface StockInventoryService {
    int create(StockInventoryDTO stockInventoryDTO);

    StockInventory findById(UUID id);

    int update(StockInventoryUpdateDTO request);

    int deleteById(UUID id);
}
