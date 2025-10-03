/**
 * @mbg.generated generator on Fri Mar 22 12:34:29 ICT 2024
 */
package com.base.admin.masterdata.service;

import com.base.admin.masterdata.entity.DmQuanhe;
import com.base.admin.masterdata.mapper.DmQuanheMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DmQuanheServiceImpl implements DmQuanheService {
    private final DmQuanheMapper dmQuanheMapper;

    public DmQuanheServiceImpl(DmQuanheMapper dmQuanheMapper) {
        this.dmQuanheMapper = dmQuanheMapper;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return dmQuanheMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(DmQuanhe row) {
        return dmQuanheMapper.insert(row);
    }

    @Override
    public int insertSelective(DmQuanhe row) {
        return dmQuanheMapper.insertSelective(row);
    }

    @Override
    public DmQuanhe selectByPrimaryKey(Integer id) {
        return dmQuanheMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(DmQuanhe row) {
        return dmQuanheMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int updateByPrimaryKey(DmQuanhe row) {
        return dmQuanheMapper.updateByPrimaryKey(row);
    }

    @Override
    public Page<DmQuanhe> searchPaged(DmQuanhe search, Pageable pageable, boolean exact) {
        long total = 0;
        List<DmQuanhe> content = dmQuanheMapper.searchPaged(search, pageable, exact);
        if (!content.isEmpty()) {
            total = dmQuanheMapper.countPaged(search, exact);
        }
        return new PageImpl<>(content, pageable, total);
    }
}