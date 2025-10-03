package com.base.admin.inventory.mapper;

import com.base.admin.inventory.entity.InventoryFull;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.UUID;

@Mapper
public interface InventoryInfoMapper {

    @Select("""
                select * from inventoryfull where cast(productid as varchar) = #{productid,jdbcType=VARCHAR}
            """)
    List<InventoryFull> findByProductId(@Param("productid") UUID productid);

    @Select("""
                select * from inventoryfull where cast(warehouseid as varchar) = #{warehouseid,jdbcType=VARCHAR}
            """)
    List<InventoryFull> findByWarehouseId(@Param("warehouseid") UUID warehouseid);

    @Select("""
                    select * from inventoryfull where cast(productid as varchar) = #{productid,jdbcType=VARCHAR}
                    and cast(warehouseid as varchar) = #{warehouseid,jdbcType=VARCHAR}
            """)
    List<InventoryFull> findByProductIdAndWarehouseId(UUID productid, UUID warehouseid);

    @Select("""
                select * from inventoryfull limit #{limit} offset #{offset}
            """)
    List<InventoryFull> findPage(@Param("limit") int limit, @Param("offset") int offset);

    @Select("""
                select * from inventoryfull
            """)
    long count();

    @Select("""
                select * from inventoryfull where productOrWarehouse = #{productOrWarehouse,jdbcType=VARCHAR}
                limit #{limit} offset #{offset}
            """)
    List<InventoryFull> searchProductNameOrWarehouseName(@Param("limit") int limit,
                                                         @Param("offset") int offset,
                                                         @Param("productOrWarehouse") String productOrWarehouse);

    @Select("""
            select * from inventoryfull where productOrWarehouse = #{productOrWarehouse,jdbcType=VARCHAR}
            """)
    long countProductNameOrWarehouseName(@Param("productOrWarehouse") String productOrWarehouse);
}
