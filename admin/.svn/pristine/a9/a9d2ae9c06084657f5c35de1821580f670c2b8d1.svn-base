/**
 * @mbg.generated generator on Fri Mar 22 12:34:30 ICT 2024
 */
package com.base.admin.masterdata.service;

import com.base.admin.masterdata.entity.DmTongiao;
import com.base.admin.masterdata.mapper.DmTongiaoMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DmTongiaoServiceImpl implements DmTongiaoService {
    private final DmTongiaoMapper dmTongiaoMapper;

    public DmTongiaoServiceImpl(DmTongiaoMapper dmTongiaoMapper) {
        this.dmTongiaoMapper = dmTongiaoMapper;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return dmTongiaoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(DmTongiao row) {
        return dmTongiaoMapper.insert(row);
    }

    @Override
    public int insertSelective(DmTongiao row) {
        return dmTongiaoMapper.insertSelective(row);
    }

    @Override
    public DmTongiao selectByPrimaryKey(Integer id) {
        return dmTongiaoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(DmTongiao row) {
        return dmTongiaoMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int updateByPrimaryKey(DmTongiao row) {
        return dmTongiaoMapper.updateByPrimaryKey(row);
    }

    @Override
    public Page<DmTongiao> searchPaged(DmTongiao search, Pageable pageable, boolean exact) {
        long total = 0;
        List<DmTongiao> content = dmTongiaoMapper.searchPaged(search, pageable, exact);
        if (!content.isEmpty()) {
            total = dmTongiaoMapper.countPaged(search, exact);
        }
        return new PageImpl<>(content, pageable, total);
    }
}