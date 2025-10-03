package com.base.admin.inventory.dto.request;

import java.util.UUID;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ResCompanyUpdateDTO {
    UUID id;
    String name;
}
