package com.base.admin.hrm.service;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.base.admin.hrm.dto.DismissionsDTO;
import com.base.admin.hrm.entity.Dismissions;

public interface DismissionsService {
    int deleteByPrimaryKey(UUID dismissionid);

    int insert(Dismissions record);

    int insertSelective(Dismissions record);

    Dismissions selectByPrimaryKey(UUID dismissionid);

    int updateByPrimaryKeySelective(Dismissions record);

    int updateByPrimaryKey(Dismissions record);

    DismissionsDTO findById(UUID dismissionid);

    Page<DismissionsDTO> searchPaged(DismissionsDTO dto, Pageable pageable, boolean exact);

    boolean existsById(UUID dismissionid);

    int udpate(Dismissions dismissions);

    int deleteByPrimaryKeys(List<UUID> listDismissionids);
}
