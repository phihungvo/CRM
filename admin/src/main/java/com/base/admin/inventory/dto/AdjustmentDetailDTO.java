package com.base.admin.inventory.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@Setter
@Getter
public class AdjustmentDetailDTO {
    private UUID id;
    @NotNull
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
