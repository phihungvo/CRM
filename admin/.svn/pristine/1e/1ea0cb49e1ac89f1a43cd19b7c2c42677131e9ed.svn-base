package com.base.admin.hrm.service;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.base.admin.hrm.dto.AccomplishmentsDTO;
import com.base.admin.hrm.entity.Accomplishments;
import com.base.admin.hrm.mapper.AccomplishmentsMapper;
import com.base.admin.utils.ClassUtils;

@Service
public class AccomplishmentsServiceImpl implements AccomplishmentsService {
    private final AccomplishmentsMapper accomplishmentsMapper;

    public AccomplishmentsServiceImpl(AccomplishmentsMapper accomplishmentsMapper) {
        this.accomplishmentsMapper = accomplishmentsMapper;
    }

    @Override
    public int deleteByPrimaryKey(UUID accomplishmentid) {
        return accomplishmentsMapper.deleteByPrimaryKey(accomplishmentid);
    }

    @Override
    public int insert(Accomplishments record) {
        record.setAccomplishmentid(UUID.randomUUID());
        return accomplishmentsMapper.insert(record);
    }

    @Override
    public int insertSelective(Accomplishments record) {
        return accomplishmentsMapper.insertSelective(record);
    }

    @Override
    public Accomplishments selectByPrimaryKey(UUID accomplishmentid) {
        return accomplishmentsMapper.selectByPrimaryKey(accomplishmentid);
    }

    @Override
    public int updateByPrimaryKeySelective(Accomplishments record) {
        return accomplishmentsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Accomplishments record) {
        return accomplishmentsMapper.updateByPrimaryKey(record);
    }

    @Override
    public AccomplishmentsDTO findById(UUID accomplishmentid) {
        return accomplishmentsMapper.findById(accomplishmentid);
    }

    @Override
    public Page<AccomplishmentsDTO> searchPaged(AccomplishmentsDTO search, Pageable pageable, boolean exact) {
        long total = 0;
        List<AccomplishmentsDTO> content = accomplishmentsMapper.searchPaged(search, pageable, exact);
        if (!content.isEmpty()) {
            total = accomplishmentsMapper.countPaged(search, exact);
        }
        return new PageImpl<>(content, pageable, total);
    }

    @Override
    public int udpate(Accomplishments accomplishment) {
        Accomplishments accomplish = accomplishmentsMapper.selectByPrimaryKey(accomplishment.getAccomplishmentid());
        if (accomplish != null) {
            accomplish = (Accomplishments) ClassUtils.convertDTOToEntity(accomplishment, accomplish);
            return accomplishmentsMapper.updateByPrimaryKey(accomplish);
        }
        return 0;
    }

    @Override
    public int deleteById(UUID accomplishmentid) {
        return accomplishmentsMapper.deleteByPrimaryKey(accomplishmentid);
    }
}
