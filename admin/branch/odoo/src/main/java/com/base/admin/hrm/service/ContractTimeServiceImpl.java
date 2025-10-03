/**
 * @mbg.generated generator on Fri Mar 29 15:29:24 ICT 2024
 */
package com.base.admin.hrm.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.base.admin.hrm.entity.ContractTime;
import com.base.admin.hrm.mapper.ContractTimeMapper;

@Service
public class ContractTimeServiceImpl implements ContractTimeService {
    private final ContractTimeMapper contractTimeMapper;

    public ContractTimeServiceImpl(ContractTimeMapper contractTimeMapper) {
        this.contractTimeMapper = contractTimeMapper;
    }

    @Override
    public int deleteByPrimaryKey(Integer contracttimeid) {
        return contractTimeMapper.deleteByPrimaryKey(contracttimeid);
    }

    @Override
    public int insert(ContractTime row) {
        return contractTimeMapper.insert(row);
    }

    @Override
    public int insertSelective(ContractTime row) {
        return contractTimeMapper.insertSelective(row);
    }

    @Override
    public ContractTime selectByPrimaryKey(Integer contracttimeid) {
        return contractTimeMapper.selectByPrimaryKey(contracttimeid);
    }

    @Override
    public int updateByPrimaryKeySelective(ContractTime row) {
        return contractTimeMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int updateByPrimaryKey(ContractTime row) {
        return contractTimeMapper.updateByPrimaryKey(row);
    }

    @Override
    public ContractTime findById(Integer contracttimeid) {
        return contractTimeMapper.selectByPrimaryKey(contracttimeid);
    }

    @Override
    public Page<ContractTime> searchPaged(Pageable pageable) {
        long total = 0;
        List<ContractTime> content = contractTimeMapper.searchPaged(pageable);
        if (!content.isEmpty()) {
            total = contractTimeMapper.countPaged();
        }
        return new PageImpl<>(content, pageable, total);
    }
}
