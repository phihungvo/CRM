package com.base.admin.inventory.service.impl;

import com.base.admin.inventory.entity.OrderDetail;
import com.base.admin.inventory.service.OrderDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderDetailServiceImpl implements OrderDetailService {

    @Override
    public List<OrderDetail> findByOrderId(UUID id) {
        return List.of();
    }

    @Override
    public Optional<OrderDetail> findById(UUID id) {
        return Optional.empty();
    }

    @Override
    public UUID save(OrderDetail order) {
        return null;
    }

    @Override
    public boolean existById(UUID orderdetailid) {
        return false;
    }

    @Override
    public boolean delete(UUID orderdetailid) {
        return false;
    }
}
