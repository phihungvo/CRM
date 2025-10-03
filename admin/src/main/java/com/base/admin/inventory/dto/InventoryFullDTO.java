package com.base.admin.inventory.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
public class InventoryFullDTO {
    private UUID id;
    private Double minimumstocklevel;
    private Double quantityavailable;
    private Double maximumstocklevel;
    private Double reorderpoint;
    private UUID warehouseid;
    private String warehousename;
    private UUID productid;
    private String productname;
}