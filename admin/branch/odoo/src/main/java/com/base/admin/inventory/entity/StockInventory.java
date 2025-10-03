package com.base.admin.inventory.entity;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class StockInventory extends ModelEntity {

    String name;

    UUID locationId;

    String usage;
}
