package com.base.admin.inventory.mapper;

import com.base.admin.inventory.entity.Order;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Mapper
public interface OrderMapper {

    @Select("""
                select * from order where cast(orderid as varchar) = #{id,jdbcType=VARCHAR}
            """)
    Optional<Order> findById(@Param("id") UUID id);

    @Select("""
                select * from order limit #{limit} offset #{offset}
            """)
    List<Order> findPage(@Param("limit") int limit, @Param("offset") int offset);

    @Select("""
                select * from order
            """)
    long count();

    @Select("""
                select * from order where ordernumber = #{ordernumber,jdbcType=VARCHAR}
            """)
    Optional<Order> findByOrdernumber(String ordernumber);

    @Select("""
                select * from order where cast(orderid as varchar) = #{orderid,jdbcType=VARCHAR}
            """)
    boolean existById(@Param("orderid") UUID orderid);

    @Delete("""
                delete from order where cast(orderid as varchar) = #{orderid,jdbcType=VARCHAR}
            """)
    boolean deleteOrder(@Param("orderid") UUID orderid);
}
