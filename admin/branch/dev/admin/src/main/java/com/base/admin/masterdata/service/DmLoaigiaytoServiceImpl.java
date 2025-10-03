/**
 * @mbg.generated generator on Fri Mar 22 12:34:29 ICT 2024
 */
package com.base.admin.masterdata.service;

import com.base.admin.masterdata.entity.DmLoaigiayto;
import com.base.admin.masterdata.mapper.DmLoaigiaytoMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DmLoaigiaytoServiceImpl implements DmLoaigiaytoService {
    private final DmLoaigiaytoMapper dmLoaigiaytoMapper;

    public DmLoaigiaytoServiceImpl(DmLoaigiaytoMapper dmLoaigiaytoMapper) {
        this.dmLoaigiaytoMapper = dmLoaigiaytoMapper;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return dmLoaigiaytoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(DmLoaigiayto row) {
        return dmLoaigiaytoMapper.insert(row);
    }

    @Override
    public int insertSelective(DmLoaigiayto row) {
        return dmLoaigiaytoMapper.insertSelective(row);
    }

    @Override
    public DmLoaigiayto selectByPrimaryKey(Integer id) {
        return dmLoaigiaytoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(DmLoaigiayto row) {
        return dmLoaigiaytoMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int updateByPrimaryKey(DmLoaigiayto row) {
        return dmLoaigiaytoMapper.updateByPrimaryKey(row);
    }

    @Override
    public Page<DmLoaigiayto> searchPaged(DmLoaigiayto search, Pageable pageable, boolean exact) {
        long total = 0;
        List<DmLoaigiayto> content = dmLoaigiaytoMapper.searchPaged(search, pageable, exact);
        if (!content.isEmpty()) {
            total = dmLoaigiaytoMapper.countPaged(search, exact);
        }
        return new PageImpl<>(content, pageable, total);
    }
}