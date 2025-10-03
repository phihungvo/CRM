package com.base.admin.hrm.service;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.base.admin.hrm.dto.TerminationsDTO;
import com.base.admin.hrm.entity.Terminations;
import com.base.admin.hrm.mapper.TerminationsMapper;
import com.base.admin.utils.ClassUtils;

@Service
public class TerminationsServiceImpl implements TerminationsService {
    private final TerminationsMapper terminationsMapper;

    public TerminationsServiceImpl(TerminationsMapper terminationsMapper) {
        this.terminationsMapper = terminationsMapper;
    }

    @Override
    public int deleteByPrimaryKey(UUID terminationid) {
        return terminationsMapper.deleteByPrimaryKey(terminationid);
    }

    @Override
    public int insert(Terminations record) {
        record.setTerminationid(UUID.randomUUID());
        return terminationsMapper.insert(record);
    }

    @Override
    public int insertSelective(Terminations record) {
        record.setTerminationid(UUID.randomUUID());
        return terminationsMapper.insertSelective(record);
    }

    @Override
    public Terminations selectByPrimaryKey(UUID terminationid) {
        return terminationsMapper.selectByPrimaryKey(terminationid);
    }

    @Override
    public int updateByPrimaryKeySelective(Terminations record) {
        return terminationsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Terminations record) {
        return terminationsMapper.updateByPrimaryKey(record);
    }

    @Override
    public TerminationsDTO findById(UUID terminationid) {
        return terminationsMapper.findById(terminationid);
    }

    @Override
    public Page<TerminationsDTO> searchPaged(TerminationsDTO search, Pageable pageable, boolean exact) {
        long total = 0;
        List<TerminationsDTO> content = terminationsMapper.searchPaged(search, pageable, exact);
        if (!content.isEmpty()) {
            total = terminationsMapper.countPaged(search, exact);
        }
        return new PageImpl<>(content, pageable, total);
    }

    @Override
    public boolean existsById(UUID terminationid) {
        return terminationsMapper.existsById(terminationid);
    }

    @Override
    public int udpate(Terminations terminations) {
        Terminations termination = terminationsMapper.selectByPrimaryKey(terminations.getTerminationid());
        if (termination != null) {
            termination = (Terminations) ClassUtils.convertDTOToEntity(terminations, termination);
            return terminationsMapper.updateByPrimaryKey(termination);
        }
        return 0;
    }

    @Override
    public int deleteByPrimaryKeys(List<UUID> listTerminationids) {
        return terminationsMapper.deleteByPrimaryKeys(listTerminationids);
    }
}
