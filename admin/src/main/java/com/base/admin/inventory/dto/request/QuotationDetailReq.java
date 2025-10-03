package com.base.admin.inventory.dto.request;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class QuotationDetailReq {
    private UUID quotationid;
    private UUID warehouseid;
    private UUID productid;
    private Double quantity;
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
