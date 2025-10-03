package com.base.admin.hrm.service;

import com.base.admin.hrm.dto.DisplacementsDTO;
import com.base.admin.hrm.entity.Displacements;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface DisplacementsService {
    int deleteByPrimaryKey(UUID displacementid);

    int insert(Displacements record);

    int insertSelective(Displacements record);

    Displacements selectByPrimaryKey(UUID displacementid);

    int updateByPrimaryKeySelective(Displacements record);

    int updateByPrimaryKey(Displacements record);

    DisplacementsDTO findById(UUID displacementid);

    Page<DisplacementsDTO> searchPaged(DisplacementsDTO dto, Pageable pageable, boolean exact);

    boolean existsById(UUID displacementid);

    int udpate(Displacements displacements);
    int deleteByPrimaryKeys(List<UUID> listDisplacementids);
}
