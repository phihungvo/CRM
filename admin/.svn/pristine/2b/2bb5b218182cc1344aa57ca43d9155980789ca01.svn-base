package com.base.admin.inventory.service;

import com.base.admin.inventory.dto.request.PagedRequest;
import com.base.admin.inventory.entity.Brand;
import com.base.admin.inventory.entity.Provider;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProviderService {

    Optional<Provider> findById(UUID id);

    List<Provider> findAll();

    Page<Provider> findPage(PagedRequest pagedRequest);

    boolean existsByName(String providername);

    UUID save(Provider provider);

    boolean existById(UUID providerid);

    boolean delete(UUID providerid);
}
