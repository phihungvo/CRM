package com.base.admin.inventory.dto;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;
@Setter
@Getter
public class AdjustmentDTO {
    private UUID id;
    private LocalDate adjustmentdate;
    @Size(max = 255)
    private String adjustmentnumber;
    private UUID warehouseid;
    private Double status;
    @Size(max = 255)
    private String note;
}
