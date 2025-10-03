package com.base.admin.inventory.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.base.admin.inventory.dto.request.StockPickingTypeDTO;
import com.base.admin.inventory.dto.request.StockPickingTypeUpdateDTO;
import com.base.admin.inventory.entity.StockPickingType;
import com.base.admin.inventory.mapstruct.config.MapstructConfig;

@Mapper(config = MapstructConfig.class)
public interface StockPickingTypeMapstruct extends EntityMapper<StockPickingTypeDTO, StockPickingType> {
    void updateByDTO(
            @MappingTarget StockPickingType stockPickingType, StockPickingTypeUpdateDTO stockPickingTypeUpdateDTO);
}
