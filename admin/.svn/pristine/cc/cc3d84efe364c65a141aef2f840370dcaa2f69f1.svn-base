package com.base.admin.hrm.mapper;

import com.base.admin.hrm.dto.UnitItemDTO;
import com.base.admin.hrm.entity.Units;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

@Mapper
public interface UnitsMapper {
    int deleteByPrimaryKey(UUID unitid);

    int insert(Units row);

    int insertSelective(Units row);

    Units selectByPrimaryKey(UUID unitid);

    int updateByPrimaryKeySelective(Units row);

    int updateByPrimaryKey(Units row);

    long countPaged(@Param("search") Units search, @Param("exact") boolean exact);

    List<Units> searchPaged(@Param("search") Units search, @Param("pageable") Pageable pageable, @Param("exact") boolean exact);

    List<UnitItemDTO> getUnitItems(@Param("organizationid") UUID organizationid);
}