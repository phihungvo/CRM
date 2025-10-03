package com.base.admin.inventory.service;

import com.base.admin.inventory.dto.request.PagedRequest;
import com.base.admin.inventory.entity.Brand;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BrandService {

    Optional<Brand> findById(UUID id);

    List<Brand> findAll();

    Page<Brand> findPage(PagedRequest pagedRequest);

    boolean existsByBrandname(String brandname);

    UUID save(Brand brand);

    boolean existById(UUID brandid);

    boolean delete(UUID brandid);
}
