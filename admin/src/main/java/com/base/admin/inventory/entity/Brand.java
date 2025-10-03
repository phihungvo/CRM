package com.base.admin.inventory.entity;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

@Getter
@Setter
public class Brand {

    private UUID id;
    @Size(max = 255)
    private String brandname;
    @Size(max = 255)
    private String branddescription;
}