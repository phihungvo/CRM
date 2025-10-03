package com.base.admin.inventory.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.base.admin.inventory.dto.request.StockInventoryDTO;
import com.base.admin.inventory.dto.request.StockInventoryUpdateDTO;
import com.base.admin.inventory.entity.StockInventory;
import com.base.admin.inventory.mapstruct.config.MapstructConfig;

@Mapper(config = MapstructConfig.class)
public interface StockInventoryMapstruct extends EntityMapper<StockInventoryDTO, StockInventory> {
    void updateByDTO(@MappingTarget StockInventory stockInventory, StockInventoryUpdateDTO stockInventoryUpdateDTO);
}
