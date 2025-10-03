package com.base.admin.inventory.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.base.admin.inventory.dto.request.StockPickingDTO;
import com.base.admin.inventory.dto.request.StockPickingUpdateDTO;
import com.base.admin.inventory.entity.StockPicking;
import com.base.admin.inventory.mapstruct.config.MapstructConfig;

@Mapper(config = MapstructConfig.class)
public interface StockPickingMapstruct extends EntityMapper<StockPickingDTO, StockPicking> {
    void updateByDTO(@MappingTarget StockPicking stockPicking, StockPickingUpdateDTO updateDTO);
}
