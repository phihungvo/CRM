package com.base.admin.inventory.service;


import com.base.admin.inventory.dto.response.AdjustmentResponse;
import com.base.admin.inventory.dto.request.AdjustmentRequest;
import com.base.admin.inventory.dto.request.PagedRequest;
import com.base.admin.inventory.entity.Adjustment;
import jakarta.validation.constraints.Size;
import org.springframework.data.domain.Page;

import java.util.Optional;
import java.util.UUID;

public interface AdjustmentService {
    Optional<Adjustment> findById(UUID id);

    Page<Adjustment> findPage(PagedRequest pagedRequest);

    AdjustmentResponse saveAdjustment(AdjustmentRequest adjustmentRequest);

    boolean existsByAdjustmentnumber(@Size(max = 255) String adjustmentnumber);
}
