package com.base.admin.inventory.entity;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
public class Barcode {
    private UUID id;
    @Size(max = 255)
    private String barcodename;
}
