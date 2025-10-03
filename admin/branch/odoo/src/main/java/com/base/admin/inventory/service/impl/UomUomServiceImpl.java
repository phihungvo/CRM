package com.base.admin.inventory.service.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.base.admin.inventory.dto.request.UomUomDTO;
import com.base.admin.inventory.dto.request.UomUomUpdateDTO;
import com.base.admin.inventory.entity.UomUom;
import com.base.admin.inventory.mapper.UomUomMapper;
import com.base.admin.inventory.mapstruct.UomUomMapstruct;
import com.base.admin.inventory.service.UomUomService;

@Service
public class UomUomServiceImpl implements UomUomService {
    private final UomUomMapper uomUomMapper;
    private final UomUomMapstruct uomUomMapstruct;

    public UomUomServiceImpl(UomUomMapper uomUomMapper, UomUomMapstruct uomUomMapstruct) {
        this.uomUomMapper = uomUomMapper;
        this.uomUomMapstruct = uomUomMapstruct;
    }

    @Override
    public int create(UomUomDTO request) {
        UomUom uomUom = uomUomMapstruct.toEntity(request);
        return uomUomMapper.insert(uomUom);
    }

    @Override
    public int deleteById(UUID id) {
        return uomUomMapper.deleteByPrimaryKey(id);
    }

    @Override
    public UomUom findById(UUID id) {
        return uomUomMapper.selectByPrimaryKey(id);
    }

    @Override
    public int update(UomUomUpdateDTO request) {
        UomUom uomUom = new UomUom();
        uomUomMapstruct.updateByDto(uomUom, request);
        return uomUomMapper.updateByPrimaryKeySelective(uomUom);
    }
}
