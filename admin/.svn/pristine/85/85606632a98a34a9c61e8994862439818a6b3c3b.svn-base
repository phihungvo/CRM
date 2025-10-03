package com.base.admin.inventory.service;

import com.base.admin.inventory.dto.request.OrderRequest;
import com.base.admin.inventory.dto.request.PagedRequest;
import com.base.admin.inventory.dto.response.OrderResponse;
import com.base.admin.inventory.entity.Order;
import org.springframework.data.domain.Page;

import java.util.Optional;
import java.util.UUID;

public interface OrderService {
    Optional<Order> findById(UUID id);

    Page<Order> findPage(PagedRequest pagedRequest);

    Optional<Order> findByOrdernumber(String ordernumber);

    OrderResponse saveOrder(OrderRequest orderRequest);

    UUID save(Order order);

    boolean existById(UUID orderid);

    boolean deleteOrder(UUID orderid);
}
