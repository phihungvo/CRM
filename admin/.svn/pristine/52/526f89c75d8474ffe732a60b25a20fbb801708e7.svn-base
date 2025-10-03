/**
 * @mbg.generated generator on Fri Mar 22 12:34:30 ICT 2024
 */
package com.base.admin.masterdata.service;

import com.base.admin.masterdata.entity.DmXeploai;
import com.base.admin.masterdata.mapper.DmXeploaiMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DmXeploaiServiceImpl implements DmXeploaiService {
    private final DmXeploaiMapper dmXeploaiMapper;

    public DmXeploaiServiceImpl(DmXeploaiMapper dmXeploaiMapper) {
        this.dmXeploaiMapper = dmXeploaiMapper;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return dmXeploaiMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(DmXeploai row) {
        return dmXeploaiMapper.insert(row);
    }

    @Override
    public int insertSelective(DmXeploai row) {
        return dmXeploaiMapper.insertSelective(row);
    }

    @Override
    public DmXeploai selectByPrimaryKey(Integer id) {
        return dmXeploaiMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(DmXeploai row) {
        return dmXeploaiMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int updateByPrimaryKey(DmXeploai row) {
        return dmXeploaiMapper.updateByPrimaryKey(row);
    }

    @Override
    public Page<DmXeploai> searchPaged(DmXeploai search, Pageable pageable, boolean exact) {
        long total = 0;
        List<DmXeploai> content = dmXeploaiMapper.searchPaged(search, pageable, exact);
        if (!content.isEmpty()) {
            total = dmXeploaiMapper.countPaged(search, exact);
        }
        return new PageImpl<>(content, pageable, total);
    }
}