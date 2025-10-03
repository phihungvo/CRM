package com.base.admin.hrm.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.base.admin.hrm.dto.TerminationReasonDTO;
import com.base.admin.hrm.entity.TerminationReason;
import com.base.admin.hrm.mapper.TerminationReasonMapper;

@Service
public class TerminationReasonServiceImpl implements TerminationReasonService {
    private final TerminationReasonMapper terminationReasonMapper;

    public TerminationReasonServiceImpl(TerminationReasonMapper terminationReasonMapper) {
        this.terminationReasonMapper = terminationReasonMapper;
    }

    @Override
    public int deleteByPrimaryKey(Integer terminationreasonid) {
        return terminationReasonMapper.deleteByPrimaryKey(terminationreasonid);
    }

    @Override
    public int insert(TerminationReason record) {
        return terminationReasonMapper.insert(record);
    }

    @Override
    public int insertSelective(TerminationReason record) {
        return terminationReasonMapper.insertSelective(record);
    }

    @Override
    public TerminationReason selectByPrimaryKey(Integer terminationreasonid) {
        return terminationReasonMapper.selectByPrimaryKey(terminationreasonid);
    }

    @Override
    public int updateByPrimaryKeySelective(TerminationReason record) {
        return terminationReasonMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TerminationReason record) {
        return terminationReasonMapper.updateByPrimaryKey(record);
    }

    @Override
    public TerminationReasonDTO findById(Integer terminationreasonid) {
        return terminationReasonMapper.findById(terminationreasonid);
    }

    @Override
    public Page<TerminationReasonDTO> searchPaged(Pageable pageable) {
        long total = 0;
        List<TerminationReasonDTO> content = terminationReasonMapper.searchPaged(pageable);
        if (!content.isEmpty()) {
            total = terminationReasonMapper.countPaged();
        }
        return new PageImpl<>(content, pageable, total);
    }
}
