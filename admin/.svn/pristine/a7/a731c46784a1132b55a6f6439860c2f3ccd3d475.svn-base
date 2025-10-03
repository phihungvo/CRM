package com.base.admin.hrm.mapper;

import java.util.List;
import java.util.UUID;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.domain.Pageable;

import com.base.admin.hrm.dto.ContractsDTO;
import com.base.admin.hrm.entity.Contracts;

@Mapper
public interface ContractsMapper {
    int deleteByPrimaryKey(UUID contractid);

    int insert(Contracts row);

    int insertSelective(Contracts row);

    Contracts selectByPrimaryKey(UUID contractid);

    int updateByPrimaryKeySelective(Contracts row);

    int updateByPrimaryKey(Contracts row);

    long countPaged(@Param("search") ContractsDTO search, @Param("exact") boolean exact);

    List<ContractsDTO> searchPaged(
            @Param("search") ContractsDTO search, @Param("pageable") Pageable pageable, @Param("exact") boolean exact);

    @Select(
            "SELECT EXISTS(SELECT 1 FROM contracts WHERE contractid=#{contractid,jdbcType=OTHER,typeHandler=UUIDTypeHandler})")
    boolean existsById(@Param("contractid") UUID contractid);

    ContractsDTO findById(@Param("contractid") UUID contractid);

    int deleteByPrimaryKeys(List<UUID> ListContractid);
}
