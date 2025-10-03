package com.base.admin.inventory.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.base.admin.inventory.dto.request.ResPartnerDTO;
import com.base.admin.inventory.dto.request.ResPartnerUpdateDTO;
import com.base.admin.inventory.entity.ResPartner;
import com.base.admin.inventory.mapper.ResPartnerMapper;
import com.base.admin.inventory.mapstruct.ResPartnerMapstruct;
import com.base.admin.inventory.service.ResPartnerService;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ResPartnerServiceImpl implements ResPartnerService {

    ResPartnerMapper resPartnerMapper;

    ResPartnerMapstruct resPartnerMapstruct;

    public ResPartnerServiceImpl(ResPartnerMapper resPartnerMapper, ResPartnerMapstruct resPartnerMapstruct) {
        this.resPartnerMapper = resPartnerMapper;
        this.resPartnerMapstruct = resPartnerMapstruct;
    }

    @Override
    public int create(ResPartnerDTO request) {
        ResPartner resPartner = resPartnerMapstruct.toEntity(request);
        return resPartnerMapper.insert(resPartner);
    }

    @Override
    public ResPartner findById(UUID id) {
        return resPartnerMapper.selectByPrimaryKey(id);
    }

    @Override
    public int update(ResPartnerUpdateDTO request) {
        ResPartner resPartner = new ResPartner();
        resPartnerMapstruct.updateByDTO(resPartner, request);
        return resPartnerMapper.updateByPrimaryKeySelective(resPartner);
    }

    @Override
    public int deleteById(UUID id) {
        return resPartnerMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<ResPartner> findAll() {
        return resPartnerMapper.findAll();
    }
}
