package com.base.admin.inventory.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.base.admin.inventory.dto.request.StockWarehouseDTO;
import com.base.admin.inventory.dto.request.StockWarehouseUpdateDTO;
import com.base.admin.inventory.entity.StockWarehouse;
import com.base.admin.inventory.mapstruct.config.MapstructConfig;

@Mapper(config = MapstructConfig.class)
public interface StockWarehouseMapstruct extends EntityMapper<StockWarehouseDTO, StockWarehouse> {
    //    void updateByDTO()
    void updateByDTO(@MappingTarget StockWarehouse stockWarehouse, StockWarehouseUpdateDTO stockWarehouseDTO);
}
