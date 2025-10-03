/**
 * @mbg.generated generator on Fri Mar 22 12:34:30 ICT 2024
 */
package com.base.admin.masterdata.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.base.admin.masterdata.entity.DmTrangthailamviec;
import com.base.admin.masterdata.mapper.DmTrangthailamviecMapper;

@Service
public class DmTrangthailamviecServiceImpl implements DmTrangthailamviecService {
    private final DmTrangthailamviecMapper dmTrangthailamviecMapper;

    public DmTrangthailamviecServiceImpl(DmTrangthailamviecMapper dmTrangthailamviecMapper) {
        this.dmTrangthailamviecMapper = dmTrangthailamviecMapper;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return dmTrangthailamviecMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(DmTrangthailamviec row) {
        return dmTrangthailamviecMapper.insert(row);
    }

    @Override
    public int insertSelective(DmTrangthailamviec row) {
        return dmTrangthailamviecMapper.insertSelective(row);
    }

    @Override
    public DmTrangthailamviec selectByPrimaryKey(Integer id) {
        return dmTrangthailamviecMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(DmTrangthailamviec row) {
        return dmTrangthailamviecMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int updateByPrimaryKey(DmTrangthailamviec row) {
        return dmTrangthailamviecMapper.updateByPrimaryKey(row);
    }

    @Override
    public Page<DmTrangthailamviec> searchPaged(DmTrangthailamviec search, Pageable pageable, boolean exact) {
        long total = 0;
        List<DmTrangthailamviec> content = dmTrangthailamviecMapper.searchPaged(search, pageable, exact);
        if (!content.isEmpty()) {
            total = dmTrangthailamviecMapper.countPaged(search, exact);
        }
        return new PageImpl<>(content, pageable, total);
    }
}
