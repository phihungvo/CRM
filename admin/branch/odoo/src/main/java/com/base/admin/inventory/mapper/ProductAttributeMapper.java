package com.base.admin.inventory.mapper;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;

import org.apache.ibatis.annotations.Select;

import com.base.admin.inventory.entity.ProductAttribute;

public interface ProductAttributeMapper {
    int deleteByPrimaryKey(UUID id);

    int insert(ProductAttribute record);

    int insertSelective(ProductAttribute record);

    ProductAttribute selectByPrimaryKey(UUID id);

    int updateByPrimaryKeySelective(ProductAttribute record);

    int updateByPrimaryKey(ProductAttribute record);

    @Select("SELECT * FROM product_attribute WHERE name = #{attributeName}")
    ProductAttribute selectAttributeByName(
            @NotBlank(message = "tên thuộc tính không được để trống") String attributeName);
}
