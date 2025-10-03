package com.base.admin.inventory.service;

import com.base.admin.inventory.dto.request.PagedRequest;
import com.base.admin.inventory.entity.InventoryFull;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface InventoryInfoService {
    List<InventoryFull> findByProductId(UUID productid);

    List<InventoryFull> findByWarehouseId(UUID warehouseid);

    List<InventoryFull> findByProductIdAndWarehouseId(UUID productid, UUID warehouseid);

    Page<InventoryFull> findPage(PagedRequest pagedRequest);

    Page<InventoryFull> searchProductNameOrWarehouseName(PagedRequest pagedRequest, String productOrWarehouse);
}
