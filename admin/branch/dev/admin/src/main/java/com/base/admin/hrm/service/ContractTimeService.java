/**
 * @mbg.generated generator on Fri Mar 29 15:29:24 ICT 2024
 */
package com.base.admin.hrm.service;

import com.base.admin.hrm.entity.ContractTime;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ContractTimeService {
    int deleteByPrimaryKey(Integer contracttimeid);

    int insert(ContractTime row);

    int insertSelective(ContractTime row);

    ContractTime selectByPrimaryKey(Integer contracttimeid);

    int updateByPrimaryKeySelective(ContractTime row);

    int updateByPrimaryKey(ContractTime row);

    ContractTime findById(Integer contracttimeid);

    Page<ContractTime> searchPaged(Pageable pageable);
}