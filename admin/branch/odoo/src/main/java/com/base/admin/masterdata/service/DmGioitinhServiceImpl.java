/**
 * @mbg.generated generator on Fri Mar 22 12:34:29 ICT 2024
 */
package com.base.admin.masterdata.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.base.admin.masterdata.entity.DmGioitinh;
import com.base.admin.masterdata.mapper.DmGioitinhMapper;

@Service
public class DmGioitinhServiceImpl implements DmGioitinhService {
    private final DmGioitinhMapper dmGioitinhMapper;

    public DmGioitinhServiceImpl(DmGioitinhMapper dmGioitinhMapper) {
        this.dmGioitinhMapper = dmGioitinhMapper;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return dmGioitinhMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(DmGioitinh row) {
        return dmGioitinhMapper.insert(row);
    }

    @Override
    public int insertSelective(DmGioitinh row) {
        return dmGioitinhMapper.insertSelective(row);
    }

    @Override
    public DmGioitinh selectByPrimaryKey(Integer id) {
        return dmGioitinhMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(DmGioitinh row) {
        return dmGioitinhMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int updateByPrimaryKey(DmGioitinh row) {
        return dmGioitinhMapper.updateByPrimaryKey(row);
    }

    @Override
    public Page<DmGioitinh> searchPaged(DmGioitinh search, Pageable pageable, boolean exact) {
        long total = 0;
        List<DmGioitinh> content = dmGioitinhMapper.searchPaged(search, pageable, exact);
        if (!content.isEmpty()) {
            total = dmGioitinhMapper.countPaged(search, exact);
        }
        return new PageImpl<>(content, pageable, total);
    }
}
