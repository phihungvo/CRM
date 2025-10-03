package com.base.admin.inventory.mapper;

import com.base.admin.inventory.entity.Provider;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Mapper
public interface ProviderMapper {
    @Select("""
                select provider.providerid as id, provider.*
                from provider
                where cast(providerid as varchar) = #{id,jdbcType=VARCHAR}
            """)
    Optional<Provider> findById(@Param("id") UUID id);

    @Select("""
                select provider.providerid as id, provider.*
                from provider
            """)
    List<Provider> findAll();

    @Select("""
                select provider.providerid as id, provider.*
                from provider 
                limit #{limit} offset #{offset}
            """)
    List<Provider> findPage(@Param("limit") int limit, @Param("offset") int offset);

    @Select("""
                select count(*)
                from brand
            """)
    long count();

    @Select("""
                select exists(select * from provider 
                where providername = #{providername,jdbcType=VARCHAR})
            """)
    boolean existsByProvidername(@Param("providername") String providername);

    @Insert("""
                insert into provider (providerid, providername, address, phone, email, taxnumber) 
                values (
                        #{id,jdbcType=OTHER,typeHandler=UUIDTypeHandler},
                        #{providername, jdbcType=VARCHAR},
                        #{address, jdbcType=VARCHAR},
                        #{phone, jdbcType=VARCHAR},
                        #{email, jdbcType=VARCHAR},
                        #{taxnumber, jdbcType=VARCHAR}
                )
            """)
    void save(Provider provider);
    @Update("""
                update provider
                set
                    providername = #{providername, jdbcType=VARCHAR},
                    address = #{address, jdbcType=VARCHAR},
                    phone = #{phone, jdbcType=VARCHAR},
                    email = #{email, jdbcType=VARCHAR},
                    taxnumber = #{taxnumber, jdbcType=VARCHAR}
                where cast(providerid as varchar) = #{id,jdbcType=VARCHAR}
            """)
    void update(Provider provider);

    @Select("""
                select exists(select * from provider where cast(providerid as varchar) = #{providerid, jdbcType=VARCHAR})
            """)
    boolean existById(@Param("providerid") UUID providerid);


    @Delete("""
                delete from provider 
                where cast(providerid as varchar) = #{providerid, jdbcType=VARCHAR}
            """)
    boolean deleteById(@Param("providerid") UUID providerid);
}
