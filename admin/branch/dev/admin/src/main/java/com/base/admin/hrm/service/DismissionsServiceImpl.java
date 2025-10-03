package com.base.admin.hrm.service;

import com.base.admin.hrm.dto.DismissionsDTO;
import com.base.admin.hrm.entity.Dismissions;
import com.base.admin.hrm.mapper.DismissionsMapper;
import com.base.admin.utils.ClassUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DismissionsServiceImpl implements DismissionsService {
    private final DismissionsMapper dismissionsMapper;

    public DismissionsServiceImpl(DismissionsMapper displacementsMapper) {
        this.dismissionsMapper = displacementsMapper;
    }

    @Override
    public int deleteByPrimaryKey(UUID dismissionid) {
        return dismissionsMapper.deleteByPrimaryKey(dismissionid);
    }

    @Override
    public int insert(Dismissions record) {
        record.setDismissionid(UUID.randomUUID());
        return dismissionsMapper.insert(record);
    }

    @Override
    public int insertSelective(Dismissions record) {
        record.setDismissionid(UUID.randomUUID());
        return dismissionsMapper.insertSelective(record);
    }

    @Override
    public Dismissions selectByPrimaryKey(UUID dismissionid) {
        return dismissionsMapper.selectByPrimaryKey(dismissionid);
    }

    @Override
    public int updateByPrimaryKeySelective(Dismissions record) {
        return dismissionsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Dismissions record) {
        return dismissionsMapper.updateByPrimaryKey(record);
    }

    @Override
    public DismissionsDTO findById(UUID dismissionid) {
        return dismissionsMapper.findById(dismissionid);
    }

    @Override
    public Page<DismissionsDTO> searchPaged(DismissionsDTO search, Pageable pageable, boolean exact) {
        long total = 0;
        List<DismissionsDTO> content = dismissionsMapper.searchPaged(search, pageable, exact);
        if (!content.isEmpty()) {
            total = dismissionsMapper.countPaged(search, exact);
        }
        return new PageImpl<>(content, pageable, total);
    }

    @Override
    public boolean existsById(UUID dismissionid) {
        return dismissionsMapper.existsById(dismissionid);
    }

    @Override
    public int udpate(Dismissions dismissions) {
        Dismissions dismission = dismissionsMapper.selectByPrimaryKey(dismissions.getDismissionid());
        if (dismission != null) {
            dismission = (Dismissions) ClassUtils.convertDTOToEntity(dismissions, dismission);
            return dismissionsMapper.updateByPrimaryKey(dismission);
        }
        return 0;
    }

    @Override
    public int deleteByPrimaryKeys(List<UUID> listDismissionids) {
        return dismissionsMapper.deleteByPrimaryKeys(listDismissionids);
    }
}
