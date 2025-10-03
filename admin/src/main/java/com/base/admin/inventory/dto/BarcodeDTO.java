package com.base.admin.inventory.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class BarcodeDTO {
    private UUID id;
    private String barcodename;
}
