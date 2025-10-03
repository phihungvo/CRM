package com.base.admin.inventory.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.base.admin.inventory.dto.request.ResCompanyDTO;
import com.base.admin.inventory.dto.request.ResCompanyUpdateDTO;
import com.base.admin.inventory.entity.ResCompany;
import com.base.admin.inventory.mapstruct.config.MapstructConfig;

@Mapper(config = MapstructConfig.class)
public interface ResCompanyMapstruct extends EntityMapper<ResCompanyDTO, ResCompany> {
    void updateByDTO(@MappingTarget ResCompany resCompany, ResCompanyUpdateDTO request);
}
