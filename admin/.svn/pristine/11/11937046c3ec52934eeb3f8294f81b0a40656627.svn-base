package com.base.admin.inventory.service;

import com.base.admin.inventory.entity.OrderDetail;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrderDetailService {
    List<OrderDetail> findByOrderId(UUID id);

    Optional<OrderDetail> findById(UUID id);

    UUID save(OrderDetail order);

    boolean existById(UUID orderdetailid);

    boolean delete(UUID orderdetailid);
}
