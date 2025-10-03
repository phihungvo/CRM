package com.base.admin.inventory.service;

import java.util.UUID;

import com.base.admin.inventory.dto.request.StockPickingDTO;
import com.base.admin.inventory.dto.request.StockPickingUpdateDTO;
import com.base.admin.inventory.entity.StockPicking;

public interface StockPickingService {
    int create(StockPickingDTO stockPickingDTO);

    StockPicking findById(UUID id);

    int update(StockPickingUpdateDTO request);

    int delete(UUID id);
}
