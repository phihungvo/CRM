/**
 * @mbg.generated generator on Wed Mar 27 21:29:22 ICT 2024
 */
package com.base.admin.hrm.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.base.admin.hrm.entity.UnitLevel;
import com.base.admin.hrm.mapper.UnitLevelMapper;

@Service
public class UnitLevelServiceImpl implements UnitLevelService {
    private final UnitLevelMapper unitLevelMapper;

    public UnitLevelServiceImpl(UnitLevelMapper unitLevelMapper) {
        this.unitLevelMapper = unitLevelMapper;
    }

    @Override
    public int deleteByPrimaryKey(Integer unitlevelid) {
        return unitLevelMapper.deleteByPrimaryKey(unitlevelid);
    }

    @Override
    public int insert(UnitLevel row) {
        return unitLevelMapper.insert(row);
    }

    @Override
    public int insertSelective(UnitLevel row) {
        return unitLevelMapper.insertSelective(row);
    }

    @Override
    public UnitLevel selectByPrimaryKey(Integer unitlevelid) {
        return unitLevelMapper.selectByPrimaryKey(unitlevelid);
    }

    @Override
    public int updateByPrimaryKeySelective(UnitLevel row) {
        return unitLevelMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int updateByPrimaryKey(UnitLevel row) {
        return unitLevelMapper.updateByPrimaryKey(row);
    }

    @Override
    public UnitLevel findById(Integer unitlevelid) {
        return unitLevelMapper.selectByPrimaryKey(unitlevelid);
    }

    @Override
    public Page<UnitLevel> searchPaged(Integer level, Pageable pageable) {
        long total = 0;
        List<UnitLevel> content = unitLevelMapper.searchPaged(level, pageable);
        if (!content.isEmpty()) {
            total = unitLevelMapper.countPaged(level);
        }
        return new PageImpl<>(content, pageable, total);
    }
}
