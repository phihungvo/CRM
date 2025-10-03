package com.base.admin.inventory.dto.request;

import java.util.UUID;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StockPickingDTO {
    String name;

    UUID pickingTypeId;

    UUID partnerId;

    UUID locationId;

    String state;
}
