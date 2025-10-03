/**
 * @mbg.generated generator on Fri Mar 29 15:29:24 ICT 2024
 */
package com.base.admin.hrm.service;

import com.base.admin.hrm.entity.ContractType;
import com.base.admin.hrm.mapper.ContractTypeMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractTypeServiceImpl implements ContractTypeService {
    private final ContractTypeMapper contractTypeMapper;

    public ContractTypeServiceImpl(ContractTypeMapper contractTypeMapper) {
        this.contractTypeMapper = contractTypeMapper;
    }

    @Override
    public int deleteByPrimaryKey(Integer contracttypeid) {
        return contractTypeMapper.deleteByPrimaryKey(contracttypeid);
    }

    @Override
    public int insert(ContractType row) {
        return contractTypeMapper.insert(row);
    }

    @Override
    public int insertSelective(ContractType row) {
        return contractTypeMapper.insertSelective(row);
    }

    @Override
    public ContractType selectByPrimaryKey(Integer contracttypeid) {
        return contractTypeMapper.selectByPrimaryKey(contracttypeid);
    }

    @Override
    public int updateByPrimaryKeySelective(ContractType row) {
        return contractTypeMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int updateByPrimaryKey(ContractType row) {
        return contractTypeMapper.updateByPrimaryKey(row);
    }

    @Override
    public ContractType findById(Integer contracttypeid) {
        return contractTypeMapper.selectByPrimaryKey(contracttypeid);
    }

    @Override
    public Page<ContractType> searchPaged(Pageable pageable) {
        long total = 0;
        List<ContractType> content = contractTypeMapper.searchPaged(pageable);
        if (!content.isEmpty()) {
            total = contractTypeMapper.countPaged();
        }
        return new PageImpl<>(content, pageable, total);
    }
}