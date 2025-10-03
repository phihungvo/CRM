package com.base.admin.inventory.service.impl;

import com.base.admin.inventory.entity.Brand;
import com.base.admin.inventory.service.BrandService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;

    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public Optional<Brand> findById(UUID id) {
        return brandRepository.findById(id);
    }
}
