package com.base.admin.inventory.mapper;

import com.base.admin.inventory.entity.Delivery;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Mapper
public interface DeliveryMapper {
    @Select("""
                select * from delivery where cast(deliveryid as varchar) = #{id,jdbcType=VARCHAR}
            """)
    Optional<Delivery> findById(@Param("id") UUID id);

    @Select("""
                select * from delivery limit #{limit} offset #{offset}
            """)
    List<Delivery> findPage(@Param("limit") int limit, @Param("offset") int offset);

    @Select("""
                select count(*) from delivery 
            """)
    long count();

    @Select("""
                select * from delivery where deliverynumber = #{deliverynumber,jdbcType=VARCHAR}
            """)
    Optional<Delivery> findByDeliverynumber(@Param("deliverynumber") String deliverynumber);

    @Insert("""
                INSERT INTO adjustment (deliveryid, 
                                        salesdate, 
                                        customerid, deliverynumber, subtotal, discount,
                                        taxtypeid,ordertaxvalue,shippingfee,status,grandtotal,paid,paidduedate,
                                        paymentstatus,note)
                VALUES (#{id,jdbcType=OTHER,typeHandler=UUIDTypeHandler},
                        #{salesdate, jdbcType=DATE}, 
                        #{customerid, jdbcType=OTHER,typeHandler=UUIDTypeHandler}, 
                        #{deliverynumber,jdbcType=VARCHAR}, 
                        #{subtotal,jdbcType=DOUBLE}, 
                        #{discount,jdbcType=DOUBLE},
                        #{taxtypeid, jdbcType=OTHER,typeHandler=UUIDTypeHandler},
                        #{ordertaxvalue,jdbcType=DOUBLE},
                        #{shippingfee,jdbcType=DOUBLE},
                        #{status,jdbcType=DOUBLE},
                        #{grandtotal,jdbcType=DOUBLE},
                        #{paid,jdbcType=DOUBLE},
                        #{paidduedate, jdbcType=DATE}, 
                        #{paymentstatus,jdbcType=INTEGER},
                        #{note,jdbcType=VARCHAR}
                        )
            """)
    void save(Delivery delivery);

    @Select("""
                select exists(select * from delivery where cast(deliveryid as varchar) = #{deliveryid,jdbcType=VARCHAR})
            """)
    boolean existById(@Param("deliveryid") UUID deliveryid);

    @Delete("""
                delete from delivery where cast(deliveryid as varchar) = #{deliveryid,jdbcType=VARCHAR}
            """)
    boolean deleteById(@Param("deliveryid") UUID deliveryid);
}
