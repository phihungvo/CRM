package com.base.admin.hrm.service;

import com.base.admin.hrm.dto.AccomplishmentsDTO;
import com.base.admin.hrm.entity.Accomplishments;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface AccomplishmentsService {
    int deleteByPrimaryKey(UUID accomplishmentid);

    int insert(Accomplishments record);

    int insertSelective(Accomplishments record);

    Accomplishments selectByPrimaryKey(UUID accomplishmentid);

    int updateByPrimaryKeySelective(Accomplishments record);

    int updateByPrimaryKey(Accomplishments record);

    AccomplishmentsDTO findById(UUID accomplishmentid);

    Page<AccomplishmentsDTO> searchPaged(AccomplishmentsDTO dto, Pageable pageable, boolean exact);

    int udpate(Accomplishments accomplishment);

    int deleteById(UUID accomplishmentid);
}