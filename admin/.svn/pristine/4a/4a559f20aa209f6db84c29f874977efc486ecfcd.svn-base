package com.base.admin.hrm.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.base.admin.hrm.dto.TerminationReasonDTO;
import com.base.admin.hrm.entity.TerminationReason;

public interface TerminationReasonService {
    int deleteByPrimaryKey(Integer terminationreasonid);

    int insert(TerminationReason record);

    int insertSelective(TerminationReason record);

    TerminationReason selectByPrimaryKey(Integer terminationreasonid);

    int updateByPrimaryKeySelective(TerminationReason record);

    int updateByPrimaryKey(TerminationReason record);

    TerminationReasonDTO findById(Integer terminationreasonid);

    Page<TerminationReasonDTO> searchPaged(Pageable pageable);
}
