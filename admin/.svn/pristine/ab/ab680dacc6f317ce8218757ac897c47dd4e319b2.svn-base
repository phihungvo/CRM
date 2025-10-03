package com.base.admin.inventory.service.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.base.admin.inventory.dto.request.StockQuantDTO;
import com.base.admin.inventory.dto.request.StockQuantUpdateDTO;
import com.base.admin.inventory.entity.StockQuant;
import com.base.admin.inventory.mapper.StockQuantMappers;
import com.base.admin.inventory.mapstruct.StockQuantMapstruct;
import com.base.admin.inventory.service.StockQuantService;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StockQuantServiceImpl implements StockQuantService {

    StockQuantMapstruct stockQuantMapstruct;

    StockQuantMappers stockQuantMappers;

    public StockQuantServiceImpl(StockQuantMapstruct stockQuantMapstruct, StockQuantMappers stockQuantMappers) {
        this.stockQuantMapstruct = stockQuantMapstruct;
        this.stockQuantMappers = stockQuantMappers;
    }

    @Override
    public int create(StockQuantDTO stockQuantDTO) {
        StockQuant stockQuant = stockQuantMapstruct.toEntity(stockQuantDTO);
        return stockQuantMappers.insert(stockQuant);
    }

    @Override
    public int findById(UUID id) {
        return stockQuantMappers.selectByPrimaryKey(id);
    }

    @Override
    public int update(StockQuantUpdateDTO request) {
        StockQuant stockQuant = new StockQuant();
        stockQuantMapstruct.updateByDTO(stockQuant, request);
        return stockQuantMappers.updateByPrimaryKeySelective(stockQuant);
    }

    @Override
    public int deleteById(UUID id) {
        return stockQuantMappers.deleteByPrimaryKey(id);
    }
}
