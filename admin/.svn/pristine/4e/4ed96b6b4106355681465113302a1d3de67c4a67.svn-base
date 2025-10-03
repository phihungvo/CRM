package com.base.admin.inventory.service.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.base.admin.inventory.dto.request.StockLocationDTO;
import com.base.admin.inventory.dto.request.StockLocationUpdateDTO;
import com.base.admin.inventory.entity.StockLocation;
import com.base.admin.inventory.mapper.StockLocationMappers;
import com.base.admin.inventory.mapstruct.StockLocationMapstruct;
import com.base.admin.inventory.service.StockLocationService;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StockLocationServiceImpl implements StockLocationService {

    StockLocationMapstruct stockLocationMapstruct;

    StockLocationMappers stockLocationMappers;

    public StockLocationServiceImpl(
            StockLocationMapstruct stockLocationMapstruct, StockLocationMappers stockLocationMappers) {
        this.stockLocationMapstruct = stockLocationMapstruct;
        this.stockLocationMappers = stockLocationMappers;
    }

    @Override
    public int create(StockLocationDTO stockLocationDTO) {
        StockLocation stockLocation = stockLocationMapstruct.toEntity(stockLocationDTO);
        return stockLocationMappers.insert(stockLocation);
    }

    @Override
    public StockLocation findById(UUID id) {
        return stockLocationMappers.selectByPrimaryKey(id);
    }

    @Override
    public int update(StockLocationUpdateDTO request) {
        StockLocation stockLocation = new StockLocation();
        stockLocationMapstruct.updateByDTO(stockLocation, request);
        return stockLocationMappers.updateByPrimaryKey(stockLocation);
    }

    @Override
    public int deleteById(UUID id) {
        return stockLocationMappers.deleteByPrimaryKey(id);
    }
}
