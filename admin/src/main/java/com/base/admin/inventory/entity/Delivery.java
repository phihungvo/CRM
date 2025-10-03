package com.base.admin.inventory.entity;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Setter
@Getter
public class Delivery {
    private UUID id;
    private LocalDate salesdate;
    private UUID customerid;
    @Size(max = 255)
    private String deliverynumber;
    private Double subtotal;
    private Double discount;
    private UUID taxtypeid;
    private Double ordertaxvalue;
    private Double shippingfee;
    private Double status;
    private Double grandtotal;
    private Double paid;
    private LocalDate paidduedate;
    private Integer paymentstatus;
    @Size(max = 255)
    private String note;
}
