package com.base.admin.inventory.mapper;

import com.base.admin.inventory.entity.Barcode;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Mapper
public interface BarcodeMapper {

    @Select("""
                select * from barcode where cast(barcodeid as varchar) = #{barcodeid, jdbcType=VARCHAR}
            """)
    Optional<Barcode> findById(@Param("id") UUID id);

    @Select("""
                select * from barcode
            """)
    List<Barcode> findAll();

    @Select("""
                select * from barcode limit #{limit} offset #{offset}
            """)
    List<Barcode> findPage(@Param("limit") int limit, @Param("offset") int offset);

    @Select("""
                select count(*) from barcode
            """)
    long findPageCount();

    @Select("""
                select exists(select * from barcode where barcodename = #{barcodename, jdbcType=VARCHAR})
            """)
    boolean existsByBarcodename(@Param("barcodename") String barcodename);

    @Select("""
                select exists(select * from barcode where cast(barcodeid as varchar) = #{barcodeid, jdbcType=VARCHAR})
            """)
    boolean existById(@Param("barcodeid") UUID barcodeid);

    @Delete("""
                    delete from barcode where cast(barcodeid as varchar) = #{barcodeid, jdbcType=VARCHAR}
            """)
    boolean deleteById(UUID barcodeid);

    @Insert("""
                    insert into (barcodeid,barcodename) barcode values (
                        #{id,jdbcType=OTHER,typeHandler=UUIDTypeHandler},
                        #{barcodename,jdbcType=VARCHAR}
                    )
            """)
    void save(Barcode barcode);
}
