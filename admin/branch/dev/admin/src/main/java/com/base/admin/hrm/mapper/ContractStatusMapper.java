package com.base.admin.hrm.mapper;

import com.base.admin.hrm.entity.ContractStatus;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

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