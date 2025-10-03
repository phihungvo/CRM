package com.base.admin.hrm.service;

import com.base.admin.hrm.dto.DesignationsDTO;
import com.base.admin.hrm.entity.Designations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface DesignationsService {
    int deleteByPrimaryKey(UUID designateid);

    int insert(Designations record);

    int insertSelective(Designations record);

    Designations selectByPrimaryKey(UUID designateid);

    int updateByPrimaryKeySelective(Designations record);

    int updateByPrimaryKey(Designations record);

    DesignationsDTO findById(UUID designateid);

    Page<DesignationsDTO> searchPaged(DesignationsDTO dto, Pageable pageable, boolean exact);

    boolean existsById(UUID designateid);

    int udpate(Designations designations);
    int deleteByPrimaryKeys(List<UUID> listDesignateids);
}
