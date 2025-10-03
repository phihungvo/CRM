package com.base.admin.inventory.service;

import com.base.admin.inventory.dto.request.PagedRequest;
import com.base.admin.inventory.entity.DeliveryDetail;
import com.base.admin.inventory.entity.DeliveryDetailFull;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DeliveryDetailService {
    List<DeliveryDetail> findByDeliveryId(UUID id);

    Optional<DeliveryDetail> findById(UUID id);

    UUID save(DeliveryDetail deliveryDetail);

    boolean existById(UUID deliverydetailid);

    boolean delete(UUID deliverydetailid);

    Page<DeliveryDetailFull> findPageByDeliveryId(PagedRequest pagedRequest, UUID deliveryid);
}
