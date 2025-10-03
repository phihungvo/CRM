package com.base.admin.inventory.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.base.admin.inventory.dto.request.StockLocationDTO;
import com.base.admin.inventory.dto.request.StockLocationUpdateDTO;
import com.base.admin.inventory.entity.StockLocation;
import com.base.admin.inventory.mapstruct.config.MapstructConfig;

@Mapper(config = MapstructConfig.class)
public interface StockLocationMapstruct extends EntityMapper<StockLocationDTO, StockLocation> {
    void updateByDTO(@MappingTarget StockLocation stockLocation, StockLocationUpdateDTO stockLocationUpdateDTO);
}
