package com.base.admin.hrm.mapper;

import com.base.admin.hrm.dto.AccomplishmentObjectdetailDTO;
import com.base.admin.hrm.entity.AccomplishmentObjectdetail;
import com.base.admin.hrm.entity.KeyAndPosition;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Mapper
public interface AccomplishmentObjectdetailMapper {
    int deleteByPrimaryKey(Integer accomplishmentobjectdetailid);

    int insert(AccomplishmentObjectdetail record);

    int insertSelective(AccomplishmentObjectdetail record);

    AccomplishmentObjectdetail selectByPrimaryKey(Integer accomplishmentobjectdetailid);

    int updateByPrimaryKeySelective(AccomplishmentObjectdetail record);

    int updateByPrimaryKey(AccomplishmentObjectdetail record);

    AccomplishmentObjectdetailDTO findById(@Param("accomplishmentobjectdetailid") Integer accomplishmentobjectdetailid);

    long countPaged();

    List<AccomplishmentObjectdetailDTO> searchPaged(@Param("pageable") Pageable pageable);

    KeyAndPosition generateKeyAndPosition();

    @Select("SELECT EXISTS(SELECT 1 FROM accomplishment_objectdetail WHERE accomplishmentobjectdetailname=#{name,jdbcType=VARCHAR})")
    boolean existByName(@Param("name") String name);
}