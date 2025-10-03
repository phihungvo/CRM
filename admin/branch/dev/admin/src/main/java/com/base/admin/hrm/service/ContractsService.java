/**
 * @mbg.generated generator on Fri Mar 29 15:29:24 ICT 2024
 */
package com.base.admin.hrm.service;

import com.base.admin.hrm.dto.ContractsDTO;
import com.base.admin.hrm.entity.Contracts;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface ContractsService {
    int deleteByPrimaryKey(UUID contractid);

    int insert(Contracts row);

    int insertSelective(Contracts row);

    Contracts selectByPrimaryKey(UUID contractid);

    int updateByPrimaryKeySelective(Contracts row);

    int updateByPrimaryKey(Contracts row);

    Page<ContractsDTO> searchPaged(ContractsDTO search, Pageable pageable, boolean exact);

    int addContractsDTO(ContractsDTO contractsDTO);

    int udpate(ContractsDTO contractsDTO);

    boolean existsById(UUID contractid);

    int deleteById(UUID contractid);

    ContractsDTO findById(UUID contractid);

    int deleteByIds(List<UUID> listContractids);
}
