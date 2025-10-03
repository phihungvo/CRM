package com.base.admin.inventory.dto.request;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class StockQuantUpdateDTO {
    UUID id;

    String name;

    String usage;
}
