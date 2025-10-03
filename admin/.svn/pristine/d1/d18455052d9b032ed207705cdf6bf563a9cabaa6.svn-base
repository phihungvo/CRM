package com.base.admin.inventory.service.impl;

import com.base.admin.inventory.dto.request.PagedRequest;
import com.base.admin.inventory.entity.Barcode;
import com.base.admin.inventory.mapper.BarcodeMapper;
import com.base.admin.inventory.service.BarcodeService;
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
public class BarcodeServiceImpl implements BarcodeService {

    private final BarcodeMapper barcodeMapper;

    @Override
    public Optional<Barcode> findById(UUID id) {
        return barcodeMapper.findById(id);
    }

    @Override
    public List<Barcode> findAll() {
        return barcodeMapper.findAll();
    }

    @Override
    public Page<Barcode> findPage(PagedRequest pagedRequest) {
        PageUtil pageUtil = new PageUtil(pagedRequest);
        List<Barcode> list = barcodeMapper.findPage(pageUtil.getLimit(), pageUtil.getOffset());
        long barcodeCount = barcodeMapper.findPageCount();
        return new PageImpl<>(list, pageUtil.getPageable(), barcodeCount);
    }

    @Override
    public boolean existsByBarcodename(String barcodename) {
        return barcodeMapper.existsByBarcodename(barcodename);
    }

    @Override
    public UUID save(Barcode barcode) {
        barcode.setId(UUID.randomUUID());
        barcodeMapper.save(barcode);
        return barcode.getId();
    }

    @Override
    public boolean existById(UUID barcodeid) {
        return barcodeMapper.existById(barcodeid);
    }

    @Override
    public boolean delete(UUID barcodeid) {
        return barcodeMapper.deleteById(barcodeid);
    }
}
