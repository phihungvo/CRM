/**
 * @mbg.generated generator on Fri Mar 29 15:29:24 ICT 2024
 */
package com.base.admin.hrm.service;

import com.base.admin.hrm.entity.ContractWorktype;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ContractWorktypeService {
    int deleteByPrimaryKey(Integer contractworktypeid);

    int insert(ContractWorktype row);

    int insertSelective(ContractWorktype row);

    ContractWorktype selectByPrimaryKey(Integer contractworktypeid);

    int updateByPrimaryKeySelective(ContractWorktype row);

    int updateByPrimaryKey(ContractWorktype row);

    ContractWorktype findById(Integer contractworktypeid);

    Page<ContractWorktype> searchPaged(Pageable pageable);
}