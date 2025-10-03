package com.base.admin.inventory.mapper;

import com.base.admin.inventory.entity.DeliveryDetail;
import com.base.admin.inventory.entity.DeliveryDetailFull;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Mapper
public interface DeliveryDetailMapper {


    @Insert("""
            <script>
                        INSERT INTO deliverydetail (deliverydetailid, deliveryid, warehouseid, productid, deliveryquantity,
                        expecteddate, actualdate, productprice, discount, taxtypeid,
                        ordertaxvalue, subtotal,status,paymentstatus,note)
                        VALUES
                        <foreach collection="list" item="item" open="(" separator="),(" close=")">
                                              #{id,jdbcType=OTHER,typeHandler=UUIDTypeHandler},
                                              #{deliveryid,jdbcType=OTHER,typeHandler=UUIDTypeHandler}, 
                                              #{warehouseid,jdbcType=OTHER,typeHandler=UUIDTypeHandler},   
                                              #{productid,jdbcType=OTHER,typeHandler=UUIDTypeHandler},
                                              #{deliveryquantity,jdbcType=DOUBLE}, 
                                              #{expecteddate,jdbcType=DATE},
                                              #{actualdate,jdbcType=DATE}, 
                                              #{discount,jdbcType=DOUBLE},
                                              #{productprice,jdbcType=DOUBLE}, 
                                              #{taxtypeid,jdbcType=OTHER,typeHandler=UUIDTypeHandler},
                                              #{ordertaxvalue,jdbcType=DOUBLE},
                                              #{subtotal,jdbcType=DOUBLE}, 
                                              #{status,jdbcType=INTEGER},
                                              #{paymentstatus,jdbcType=INTEGER},
                                              #{note,jdbcType=VARCHAR}
                                          </foreach>    
                         </script> 
            """)
    void saveAll(@Param("list") List<DeliveryDetail> deliveryDetails);

    @Select("""
                    select * from deliverydetail where cast(deliveryid as varchar) = #{id,jdbcType=VARCHAR}
            """)
    List<DeliveryDetail> findByDeliveryId(@Param("id") UUID id);

    @Select("select * from deliverydetail where cast(deliverydetailid as varchar) = #{id,jdbcType=VARCHAR}")
    Optional<DeliveryDetail> findById(@Param("id") UUID id);

    @Select("""
                select exists(select * from deliverydetail where cast(deliverydetailid as varchar) = #{id,jdbcType=VARCHAR})
            """)
    boolean existById(@Param("id") UUID id);

    @Delete("""
                delete from deliverydetail where cast(deliverydetailid as varchar) = #{id,jdbcType=VARCHAR}
            """)
    boolean deleteById(@Param("id") UUID id);

    @Insert("""
                 INSERT INTO deliverydetail (deliverydetailid, deliveryid, warehouseid, productid, deliveryquantity,
                                expecteddate, actualdate, productprice, discount, taxtypeid,
                                ordertaxvalue, subtotal,status,paymentstatus,note)
                        VALUES (#{id,jdbcType=OTHER,typeHandler=UUIDTypeHandler},
                                                      #{deliveryid,jdbcType=OTHER,typeHandler=UUIDTypeHandler}, 
                                                      #{warehouseid,jdbcType=OTHER,typeHandler=UUIDTypeHandler},   
                                                      #{productid,jdbcType=OTHER,typeHandler=UUIDTypeHandler},
                                                      #{deliveryquantity,jdbcType=DOUBLE}, 
                                                      #{expecteddate,jdbcType=DATE},
                                                      #{actualdate,jdbcType=DATE}, 
                                                      #{discount,jdbcType=DOUBLE},
                                                      #{productprice,jdbcType=DOUBLE}, 
                                                      #{taxtypeid,jdbcType=OTHER,typeHandler=UUIDTypeHandler},
                                                      #{ordertaxvalue,jdbcType=DOUBLE},
                                                      #{subtotal,jdbcType=DOUBLE}, 
                                                      #{status,jdbcType=INTEGER},
                                                      #{paymentstatus,jdbcType=INTEGER},
                                                      #{note,jdbcType=VARCHAR})
            """)
    void save(DeliveryDetail deliveryDetail);

    @Select("""
                select * from deliverydetail where cast(deliveryid as varchar) = #{deliveryid,jdbcType=VARCHAR} 
                limit #{limit} offset #{offset}
            """)
    List<DeliveryDetailFull> findPageByDeliveryId(@Param("limit") int limit,
                                                  @Param("offset") int offset,
                                                  @Param("deliveryid") UUID deliveryid);

    @Select("""
                select * from deliverydetail where cast(deliveryid as varchar) = #{deliveryid,jdbcType=VARCHAR}  
            """)
    long count(@Param("deliveryid") UUID deliveryid);
}
