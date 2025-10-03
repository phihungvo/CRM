package com.base.admin.inventory.service.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.base.admin.inventory.dto.request.UomCategoryDTO;
import com.base.admin.inventory.entity.UomCategory;
import com.base.admin.inventory.mapper.UomCategoryMapper;
import com.base.admin.inventory.mapstruct.UomCategoryMapstruct;
import com.base.admin.inventory.service.UomCategoryService;

@Service
public class UomCategoryImpl implements UomCategoryService {
    private final UomCategoryMapper uomCategoryMapper;
    private final UomCategoryMapstruct uomCategoryMapstruct;

    public UomCategoryImpl(UomCategoryMapper uomCategoryMapper, UomCategoryMapstruct uomCategoryMapstruct) {
        this.uomCategoryMapper = uomCategoryMapper;
        this.uomCategoryMapstruct = uomCategoryMapstruct;
    }

    @Override
    public int create(UomCategoryDTO request) {
        UomCategory uomCategory = uomCategoryMapstruct.toEntity(request);
        return uomCategoryMapper.insert(uomCategory);
    }

    @Override
    public UomCategory findById(UUID id) {
        return uomCategoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public int deleteById(UUID id) {
        return uomCategoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(UomCategory request) {
        return uomCategoryMapper.updateByPrimaryKey(request);
    }
}
