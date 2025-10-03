package com.base.admin.inventory.service;

import com.base.admin.inventory.dto.request.PagedRequest;
import com.base.admin.inventory.entity.AdjustmentDetail;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AdjustmentDetailService {
    List<AdjustmentDetail> findByAdjustmentId(UUID id);

    Optional<AdjustmentDetail> findById(UUID id);

    Page<AdjustmentDetail> findPageByAdjustmentId(PagedRequest pagedRequest, UUID adjustmentid);
}
