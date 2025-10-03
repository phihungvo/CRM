/**
 * @mbg.generated generator on Fri Mar 22 12:34:29 ICT 2024
 */
package com.base.admin.masterdata.service;

import com.base.admin.masterdata.entity.DmLoaihopdong;
import com.base.admin.masterdata.mapper.DmLoaihopdongMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DmLoaihopdongServiceImpl implements DmLoaihopdongService {
    private final DmLoaihopdongMapper dmLoaihopdongMapper;

    public DmLoaihopdongServiceImpl(DmLoaihopdongMapper dmLoaihopdongMapper) {
        this.dmLoaihopdongMapper = dmLoaihopdongMapper;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return dmLoaihopdongMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(DmLoaihopdong row) {
        return dmLoaihopdongMapper.insert(row);
    }

    @Override
    public int insertSelective(DmLoaihopdong row) {
        return dmLoaihopdongMapper.insertSelective(row);
    }

    @Override
    public DmLoaihopdong selectByPrimaryKey(Integer id) {
        return dmLoaihopdongMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(DmLoaihopdong row) {
        return dmLoaihopdongMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int updateByPrimaryKey(DmLoaihopdong row) {
        return dmLoaihopdongMapper.updateByPrimaryKey(row);
    }

    @Override
    public Page<DmLoaihopdong> searchPaged(DmLoaihopdong search, Pageable pageable, boolean exact) {
        long total = 0;
        List<DmLoaihopdong> content = dmLoaihopdongMapper.searchPaged(search, pageable, exact);
        if (!content.isEmpty()) {
            total = dmLoaihopdongMapper.countPaged(search, exact);
        }
        return new PageImpl<>(content, pageable, total);
    }
}