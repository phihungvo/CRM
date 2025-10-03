package com.base.admin.inventory.entity;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Setter
@Getter
public class DeliveryDetail {
    private UUID id;
    private UUID deliveryid;
    private UUID warehouseid;
    private UUID productid;
    private Double deliveryquantity;
    private LocalDate expecteddate;
    private LocalDate actualdate;
    private Double productprice;
    private Double discount;
    private UUID taxtypeid;
    private Double ordertaxvalue;
    private Double subtotal;
    private Integer status;
    private Integer paymentstatus;
    @Size(max = 255)
    private String note;
}
