/**
 * @mbg.generated generator on Fri Mar 22 12:34:29 ICT 2024
 */
package com.base.admin.masterdata.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.base.admin.masterdata.entity.DmThanhphangiadinh;
import com.base.admin.masterdata.mapper.DmThanhphangiadinhMapper;

@Service
public class DmThanhphangiadinhServiceImpl implements DmThanhphangiadinhService {
    private final DmThanhphangiadinhMapper dmThanhphangiadinhMapper;

    public DmThanhphangiadinhServiceImpl(DmThanhphangiadinhMapper dmThanhphangiadinhMapper) {
        this.dmThanhphangiadinhMapper = dmThanhphangiadinhMapper;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return dmThanhphangiadinhMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(DmThanhphangiadinh row) {
        return dmThanhphangiadinhMapper.insert(row);
    }

    @Override
    public int insertSelective(DmThanhphangiadinh row) {
        return dmThanhphangiadinhMapper.insertSelective(row);
    }

    @Override
    public DmThanhphangiadinh selectByPrimaryKey(Integer id) {
        return dmThanhphangiadinhMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(DmThanhphangiadinh row) {
        return dmThanhphangiadinhMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int updateByPrimaryKey(DmThanhphangiadinh row) {
        return dmThanhphangiadinhMapper.updateByPrimaryKey(row);
    }

    @Override
    public Page<DmThanhphangiadinh> searchPaged(DmThanhphangiadinh search, Pageable pageable, boolean exact) {
        long total = 0;
        List<DmThanhphangiadinh> content = dmThanhphangiadinhMapper.searchPaged(search, pageable, exact);
        if (!content.isEmpty()) {
            total = dmThanhphangiadinhMapper.countPaged(search, exact);
        }
        return new PageImpl<>(content, pageable, total);
    }
}
