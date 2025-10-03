package com.base.admin.inventory.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.base.admin.inventory.dto.request.UomUomDTO;
import com.base.admin.inventory.dto.request.UomUomUpdateDTO;
import com.base.admin.inventory.entity.UomUom;
import com.base.admin.inventory.mapstruct.config.MapstructConfig;

/**
 * Mapper for the entity {@link UomUom} and its DTO called {@link UomUomDTO}.
 */
@Mapper(config = MapstructConfig.class)
public interface UomUomMapstruct extends EntityMapper<UomUomDTO, UomUom> {
    void updateByDto(@MappingTarget UomUom uomUom, UomUomUpdateDTO request);
}
