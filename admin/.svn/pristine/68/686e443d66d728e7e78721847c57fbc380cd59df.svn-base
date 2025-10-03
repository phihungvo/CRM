package com.base.admin.hrm.service;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.base.admin.hrm.dto.DesignationsDTO;
import com.base.admin.hrm.entity.Designations;
import com.base.admin.hrm.mapper.DesignationsMapper;
import com.base.admin.utils.ClassUtils;

@Service
public class DesignationsServiceImpl implements DesignationsService {
    private final DesignationsMapper designationsMapper;

    public DesignationsServiceImpl(DesignationsMapper designationsMapper) {
        this.designationsMapper = designationsMapper;
    }

    @Override
    public int deleteByPrimaryKey(UUID designateid) {
        return designationsMapper.deleteByPrimaryKey(designateid);
    }

    @Override
    public int insert(Designations record) {
        record.setDesignateid(UUID.randomUUID());
        return designationsMapper.insert(record);
    }

    @Override
    public int insertSelective(Designations record) {
        record.setDesignateid(UUID.randomUUID());
        return designationsMapper.insertSelective(record);
    }

    @Override
    public Designations selectByPrimaryKey(UUID designateid) {
        return designationsMapper.selectByPrimaryKey(designateid);
    }

    @Override
    public int updateByPrimaryKeySelective(Designations record) {
        return designationsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Designations record) {
        return designationsMapper.updateByPrimaryKey(record);
    }

    @Override
    public DesignationsDTO findById(UUID designateid) {
        return designationsMapper.findById(designateid);
    }

    @Override
    public Page<DesignationsDTO> searchPaged(DesignationsDTO search, Pageable pageable, boolean exact) {
        long total = 0;
        List<DesignationsDTO> content = designationsMapper.searchPaged(search, pageable, exact);
        if (!content.isEmpty()) {
            total = designationsMapper.countPaged(search, exact);
        }
        return new PageImpl<>(content, pageable, total);
    }

    @Override
    public boolean existsById(UUID designateid) {
        return designationsMapper.existsById(designateid);
    }

    @Override
    public int udpate(Designations designations) {
        Designations designation = designationsMapper.selectByPrimaryKey(designations.getDesignateid());
        if (designation != null) {
            designation = (Designations) ClassUtils.convertDTOToEntity(designations, designation);
            return designationsMapper.updateByPrimaryKey(designation);
        }
        return 0;
    }

    @Override
    public int deleteByPrimaryKeys(List<UUID> listDesignateids) {
        return designationsMapper.deleteByPrimaryKeys(listDesignateids);
    }
}
