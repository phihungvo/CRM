package com.base.admin.inventory.service.impl;

import com.base.admin.inventory.dto.request.PagedRequest;
import com.base.admin.inventory.entity.Provider;
import com.base.admin.inventory.mapper.ProviderMapper;
import com.base.admin.inventory.service.ProviderService;
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
public class ProviderServiceImpl implements ProviderService {

    private final ProviderMapper providerMapper;

    @Override
    public Optional<Provider> findById(UUID id) {
        return providerMapper.findById(id);
    }

    @Override
    public List<Provider> findAll() {
        return providerMapper.findAll();
    }

    @Override
    public Page<Provider> findPage(PagedRequest pagedRequest) {
        PageUtil pageUtil = new PageUtil(pagedRequest);
        List<Provider> providers = providerMapper.findPage(pageUtil.getLimit(), pageUtil.getOffset());
        long count = providerMapper.count();
        return new PageImpl<>(providers, pageUtil.getPageable(), count);
    }

    @Override
    public boolean existsByName(String providername) {
        return providerMapper.existsByProvidername(providername);
    }

    @Override
    public UUID save(Provider provider) {
        if (findById(provider.getId()).isPresent()) {
            providerMapper.update(provider);
        } else {
            provider.setId(UUID.randomUUID());
            providerMapper.save(provider);
        }
        return provider.getId();
    }

    @Override
    public boolean existById(UUID providerid) {
        return providerMapper.existById(providerid);
    }

    @Override
    public boolean delete(UUID providerid) {
        return providerMapper.deleteById(providerid);
    }
}
