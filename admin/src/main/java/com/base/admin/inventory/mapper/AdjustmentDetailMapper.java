package com.base.admin.inventory.mapper;

import com.base.admin.inventory.entity.AdjustmentDetail;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Mapper
public interface AdjustmentDetailMapper {
    @Select("SELECT * FROM adjustmentdetail WHERE CAST(adjustmentdetailid AS VARCHAR) = #{id,jdbcType=VARCHAR}")
    List<AdjustmentDetail> findByAdjustmentid(@Param("id") UUID id);

    @Insert("""
                        <script>
                        INSERT INTO adjustmentdetail (adjustmentdetailid, adjustmentid, warehouseid, warehousename, productid,
                        productname, productcode, minimumstocklevel, quantityavailable, maximumstocklevel,
                        adjustquantity, adjustment_type)
                        VALUES
                        <foreach collection="list" item="item" open="(" separator="),(" close=")">
                                              #{item.id,jdbcType=OTHER,typeHandler=UUIDTypeHandler},
                                              #{item.adjustmentid,jdbcType=OTHER,typeHandler=UUIDTypeHandler}, 
                                              #{item.warehouseid,jdbcType=OTHER,typeHandler=UUIDTypeHandler}, 
                                              #{item.warehousename, jdbcType=VARCHAR},
                                              #{item.productid,jdbcType=OTHER,typeHandler=UUIDTypeHandler},
                                              #{item.productname,jdbcType=VARCHAR}, 
                                              #{item.productcode,jdbcType=VARCHAR},
                                              #{item.minimumstocklevel,jdbcType=DOUBLE}, 
                                              #{item.quantityavailable,jdbcType=DOUBLE},
                                              #{item.maximumstocklevel,jdbcType=DOUBLE}, 
                                              #{item.adjustquantity,jdbcType=DOUBLE},
                                              #{item.adjustmentType,jdbcType=DOUBLE}
                                          </foreach>    
                         </script>      
            """)
    void saveAll(@Param("list") List<AdjustmentDetail> adjustmentDetailList);

    @Select("SELECT * FROM adjustmentdetail WHERE CAST(adjustmentdetailid AS VARCHAR) = #{id,jdbcType=VARCHAR}")
    Optional<AdjustmentDetail> findById(UUID id);

    @Select("""
                    SELECT
                    adjustmentdetail.*
                    FROM
                    adjustmentdetail
                    WHERE
                    cast(adjustmentdetail.adjustmentid as varchar) = #{adjustmentid,jdbcType=VARCHAR}
                    order by
                    adjustmentdetail.productname ASC
                    limit #{limit} offset #{offset}
            """)
    List<AdjustmentDetail> findPageByAdjustmentId(@Param("limit") int limit,
                                                  @Param("offset") int offset,
                                                  @Param("adjustmentid") UUID adjustmentid);

    @Select("""
                select count(*) from adjustmentdetail where cast(adjustmentdetail.adjustmentid as varchar) = #{adjustmentid,jdbcType=VARCHAR}
            """)
    long adjustmentDetailCount(@Param("adjustmentid") UUID adjustmentid);
}
