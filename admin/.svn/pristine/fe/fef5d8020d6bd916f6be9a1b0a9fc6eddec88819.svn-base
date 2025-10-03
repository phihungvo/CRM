package com.base.admin.inventory.mapper;

import com.base.admin.inventory.entity.Adjustment;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Mapper
public interface AdjustmentMapper {
    @Select("SELECT * FROM adjustment WHERE CAST(adjustmentid AS VARCHAR) = #{id,jdbcType=VARCHAR}")
    Optional<Adjustment> findById(@Param("id") UUID id);

    @Select("SELECT * FROM adjustment LIMIT #{limit} OFFSET #{offset}")
    List<Adjustment> adjustmentList(@Param("limit") int limit, @Param("offset") int offset);

    @Select("SELECT COUNT(*) FROM adjustment")
    long countAdjustmentList();

    @Select("SELECT EXISTS(SELECT * FROM adjustment WHERE adjustmentnumber = #{adjustmentnumber,jdbcType=VARCHAR} )")
    boolean existsByAdjustmentnumber(@Param("adjustmentnumber") String adjustmentnumber);

    @Insert("""
                INSERT INTO adjustment (adjustmentid, adjustmentdate, adjustmentnumber, warehouseid, status, note)
                VALUES (#{id,jdbcType=OTHER,typeHandler=UUIDTypeHandler},
                        #{adjustmentdate, jdbcType=DATE}, 
                        #{adjustmentnumber, jdbcType=VARCHAR}, 
                        #{warehouseid,jdbcType=OTHER,typeHandler=UUIDTypeHandler}, 
                        #{status,jdbcType=DOUBLE}, 
                        #{note,jdbcType=VARCHAR})
            """)
    void save(Adjustment adjustment);
}
