package com.base.admin.hrm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import com.base.admin.hrm.entity.ContractWorktype;

@Mapper
public interface ContractWorktypeMapper {
    int deleteByPrimaryKey(Integer contractworktypeid);

    int insert(ContractWorktype row);

    int insertSelective(ContractWorktype row);

    ContractWorktype selectByPrimaryKey(Integer contractworktypeid);

    int updateByPrimaryKeySelective(ContractWorktype row);

    int updateByPrimaryKey(ContractWorktype row);

    long countPaged();

    List<ContractWorktype> searchPaged(@Param("pageable") Pageable pageable);
}
