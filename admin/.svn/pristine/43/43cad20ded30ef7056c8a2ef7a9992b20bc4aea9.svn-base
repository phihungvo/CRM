package com.base.admin.hrm.service;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.base.admin.hrm.dto.TerminationsDTO;
import com.base.admin.hrm.entity.Terminations;

public interface TerminationsService {
    int deleteByPrimaryKey(UUID terminationid);

    int insert(Terminations record);

    int insertSelective(Terminations record);

    Terminations selectByPrimaryKey(UUID terminationid);

    int updateByPrimaryKeySelective(Terminations record);

    int updateByPrimaryKey(Terminations record);

    TerminationsDTO findById(UUID terminationid);

    Page<TerminationsDTO> searchPaged(TerminationsDTO dto, Pageable pageable, boolean exact);

    boolean existsById(UUID terminationid);

    int udpate(Terminations terminations);

    int deleteByPrimaryKeys(List<UUID> listTerminationids);
}
