package com.base.admin.inventory.dto.request;

import java.util.List;

import jakarta.validation.constraints.NotBlank;

import com.base.admin.inventory.entity.ProductAttribute;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

/**
 * Dto for the entity {@link ProductAttribute}
 */
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AttributeDTO {
    @NotBlank(message = "tên thuộc tính không được để trống")
    String attributeName;

    @NotBlank(message = "giá trị thuộc tính không được để trống")
    List<String> attributeValue;
}

/*
 * NotBlank: không được để trống kể cả khoảng trắng khoảng trắng
 * NotNull: không được để trống chấp nhận khoảng trắng và ""
 * NotEmpty:
 * */
