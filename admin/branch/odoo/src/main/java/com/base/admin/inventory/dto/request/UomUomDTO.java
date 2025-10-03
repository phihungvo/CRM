package com.base.admin.inventory.dto.request;

import java.util.UUID;

import com.base.admin.inventory.entity.UomUom;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

/**
 * Dto for the entity {@link UomUom}
 */
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UomUomDTO {
    String name;

    UUID categoryId;
}
