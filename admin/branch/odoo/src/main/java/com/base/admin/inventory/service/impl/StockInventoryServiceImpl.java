package com.base.admin.inventory.service.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.base.admin.inventory.dto.request.StockInventoryDTO;
import com.base.admin.inventory.dto.request.StockInventoryUpdateDTO;
import com.base.admin.inventory.entity.StockInventory;
import com.base.admin.inventory.mapper.StockInventoryMappers;
import com.base.admin.inventory.mapstruct.StockInventoryMapstruct;
import com.base.admin.inventory.service.StockInventoryService;

import lombok.experimental.FieldDefaults;

@Service
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
public class StockInventoryServiceImpl implements StockInventoryService {

    StockInventoryMapstruct stockInventoryMapstruct;

    StockInventoryMappers stockInventoryMappers;

    public StockInventoryServiceImpl(
            StockInventoryMapstruct stockInventoryMapstruct, StockInventoryMappers stockInventoryMappers) {
        this.stockInventoryMapstruct = stockInventoryMapstruct;
        this.stockInventoryMappers = stockInventoryMappers;
    }

    @Override
    public int create(StockInventoryDTO stockInventoryDTO) {
        StockInventory stockInventory = stockInventoryMapstruct.toEntity(stockInventoryDTO);
        return stockInventoryMappers.insert(stockInventory);
    }

    @Override
    public StockInventory findById(UUID id) {
        return stockInventoryMappers.selectByPrimaryKey(id);
    }

    @Override
    public int update(StockInventoryUpdateDTO request) {
        StockInventory stockInventory = new StockInventory();
        stockInventoryMapstruct.updateByDTO(stockInventory, request);
        return stockInventoryMappers.updateByPrimaryKeySelective(stockInventory);
    }

    @Override
    public int deleteById(UUID id) {
        return stockInventoryMappers.deleteByPrimaryKey(id);
    }
}
