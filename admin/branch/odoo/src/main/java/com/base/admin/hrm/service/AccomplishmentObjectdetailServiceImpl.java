package com.base.admin.hrm.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.base.admin.hrm.dto.AccomplishmentObjectdetailDTO;
import com.base.admin.hrm.entity.AccomplishmentObjectdetail;
import com.base.admin.hrm.entity.KeyAndPosition;
import com.base.admin.hrm.mapper.AccomplishmentObjectdetailMapper;
import com.base.admin.utils.ClassUtils;

@Service
public class AccomplishmentObjectdetailServiceImpl implements AccomplishmentObjectdetailService {
    private final AccomplishmentObjectdetailMapper accomplishmentObjectdetailMapper;

    public AccomplishmentObjectdetailServiceImpl(AccomplishmentObjectdetailMapper accomplishmentObjectdetailMapper) {
        this.accomplishmentObjectdetailMapper = accomplishmentObjectdetailMapper;
    }

    @Override
    public int deleteByPrimaryKey(Integer accomplishmentobjectdetailid) {
        return accomplishmentObjectdetailMapper.deleteByPrimaryKey(accomplishmentobjectdetailid);
    }

    @Override
    public int insert(AccomplishmentObjectdetail record) {
        return accomplishmentObjectdetailMapper.insert(record);
    }

    @Override
    public int addRecord(String accomplishmentobjectdetailname) {
        KeyAndPosition keyAndPosition = accomplishmentObjectdetailMapper.generateKeyAndPosition();
        if (keyAndPosition != null) {
            AccomplishmentObjectdetail record = new AccomplishmentObjectdetail();
            record.setAccomplishmentobjectdetailid(keyAndPosition.getId() + 1);
            record.setAccomplishmentobjectdetailname(accomplishmentobjectdetailname);
            record.setPosition(keyAndPosition.getPosition() + 1);
            record.setIsSystem(false);
            record.setIsFavorite(false);
            return accomplishmentObjectdetailMapper.insert(record);
        }
        return 0;
    }

    @Override
    public int insertSelective(AccomplishmentObjectdetail record) {
        return accomplishmentObjectdetailMapper.insertSelective(record);
    }

    @Override
    public AccomplishmentObjectdetail selectByPrimaryKey(Integer accomplishmentobjectdetailid) {
        return accomplishmentObjectdetailMapper.selectByPrimaryKey(accomplishmentobjectdetailid);
    }

    @Override
    public int updateByPrimaryKeySelective(AccomplishmentObjectdetail record) {
        return accomplishmentObjectdetailMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(AccomplishmentObjectdetail record) {
        return accomplishmentObjectdetailMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public AccomplishmentObjectdetailDTO findById(Integer accomplishmentobjectdetailid) {
        return accomplishmentObjectdetailMapper.findById(accomplishmentobjectdetailid);
    }

    @Override
    public Page<AccomplishmentObjectdetailDTO> searchPaged(Pageable pageable) {
        long total = 0;
        List<AccomplishmentObjectdetailDTO> content = accomplishmentObjectdetailMapper.searchPaged(pageable);
        if (!content.isEmpty()) {
            total = accomplishmentObjectdetailMapper.countPaged();
        }
        return new PageImpl<>(content, pageable, total);
    }

    @Override
    public boolean existByName(String name) {
        return accomplishmentObjectdetailMapper.existByName(name);
    }

    @Override
    public int udpate(AccomplishmentObjectdetail accomplishmentObjectdetailDTO) {
        AccomplishmentObjectdetail accomplishmentObjectdetail = accomplishmentObjectdetailMapper.selectByPrimaryKey(
                accomplishmentObjectdetailDTO.getAccomplishmentobjectdetailid());
        if (accomplishmentObjectdetail != null) {
            accomplishmentObjectdetail = (AccomplishmentObjectdetail)
                    ClassUtils.convertDTOToEntity(accomplishmentObjectdetailDTO, accomplishmentObjectdetail);
            return accomplishmentObjectdetailMapper.updateByPrimaryKey(accomplishmentObjectdetail);
        }
        return 0;
    }

    @Override
    public int deleteById(Integer accomplishmentobjectdetailid) {
        return accomplishmentObjectdetailMapper.deleteByPrimaryKey(accomplishmentobjectdetailid);
    }
}
