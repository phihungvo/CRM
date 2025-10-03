package com.base.admin.inventory.service;

import java.util.UUID;

import com.base.admin.inventory.dto.request.StockQuantDTO;
import com.base.admin.inventory.dto.request.StockQuantUpdateDTO;

public interface StockQuantService {
    int create(StockQuantDTO stockQuantDTO);

    int findById(UUID id);

    int update(StockQuantUpdateDTO request);

    int deleteById(UUID id);
}
