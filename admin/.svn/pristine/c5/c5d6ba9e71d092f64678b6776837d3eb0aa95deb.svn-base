package com.base.admin.inventory.dto;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class DeliveryDetailFullDTO implements Serializable {
    private UUID id;
    private UUID deliveryid;
    private UUID warehouseid;
    private String warehousename;
    private UUID productid;
    private String productname;
    private Double deliveryquantity;
    private LocalDate expecteddate;
    private LocalDate actualdate;
    private Double productprice;
    private Double discount;
    private UUID taxtypeid;
    private String taxtypename;
    private Double ordertaxvalue;
    private Double subtotal;
    //    private Double shippingfee;
    private Integer status;
    private Integer paymentstatus;
    @Size(max = 255)
    private String note;
}
