package com.base.admin.inventory.entity;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Setter
@Getter
public class OrderDetail {
    private UUID id;
    private UUID orderid;
    private UUID warehouseid;
    private UUID productid;
    private Double orderquantity;
    private LocalDate expecteddate;
    private LocalDate actualdate;
    private Double productcost;
    private Double discount;
    private UUID taxtypeid;
    private Double ordertaxvalue;
    private Double subtotal;
    private Integer status;
    @Size(max = 255)
    private String note;
}
