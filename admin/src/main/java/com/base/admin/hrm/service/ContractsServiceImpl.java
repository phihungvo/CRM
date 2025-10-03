/**
 * @mbg.generated generator on Fri Mar 29 15:29:24 ICT 2024
 */
package com.base.admin.hrm.service;

import com.base.admin.hrm.dto.ContractsDTO;
import com.base.admin.hrm.entity.Contracts;
import com.base.admin.hrm.mapper.ContractsMapper;
import com.base.admin.utils.ClassUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ContractsServiceImpl implements ContractsService {
    private final ContractsMapper contractsMapper;

    public ContractsServiceImpl(ContractsMapper contractsMapper) {
        this.contractsMapper = contractsMapper;
    }

    @Override
    public int deleteByPrimaryKey(UUID contractid) {
        return contractsMapper.deleteByPrimaryKey(contractid);
    }

    @Override
    public int insert(Contracts row) {
        return contractsMapper.insert(row);
    }

    @Override
    public int insertSelective(Contracts row) {
        return contractsMapper.insertSelective(row);
    }

    @Override
    public Contracts selectByPrimaryKey(UUID contractid) {
        return contractsMapper.selectByPrimaryKey(contractid);
    }

    @Override
    public int updateByPrimaryKeySelective(Contracts row) {
        return contractsMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int updateByPrimaryKey(Contracts row) {
        return contractsMapper.updateByPrimaryKey(row);
    }

    @Override
    public Page<ContractsDTO> searchPaged(ContractsDTO search, Pageable pageable, boolean exact) {
        long total = 0;
        List<ContractsDTO> content = contractsMapper.searchPaged(search, pageable, exact);
        if (!content.isEmpty()) {
            total = contractsMapper.countPaged(search, exact);
        }
        return new PageImpl<>(content, pageable, total);
    }

    @Override
    public int addContractsDTO(ContractsDTO contractsDTO) {
        Contracts contract = contractsDTO.newEntity();
        return contractsMapper.insert(contract);
    }

    @Override
    public int udpate(ContractsDTO contractsDTO) {
        Contracts contract = contractsMapper.selectByPrimaryKey(contractsDTO.getContractid());
        if (contract != null) {
            contract = (Contracts) ClassUtils.convertDTOToEntity(contractsDTO, contract);
            return contractsMapper.updateByPrimaryKey(contract);
        }
        return 0;
    }

    @Override
    public boolean existsById(UUID contractid) {
        return contractsMapper.existsById(contractid);
    }

    @Override
    public int deleteById(UUID contractid) {
        return contractsMapper.deleteByPrimaryKey(contractid);
    }

    @Override
    public ContractsDTO findById(UUID contractid) {
        return contractsMapper.findById(contractid);
    }

    @Override
    public int deleteByIds(List<UUID> listContractid) {
        return contractsMapper.deleteByPrimaryKeys(listContractid);
    }
}
