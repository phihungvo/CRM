package com.base.admin.inventory.service;

import com.base.admin.inventory.entity.Brand;

import java.util.Optional;
import java.util.UUID;

public interface BrandService {

    Optional<Brand> findById(UUID id);
}
