package com.base.admin.inventory.mapper;

import com.base.admin.inventory.entity.Customer;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Mapper
public interface CustomerMapper {

    @Select("""
                select * from customer where cast(customerid as varchar) = #{id,jdbcType=VARCHAR}
            """)
    Optional<Customer> findById(@Param("id") UUID id);

    @Select("""
                select * from customer limit = #{limit} offset = #{offset}
            """)
    List<Customer> findPage(@Param("limit") int limit, @Param("offset") int offset);

    @Select("""
                select count(*) from customer 
            """)
    long count();

    @Select("""
                select exists(select * from customer where customername = #{customername,jdbcType=VARCHAR})
            """)
    boolean existByName(@Param("customername") String customername);

    @Insert("""
                    insert into customer (customerid,customercode,customername,address,
                                          phone,email,taxnumber) values (
                        #{id,jdbcType=OTHER,typeHandler=UUIDTypeHandler},
                        #{customercode,jdbcType=VARCHAR},
                        #{customername,jdbcType=VARCHAR}, 
                        #{address,jdbcType=VARCHAR},
                        #{phone,jdbcType=VARCHAR}, 
                        #{email,jdbcType=VARCHAR},
                        #{taxnumber,jdbcType=VARCHAR}                                         
                    )
            """)
    void save(Customer customer);

    @Select("""
                select exists (select * from customer where cast(customerid as varchar) = #{id,jdbcType=VARCHAR} )
            """)
    boolean existById(@Param("customerid") UUID customerid);

    @Delete("""
                delete from customer where cast(customerid as varchar) = #{id,jdbcType=VARCHAR} )
            """)
    boolean deleteById(@Param("customerid") UUID customerid);
}
