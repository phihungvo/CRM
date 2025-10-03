package com.base.admin.inventory.service;

import java.util.UUID;

public interface InventoryService {
    void IncreaseInventory(UUID warehouseid, UUID productid, Double orderquantity);

    void decreaseInventory(UUID warehouseid, UUID productid, Double deliveryquantity);

    boolean existById(UUID inventoryid);

    boolean delete(UUID inventoryid);
}
