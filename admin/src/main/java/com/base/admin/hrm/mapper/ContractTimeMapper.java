package com.base.admin.hrm.mapper;

import com.base.admin.hrm.entity.ContractTime;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

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