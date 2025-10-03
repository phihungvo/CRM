package com.base.admin.hrm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import com.base.admin.hrm.entity.ContractStatus;

@Mapper
public interface ContractStatusMapper {
    int deleteByPrimaryKey(Integer contractstatusid);

    int insert(ContractStatus row);

    int insertSelective(ContractStatus row);

    ContractStatus selectByPrimaryKey(Integer contractstatusid);

    int updateByPrimaryKeySelective(ContractStatus row);

    int updateByPrimaryKey(ContractStatus row);

    long countPaged();

    List<ContractStatus> searchPaged(@Param("pageable") Pageable pageable);
}
