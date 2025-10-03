package com.base.admin.inventory.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.base.admin.inventory.dto.request.StockQuantDTO;
import com.base.admin.inventory.dto.request.StockQuantUpdateDTO;
import com.base.admin.inventory.entity.StockQuant;
import com.base.admin.inventory.mapstruct.config.MapstructConfig;

@Mapper(config = MapstructConfig.class)
public interface StockQuantMapstruct extends EntityMapper<StockQuantDTO, StockQuant> {
    void updateByDTO(@MappingTarget StockQuant stockQuant, StockQuantUpdateDTO stockQuantUpdateDTO);
}
