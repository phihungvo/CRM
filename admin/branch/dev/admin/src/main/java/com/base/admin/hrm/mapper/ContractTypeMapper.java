package com.base.admin.hrm.mapper;

import com.base.admin.hrm.entity.ContractType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

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