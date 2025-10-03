package com.base.admin.inventory.mapper;

import com.base.admin.inventory.entity.Brand;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Mapper
public interface BrandMapper {
    @Select("SELECT * FROM brand WHERE CAST(brandid AS VARCHAR) = #{id,jdbcType=VARCHAR}")
    Optional<Brand> findById(@Param("id") UUID id);

    @Select("""
                select * from brand
            """)
    List<Brand> findAll();

    @Select("""
                select * from brand limit #{limit} offset #{offset}
            """)
    List<Brand> findPage(@Param("limit") int limit, @Param("offset") int offset);

    @Select("""
                select count(*) from brand
            """)
    long count();

    @Select("""
                select exists(select * from brand where brandname = #{brandname,jdbcType=VARCHAR})
            """)
    boolean existsByBrandname(@Param("brandname") String brandname);


    @Insert("""
            insert into brand (brandid, brandname, branddescription) 
            values (
                    #{id,jdbcType=OTHER,typeHandler=UUIDTypeHandler},
                    #{brandname, jdbcType=VARCHAR},
                    #{branddescription, jdbcType=VARCHAR}
            )
            """)
    void save(Brand brand);

    @Select("""
                select exists(select * from brand where cast(brandid as varchar) = #{brandid, jdbcType=VARCHAR})
            """)
    boolean existById(@Param("brandid") UUID brandid);


    @Delete("""
            delete from brand 
            where cast(brandid as varchar) = #{brandid, jdbcType=VARCHAR}
            """)
    boolean deleteById(@Param("brandid") UUID brandid);
}
