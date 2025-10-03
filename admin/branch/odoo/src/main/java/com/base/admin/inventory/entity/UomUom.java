package com.base.admin.inventory.entity;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

/**
 * uom_uom
 * @author
 */
@Setter
@Getter
@FieldDefaults(level = lombok.AccessLevel.PRIVATE)
public class UomUom extends ModelEntity {

    String name;

    UUID categoryId;
}
