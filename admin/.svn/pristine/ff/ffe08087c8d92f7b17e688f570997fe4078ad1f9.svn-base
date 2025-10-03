package com.base.admin.inventory.service.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.base.admin.inventory.dto.request.StockPickingDTO;
import com.base.admin.inventory.dto.request.StockPickingUpdateDTO;
import com.base.admin.inventory.entity.StockPicking;
import com.base.admin.inventory.mapper.StockPickingMapper;
import com.base.admin.inventory.mapstruct.StockPickingMapstruct;
import com.base.admin.inventory.service.StockPickingService;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StockPickingServiceImpl implements StockPickingService {
    StockPickingMapper stockPickingMapper;

    StockPickingMapstruct stockPickingMapstruct;

    public StockPickingServiceImpl(StockPickingMapper stockPickingMapper, StockPickingMapstruct stockPickingMapstruct) {
        this.stockPickingMapper = stockPickingMapper;
        this.stockPickingMapstruct = stockPickingMapstruct;
    }

    @Override
    public int create(StockPickingDTO stockPickingDTO) {
        StockPicking stockPicking = stockPickingMapstruct.toEntity(stockPickingDTO);
        return stockPickingMapper.insert(stockPicking);
    }

    @Override
    public StockPicking findById(UUID id) {
        return stockPickingMapper.selectByPrimaryKey(id);
    }

    @Override
    public int update(StockPickingUpdateDTO request) {
        StockPicking stockPicking = new StockPicking();
        stockPickingMapstruct.updateByDTO(stockPicking, request);
        return stockPickingMapper.updateByPrimaryKeySelective(stockPicking);
    }

    @Override
    public int delete(UUID id) {
        return stockPickingMapper.deleteByPrimaryKey(id);
    }
}
