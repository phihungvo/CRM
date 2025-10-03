/**
 * @mbg.generated generator on Fri Mar 22 12:34:30 ICT 2024
 */
package com.base.admin.masterdata.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.base.admin.masterdata.entity.DmTrinhdodaotao;
import com.base.admin.masterdata.mapper.DmTrinhdodaotaoMapper;

@Service
public class DmTrinhdodaotaoServiceImpl implements DmTrinhdodaotaoService {
    private final DmTrinhdodaotaoMapper dmTrinhdodaotaoMapper;

    public DmTrinhdodaotaoServiceImpl(DmTrinhdodaotaoMapper dmTrinhdodaotaoMapper) {
        this.dmTrinhdodaotaoMapper = dmTrinhdodaotaoMapper;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return dmTrinhdodaotaoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(DmTrinhdodaotao row) {
        return dmTrinhdodaotaoMapper.insert(row);
    }

    @Override
    public int insertSelective(DmTrinhdodaotao row) {
        return dmTrinhdodaotaoMapper.insertSelective(row);
    }

    @Override
    public DmTrinhdodaotao selectByPrimaryKey(Integer id) {
        return dmTrinhdodaotaoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(DmTrinhdodaotao row) {
        return dmTrinhdodaotaoMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int updateByPrimaryKey(DmTrinhdodaotao row) {
        return dmTrinhdodaotaoMapper.updateByPrimaryKey(row);
    }

    @Override
    public Page<DmTrinhdodaotao> searchPaged(DmTrinhdodaotao search, Pageable pageable, boolean exact) {
        long total = 0;
        List<DmTrinhdodaotao> content = dmTrinhdodaotaoMapper.searchPaged(search, pageable, exact);
        if (!content.isEmpty()) {
            total = dmTrinhdodaotaoMapper.countPaged(search, exact);
        }
        return new PageImpl<>(content, pageable, total);
    }
}
