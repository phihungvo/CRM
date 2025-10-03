package com.base.admin.inventory.service.impl;

import com.base.admin.inventory.dto.request.PagedRequest;
import com.base.admin.inventory.entity.AdjustmentDetail;
import com.base.admin.inventory.mapper.AdjustmentDetailMapper;
import com.base.admin.inventory.service.AdjustmentDetailService;
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
public class AdjustmentDetailServiceImpl implements AdjustmentDetailService {
    private final AdjustmentDetailMapper adjustmentDetailMapper;

    @Override
    public List<AdjustmentDetail> findByAdjustmentId(UUID id) {
        return adjustmentDetailMapper.findByAdjustmentid(id);
    }

    @Override
    public Optional<AdjustmentDetail> findById(UUID id) {
        return adjustmentDetailMapper.findById(id);
    }

    @Override
    public Page<AdjustmentDetail> findPageByAdjustmentId(PagedRequest pagedRequest, UUID adjustmentid) {
        PageUtil pageable = new PageUtil(pagedRequest);
        List<AdjustmentDetail> adjustmentDetails = adjustmentDetailMapper.findPageByAdjustmentId(
                pageable.getLimit(), pageable.getOffset(),
                adjustmentid);
        long adjustmentDetailCount = adjustmentDetailMapper.adjustmentDetailCount(adjustmentid);
        return new PageImpl<>(adjustmentDetails, pageable.getPageable(), adjustmentDetailCount);
    }
}
