/**
 * @mbg.generated generator on Fri Mar 29 15:29:24 ICT 2024
 */
package com.base.admin.hrm.service;

import com.base.admin.hrm.entity.ContractStatus;
import com.base.admin.hrm.mapper.ContractStatusMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractStatusServiceImpl implements ContractStatusService {
    private final ContractStatusMapper contractStatusMapper;

    public ContractStatusServiceImpl(ContractStatusMapper contractStatusMapper) {
        this.contractStatusMapper = contractStatusMapper;
    }

    @Override
    public int deleteByPrimaryKey(Integer contractstatusid) {
        return contractStatusMapper.deleteByPrimaryKey(contractstatusid);
    }

    @Override
    public int insert(ContractStatus row) {
        return contractStatusMapper.insert(row);
    }

    @Override
    public int insertSelective(ContractStatus row) {
        return contractStatusMapper.insertSelective(row);
    }

    @Override
    public ContractStatus selectByPrimaryKey(Integer contractstatusid) {
        return contractStatusMapper.selectByPrimaryKey(contractstatusid);
    }

    @Override
    public int updateByPrimaryKeySelective(ContractStatus row) {
        return contractStatusMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int updateByPrimaryKey(ContractStatus row) {
        return contractStatusMapper.updateByPrimaryKey(row);
    }

    @Override
    public ContractStatus findById(Integer contractstatusid) {
        return contractStatusMapper.selectByPrimaryKey(contractstatusid);
    }

    @Override
    public Page<ContractStatus> searchPaged(Pageable pageable) {
        long total = 0;
        List<ContractStatus> content = contractStatusMapper.searchPaged(pageable);
        if (!content.isEmpty()) {
            total = contractStatusMapper.countPaged();
        }
        return new PageImpl<>(content, pageable, total);
    }
}