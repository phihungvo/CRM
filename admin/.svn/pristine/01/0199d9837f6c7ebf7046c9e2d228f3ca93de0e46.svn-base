package com.base.admin.inventory.mapper;

import com.base.admin.inventory.entity.Adjustment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.Optional;
import java.util.UUID;

@Mapper
public interface AdjustmentRepository {
    @Select("SELECT * FROM adjustment WHERE cast(adjustmentid as varchar) = #{id,jdbcType=VARCHAR}")
    Optional<Adjustment> findById(@Param("id") UUID id);
}
