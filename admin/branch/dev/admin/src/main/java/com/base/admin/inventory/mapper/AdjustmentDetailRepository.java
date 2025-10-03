package com.base.admin.inventory.mapper;

import com.base.admin.inventory.entity.AdjustmentDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.UUID;

@Mapper
public interface AdjustmentDetailRepository {
    List<AdjustmentDetail> findByAdjustmentid(@Param("id") UUID id);
}
