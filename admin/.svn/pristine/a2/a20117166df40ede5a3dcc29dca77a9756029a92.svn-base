package com.base.admin.hrm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import com.base.admin.hrm.entity.ContractTime;

@Mapper
public interface ContractTimeMapper {
    int deleteByPrimaryKey(Integer contracttimeid);

    int insert(ContractTime row);

    int insertSelective(ContractTime row);

    ContractTime selectByPrimaryKey(Integer contracttimeid);

    int updateByPrimaryKeySelective(ContractTime row);

    int updateByPrimaryKey(ContractTime row);

    long countPaged();

    List<ContractTime> searchPaged(@Param("pageable") Pageable pageable);
}
