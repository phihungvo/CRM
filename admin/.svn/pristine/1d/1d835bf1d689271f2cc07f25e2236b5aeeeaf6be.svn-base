package com.base.admin.hrm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import com.base.admin.hrm.entity.ContractType;

@Mapper
public interface ContractTypeMapper {
    int deleteByPrimaryKey(Integer contracttypeid);

    int insert(ContractType row);

    int insertSelective(ContractType row);

    ContractType selectByPrimaryKey(Integer contracttypeid);

    int updateByPrimaryKeySelective(ContractType row);

    int updateByPrimaryKey(ContractType row);

    long countPaged();

    List<ContractType> searchPaged(@Param("pageable") Pageable pageable);
}
