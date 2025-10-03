package com.base.admin.mapper;

import java.util.List;
import java.util.UUID;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import com.base.admin.entity.Emails;

@Mapper
public interface EmailsMapper {
    Emails findById(Long id);

    int insert(Emails row);

    int update(Emails row);

    int deleteById(Long id);

    @Delete("delete from emails")
    int deleteAll();

    List<Emails> findAllByStatus(@Param("status") int status, @Param("pageable") Pageable pageable);

    @Delete("delete from emails where userid = #{userid, jdbcType=OTHER, typeHandler=UUIDTypeHandler}")
    void deleteByUserId(@Param("userid") UUID userid);
}
