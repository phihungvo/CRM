package com.base.admin.inventory.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.base.admin.inventory.dto.request.StockWarehouseDTO;
import com.base.admin.inventory.dto.request.StockWarehouseUpdateDTO;
import com.base.admin.inventory.entity.StockWarehouse;
import com.base.admin.inventory.mapper.StockWarehouseMapper;
import com.base.admin.inventory.mapstruct.StockWarehouseMapstruct;
import com.base.admin.inventory.service.StockWarehouseService;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StockWarehouseServiceImpl implements StockWarehouseService {

    StockWarehouseMapstruct stockWarehouseMapstruct;
    StockWarehouseMapper stockWarehouseMapper;

    public StockWarehouseServiceImpl(
            StockWarehouseMapstruct stockWarehouseMapstruct, StockWarehouseMapper stockWarehouseMapper) {
        this.stockWarehouseMapstruct = stockWarehouseMapstruct;
        this.stockWarehouseMapper = stockWarehouseMapper;
    }

    @Override
    public int create(StockWarehouseDTO stockWarehouseDTO) {
        StockWarehouse stockWarehouse = stockWarehouseMapstruct.toEntity(stockWarehouseDTO);
        return stockWarehouseMapper.insert(stockWarehouse);
    }

    @Override
    public List<StockWarehouse> getAll() {
        return stockWarehouseMapper.findAll();
    }

    @Override
    public StockWarehouse findById(UUID id) {
        return stockWarehouseMapper.selectByPrimaryKey(id);
    }

    @Override
    public int update(StockWarehouseUpdateDTO request) {
        StockWarehouse stockWarehouse = new StockWarehouse();
        stockWarehouseMapstruct.updateByDTO(stockWarehouse, request);
        return stockWarehouseMapper.updateByPrimaryKeySelective(stockWarehouse);
    }

    @Override
    public int deleteById(UUID id) {
        return stockWarehouseMapper.deleteByPrimaryKey(id);
    }
}
