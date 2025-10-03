package com.base.admin.inventory.entity;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
public class AdjustmentDetail {
    private UUID id;
    private UUID adjustmentid;
    private UUID warehouseid;
    private String warehousename;
    private UUID productid;
    private String productname;
    @Size(max = 255)
    private String productcode;
    private Double minimumstocklevel;
    private Double quantityavailable;
    private Double maximumstocklevel;
    private Double adjustquantity;
    private Double adjustmentType;
}
