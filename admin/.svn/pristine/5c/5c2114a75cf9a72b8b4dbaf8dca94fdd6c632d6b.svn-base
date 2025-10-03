package com.base.admin.inventory.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.UUID;

@Mapper
public interface OrderDetailMapper {
    @Delete("""
                delete from orderdetail where cast(orderdetailid as varchar) = #{orderid,jdbcType=VARCHAR}
            """)
    void deleteById(@Param("orderid") UUID orderid);
}
