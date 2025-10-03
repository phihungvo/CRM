package com.base.admin.inventory.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CustomerDTO {
    private UUID id;
    private String customercode;
    private String customername;
    private String address;
    private String phone;
    private String email;
    private String taxnumber;
}
