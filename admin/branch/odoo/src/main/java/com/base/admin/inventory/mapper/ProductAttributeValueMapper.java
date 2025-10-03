package com.base.admin.inventory.mapper;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;

import org.apache.ibatis.annotations.Select;

import com.base.admin.inventory.entity.ProductAttributeValue;

public interface ProductAttributeValueMapper {
    int deleteByPrimaryKey(UUID id);

    int insert(ProductAttributeValue record);

    int insertSelective(ProductAttributeValue record);

    ProductAttributeValue selectByPrimaryKey(UUID id);

    int updateByPrimaryKeySelective(ProductAttributeValue record);

    int updateByPrimaryKey(ProductAttributeValue record);

    @Select("SELECT * FROM product_attribute_value WHERE name = #{attributeValue}")
    ProductAttributeValue seletAttributeValueByName(
            @NotBlank(message = "giá trị thuộc tính không được để trống") String attributeValue);
}
