package com.base.admin.hrm.service;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.base.admin.hrm.dto.DisplacementsDTO;
import com.base.admin.hrm.entity.Displacements;
import com.base.admin.hrm.mapper.DisplacementsMapper;
import com.base.admin.utils.ClassUtils;

@Service
public class DisplacementsServiceImpl implements DisplacementsService {
    private final DisplacementsMapper displacementsMapper;

    public DisplacementsServiceImpl(DisplacementsMapper displacementsMapper) {
        this.displacementsMapper = displacementsMapper;
    }

    @Override
    public int deleteByPrimaryKey(UUID displacementid) {
        return displacementsMapper.deleteByPrimaryKey(displacementid);
    }

    @Override
    public int insert(Displacements record) {
        record.setDisplacementid(UUID.randomUUID());
        return displacementsMapper.insert(record);
    }

    @Override
    public int insertSelective(Displacements record) {
        record.setDisplacementid(UUID.randomUUID());
        return displacementsMapper.insertSelective(record);
    }

    @Override
    public Displacements selectByPrimaryKey(UUID displacementid) {
        return displacementsMapper.selectByPrimaryKey(displacementid);
    }

    @Override
    public int updateByPrimaryKeySelective(Displacements record) {
        return displacementsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Displacements record) {
        return displacementsMapper.updateByPrimaryKey(record);
    }

    @Override
    public DisplacementsDTO findById(UUID displacementid) {
        return displacementsMapper.findById(displacementid);
    }

    @Override
    public Page<DisplacementsDTO> searchPaged(DisplacementsDTO search, Pageable pageable, boolean exact) {
        long total = 0;
        List<DisplacementsDTO> content = displacementsMapper.searchPaged(search, pageable, exact);
        if (!content.isEmpty()) {
            total = displacementsMapper.countPaged(search, exact);
        }
        return new PageImpl<>(content, pageable, total);
    }

    @Override
    public boolean existsById(UUID displacementid) {
        return displacementsMapper.existsById(displacementid);
    }

    @Override
    public int udpate(Displacements displacements) {
        Displacements displacement = displacementsMapper.selectByPrimaryKey(displacements.getDisplacementid());
        if (displacement != null) {
            displacement = (Displacements) ClassUtils.convertDTOToEntity(displacements, displacement);
            return displacementsMapper.updateByPrimaryKey(displacement);
        }
        return 0;
    }

    @Override
    public int deleteByPrimaryKeys(List<UUID> listDisplacementids) {
        return displacementsMapper.deleteByPrimaryKeys(listDisplacementids);
    }
}
