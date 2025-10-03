package com.base.admin.inventory.service.impl;

import com.base.admin.inventory.dto.request.PagedRequest;
import com.base.admin.inventory.entity.Brand;
import com.base.admin.inventory.mapper.BrandMapper;
import com.base.admin.inventory.service.BrandService;
import com.base.admin.inventory.util.PageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements BrandService {

    private final BrandMapper brandMapper;

    @Override
    public Optional<Brand> findById(UUID id) {
        return brandMapper.findById(id);
    }

    @Override
    public List<Brand> findAll() {
        return brandMapper.findAll();
    }

    @Override
    public Page<Brand> findPage(PagedRequest pagedRequest) {
        PageUtil pageUtil = new PageUtil(pagedRequest);
        List<Brand> brands = brandMapper.findPage(pageUtil.getLimit(), pageUtil.getOffset());
        long count = brandMapper.count();
        return new PageImpl<>(brands, pageUtil.getPageable(), count);
    }

    @Override
    public boolean existsByBrandname(String brandname) {
        return brandMapper.existsByBrandname(brandname);
    }

    @Override
    public UUID save(Brand brand) {
        brand.setId(UUID.randomUUID());
        brandMapper.save(brand);
        return brand.getId();
    }

    @Override
    public boolean existById(UUID brandid) {
        return brandMapper.existById(brandid);
    }

    @Override
    public boolean delete(UUID brandid) {
        return brandMapper.deleteById(brandid);
    }
}
