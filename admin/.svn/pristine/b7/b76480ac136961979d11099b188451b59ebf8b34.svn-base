/**
 * @mbg.generated generator on Fri Mar 29 15:29:24 ICT 2024
 */
package com.base.admin.hrm.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.base.admin.hrm.entity.ContractWorktype;
import com.base.admin.hrm.mapper.ContractWorktypeMapper;

@Service
public class ContractWorktypeServiceImpl implements ContractWorktypeService {
    private final ContractWorktypeMapper contractWorktypeMapper;

    public ContractWorktypeServiceImpl(ContractWorktypeMapper contractWorktypeMapper) {
        this.contractWorktypeMapper = contractWorktypeMapper;
    }

    @Override
    public int deleteByPrimaryKey(Integer contractworktypeid) {
        return contractWorktypeMapper.deleteByPrimaryKey(contractworktypeid);
    }

    @Override
    public int insert(ContractWorktype row) {
        return contractWorktypeMapper.insert(row);
    }

    @Override
    public int insertSelective(ContractWorktype row) {
        return contractWorktypeMapper.insertSelective(row);
    }

    @Override
    public ContractWorktype selectByPrimaryKey(Integer contractworktypeid) {
        return contractWorktypeMapper.selectByPrimaryKey(contractworktypeid);
    }

    @Override
    public int updateByPrimaryKeySelective(ContractWorktype row) {
        return contractWorktypeMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int updateByPrimaryKey(ContractWorktype row) {
        return contractWorktypeMapper.updateByPrimaryKey(row);
    }

    @Override
    public ContractWorktype findById(Integer contractworktypeid) {
        return contractWorktypeMapper.selectByPrimaryKey(contractworktypeid);
    }

    @Override
    public Page<ContractWorktype> searchPaged(Pageable pageable) {
        long total = 0;
        List<ContractWorktype> content = contractWorktypeMapper.searchPaged(pageable);
        if (!content.isEmpty()) {
            total = contractWorktypeMapper.countPaged();
        }
        return new PageImpl<>(content, pageable, total);
    }
}
