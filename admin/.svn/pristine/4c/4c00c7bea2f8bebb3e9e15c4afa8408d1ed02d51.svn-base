package com.base.admin.inventory.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.base.admin.inventory.dto.request.ResPartnerDTO;
import com.base.admin.inventory.dto.request.ResPartnerUpdateDTO;
import com.base.admin.inventory.entity.ResPartner;
import com.base.admin.inventory.mapstruct.config.MapstructConfig;

@Mapper(config = MapstructConfig.class)
public interface ResPartnerMapstruct extends EntityMapper<ResPartnerDTO, ResPartner> {
    void updateByDTO(@MappingTarget ResPartner resPartner, ResPartnerUpdateDTO request);
}
