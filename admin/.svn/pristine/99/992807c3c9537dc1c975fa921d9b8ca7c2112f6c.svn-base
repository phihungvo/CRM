package com.base.admin.inventory.service;

import com.base.admin.inventory.dto.request.PagedRequest;
import com.base.admin.inventory.entity.Barcode;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BarcodeService {
    Optional<Barcode> findById(UUID id);

    List<Barcode> findAll();

    Page<Barcode> findPage(PagedRequest pagedRequest);

    boolean existsByBarcodename(String barcodename);

    UUID save(Barcode barcode);

    boolean existById(UUID barcodeid);

    boolean delete(UUID barcodeid);
}
