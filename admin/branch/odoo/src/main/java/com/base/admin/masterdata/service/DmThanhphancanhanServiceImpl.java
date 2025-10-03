/**
 * @mbg.generated generator on Fri Mar 22 12:34:29 ICT 2024
 */
package com.base.admin.masterdata.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.base.admin.masterdata.entity.DmThanhphancanhan;
import com.base.admin.masterdata.mapper.DmThanhphancanhanMapper;

@Service
public class DmThanhphancanhanServiceImpl implements DmThanhphancanhanService {
    private final DmThanhphancanhanMapper dmThanhphancanhanMapper;

    public DmThanhphancanhanServiceImpl(DmThanhphancanhanMapper dmThanhphancanhanMapper) {
        this.dmThanhphancanhanMapper = dmThanhphancanhanMapper;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return dmThanhphancanhanMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(DmThanhphancanhan row) {
        return dmThanhphancanhanMapper.insert(row);
    }

    @Override
    public int insertSelective(DmThanhphancanhan row) {
        return dmThanhphancanhanMapper.insertSelective(row);
    }

    @Override
    public DmThanhphancanhan selectByPrimaryKey(Integer id) {
        return dmThanhphancanhanMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(DmThanhphancanhan row) {
        return dmThanhphancanhanMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int updateByPrimaryKey(DmThanhphancanhan row) {
        return dmThanhphancanhanMapper.updateByPrimaryKey(row);
    }

    @Override
    public Page<DmThanhphancanhan> searchPaged(DmThanhphancanhan search, Pageable pageable, boolean exact) {
        long total = 0;
        List<DmThanhphancanhan> content = dmThanhphancanhanMapper.searchPaged(search, pageable, exact);
        if (!content.isEmpty()) {
            total = dmThanhphancanhanMapper.countPaged(search, exact);
        }
        return new PageImpl<>(content, pageable, total);
    }
}
