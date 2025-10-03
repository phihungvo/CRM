/**
 * @mbg.generated generator on Fri Mar 22 12:34:29 ICT 2024
 */
package com.base.admin.masterdata.service;

import com.base.admin.masterdata.entity.DmDantoc;
import com.base.admin.masterdata.mapper.DmDantocMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DmDantocServiceImpl implements DmDantocService {
    private final DmDantocMapper dmDantocMapper;

    public DmDantocServiceImpl(DmDantocMapper dmDantocMapper) {
        this.dmDantocMapper = dmDantocMapper;
    }

    @Override
    public Page<DmDantoc> searchPaged(DmDantoc search, Pageable pageable, boolean exact) {
        long total = 0;
        List<DmDantoc> content = dmDantocMapper.searchPaged(search, pageable, exact);
        if (!content.isEmpty()) {
            total = dmDantocMapper.countPaged(search, exact);
        }
        return new PageImpl<>(content, pageable, total);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return dmDantocMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(DmDantoc row) {
        return dmDantocMapper.insert(row);
    }

    @Override
    public int insertSelective(DmDantoc row) {
        return dmDantocMapper.insertSelective(row);
    }

    @Override
    public DmDantoc selectByPrimaryKey(Integer id) {
        return dmDantocMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(DmDantoc row) {
        return dmDantocMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int updateByPrimaryKey(DmDantoc row) {
        return dmDantocMapper.updateByPrimaryKey(row);
    }
}