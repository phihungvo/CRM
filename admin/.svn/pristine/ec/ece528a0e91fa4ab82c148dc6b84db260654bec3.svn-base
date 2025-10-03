package com.base.admin.inventory.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.base.admin.inventory.dto.request.ResCompanyDTO;
import com.base.admin.inventory.dto.request.ResCompanyUpdateDTO;
import com.base.admin.inventory.entity.ResCompany;
import com.base.admin.inventory.mapper.ResCompanyMapper;
import com.base.admin.inventory.mapstruct.ResCompanyMapstruct;
import com.base.admin.inventory.service.ResCompanyService;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ResCompanyServiceImpl implements ResCompanyService {

    ResCompanyMapper resCompanyMapper;

    ResCompanyMapstruct resCompanyMapstruct;

    public ResCompanyServiceImpl(ResCompanyMapper resCompanyMapper, ResCompanyMapstruct resCompanyMapstruct) {
        this.resCompanyMapper = resCompanyMapper;
        this.resCompanyMapstruct = resCompanyMapstruct;
    }

    @Override
    public List<ResCompany> getAll() {
        return resCompanyMapper.getAll();
    }

    @Override
    public int create(ResCompanyDTO request) {
        ResCompany resCompany = resCompanyMapstruct.toEntity(request);
        return resCompanyMapper.insertSelective(resCompany);
    }

    @Override
    public ResCompany findById(UUID resCompanyId) {
        return resCompanyMapper.selectByPrimaryKey(resCompanyId);
    }

    @Override
    public int update(ResCompanyUpdateDTO request) {
        ResCompany resCompany = new ResCompany();
        resCompanyMapstruct.updateByDTO(resCompany, request);
        return resCompanyMapper.updateByPrimaryKey(resCompany);
    }

    @Override
    public int deleteById(UUID id) {
        return resCompanyMapper.deleteByPrimaryKey(id);
    }
}
