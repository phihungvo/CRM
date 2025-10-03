package com.base.admin.inventory.mapper;

import com.base.admin.inventory.entity.Brand;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.Optional;
import java.util.UUID;

@Mapper
public interface BrandRepository {
    @Select("SELECT * FROM brand WHERE cast(brandid as varchar) = #{id,jdbcType=VARCHAR}")
    Optional<Brand> findById(@Param("id") UUID id);
}
