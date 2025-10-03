package com.base.admin.mapper;

import com.base.admin.entity.Resetpasswordtoken;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

@Mapper
public interface ResetpasswordtokenMapper {
    int deleteById(UUID userid);

    int insert(Resetpasswordtoken row);


    Resetpasswordtoken findById(UUID userid);

    Resetpasswordtoken findByToken(String token);


    int update(Resetpasswordtoken row);

    @Delete("delete from resetpasswordtoken")
    int deleteAll();

    @Delete("delete from resetpasswordtoken where token = #{token, jdbcType=VARCHAR}")
    void deleteByToken(@Param("token") String token);
}