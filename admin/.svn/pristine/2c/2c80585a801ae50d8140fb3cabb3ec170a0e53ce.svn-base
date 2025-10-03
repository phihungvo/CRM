package com.base.admin.inventory.service;

import com.base.admin.inventory.dto.request.DeliveryRequest;
import com.base.admin.inventory.dto.request.PagedRequest;
import com.base.admin.inventory.dto.response.DeliveryResponse;
import com.base.admin.inventory.entity.Delivery;
import org.springframework.data.domain.Page;

import java.util.Optional;
import java.util.UUID;

public interface DeliveryService {
    Optional<Delivery> findById(UUID id);

    Page<Delivery> findPage(PagedRequest pagedRequest);

    Optional<Delivery> findByDeliverynumber(String deliverynumber);

    DeliveryResponse saveDelivery(DeliveryRequest deliveryRequest);

    UUID save(Delivery delivery);

    boolean existById(UUID deliveryid);

    boolean delete(UUID deliveryid);
}
