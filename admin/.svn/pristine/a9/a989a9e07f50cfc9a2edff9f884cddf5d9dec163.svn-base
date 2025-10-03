package com.base.admin.inventory.service.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.base.admin.inventory.dto.request.StockPickingTypeDTO;
import com.base.admin.inventory.dto.request.StockPickingTypeUpdateDTO;
import com.base.admin.inventory.entity.StockPickingType;
import com.base.admin.inventory.mapper.StockPickingTypeMapper;
import com.base.admin.inventory.mapstruct.StockPickingTypeMapstruct;
import com.base.admin.inventory.service.StockPickingTypeService;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StockPickingTypeServiceImpl implements StockPickingTypeService {

    StockPickingTypeMapper stockPickingTypeMapper;

    StockPickingTypeMapstruct stockPickingTypeMapstruct;

    public StockPickingTypeServiceImpl(
            StockPickingTypeMapper stockPickingTypeMapper, StockPickingTypeMapstruct stockPickingTypeMapstruct) {
        this.stockPickingTypeMapper = stockPickingTypeMapper;
        this.stockPickingTypeMapstruct = stockPickingTypeMapstruct;
    }

    @Override
    public int create(StockPickingTypeDTO stockPickingTypeDTO) {
        StockPickingType stockPickingType = stockPickingTypeMapstruct.toEntity(stockPickingTypeDTO);
        return stockPickingTypeMapper.insert(stockPickingType);
    }

    @Override
    public StockPickingType findById(UUID id) {
        return stockPickingTypeMapper.selectByPrimaryKey(id);
    }

    @Override
    public int update(StockPickingTypeUpdateDTO request) {
        StockPickingType stockPickingType = new StockPickingType();
        stockPickingTypeMapstruct.updateByDTO(stockPickingType, request);
        return stockPickingTypeMapper.updateByPrimaryKeySelective(stockPickingType);
    }

    @Override
    public int delete(UUID id) {
        return stockPickingTypeMapper.deleteByPrimaryKey(id);
    }
}
