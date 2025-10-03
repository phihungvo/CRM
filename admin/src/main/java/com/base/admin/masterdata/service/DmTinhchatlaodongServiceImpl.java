/**
 * @mbg.generated generator on Fri Mar 22 12:34:29 ICT 2024
 */
package com.base.admin.masterdata.service;

import com.base.admin.masterdata.entity.DmTinhchatlaodong;
import com.base.admin.masterdata.mapper.DmTinhchatlaodongMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DmTinhchatlaodongServiceImpl implements DmTinhchatlaodongService {
    private final DmTinhchatlaodongMapper dmTinhchatlaodongMapper;

    public DmTinhchatlaodongServiceImpl(DmTinhchatlaodongMapper dmTinhchatlaodongMapper) {
        this.dmTinhchatlaodongMapper = dmTinhchatlaodongMapper;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return dmTinhchatlaodongMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(DmTinhchatlaodong row) {
        return dmTinhchatlaodongMapper.insert(row);
    }

    @Override
    public int insertSelective(DmTinhchatlaodong row) {
        return dmTinhchatlaodongMapper.insertSelective(row);
    }

    @Override
    public DmTinhchatlaodong selectByPrimaryKey(Integer id) {
        return dmTinhchatlaodongMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(DmTinhchatlaodong row) {
        return dmTinhchatlaodongMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int updateByPrimaryKey(DmTinhchatlaodong row) {
        return dmTinhchatlaodongMapper.updateByPrimaryKey(row);
    }

    @Override
    public Page<DmTinhchatlaodong> searchPaged(DmTinhchatlaodong search, Pageable pageable, boolean exact) {
        long total = 0;
        List<DmTinhchatlaodong> content = dmTinhchatlaodongMapper.searchPaged(search, pageable, exact);
        if (!content.isEmpty()) {
            total = dmTinhchatlaodongMapper.countPaged(search, exact);
        }
        return new PageImpl<>(content, pageable, total);
    }
}