package com.base.admin.inventory.mapper;

import com.base.admin.inventory.entity.Inventory;
import com.base.admin.inventory.entity.InventoryFull;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.UUID;

@Mapper
public interface InventoryMapper {
    @Select("""
                SELECT inventory.inventoryid as id, inventory.* FROM inventory WHERE CAST(warehouseid AS VARCHAR) = #{warehouseid,jdbcType=VARCHAR}
                AND CAST(productid AS VARCHAR) = #{productid,jdbcType=VARCHAR}
            """)
    Inventory findByWarehouseidAndProductid(@Param("warehouseid") UUID warehouseid, @Param("productid") UUID productid);

    @Insert("""
                INSERT INTO inventory (inventoryid,
                                       minimumstocklevel,
                                       quantityavailable,
                                       maximumstocklevel,
                                       reorderpoint,
                                       warehouseid,
                                       productid)
                VALUES (#{id,jdbcType=OTHER,typeHandler=UUIDTypeHandler},
                        #{minimumstocklevel,jdbcType=DOUBLE},
                        #{quantityavailable,jdbcType=DOUBLE},
                        #{maximumstocklevel,jdbcType=DOUBLE},
                        #{reorderpoint,jdbcType=DOUBLE},
                        #{warehouseid,jdbcType=OTHER,typeHandler=UUIDTypeHandler},
                        #{productid,jdbcType=OTHER,typeHandler=UUIDTypeHandler})
            """)
    void save(Inventory inventory);

    @Update("""
                UPDATE inventory SET quantityavailable = #{quantityavailable,jdbcType=DOUBLE}
                WHERE inventoryid = #{id,jdbcType=OTHER,typeHandler=UUIDTypeHandler}
            """)
    void update(Inventory inventory);

    @Select("""
                select exists(select * from inventory where cast(inventoryid as varchar) = #{inventoryid,jdbcType=VARCHAR})
            """)
    boolean existById(@Param("inventoryid") UUID inventoryid);

    @Delete("""
                delete from inventory where cast(inventoryid as varchar) = #{inventoryid,jdbcType=VARCHAR}
            """)
    boolean deleteById(@Param("inventoryid") UUID inventoryid);
}
