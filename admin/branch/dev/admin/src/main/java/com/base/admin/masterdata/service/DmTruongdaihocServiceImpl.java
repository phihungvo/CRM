/**
 * @mbg.generated generator on Fri Mar 22 12:34:30 ICT 2024
 */
package com.base.admin.masterdata.service;

import com.base.admin.masterdata.entity.DmTruongdaihoc;
import com.base.admin.masterdata.mapper.DmTruongdaihocMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DmTruongdaihocServiceImpl implements DmTruongdaihocService {
    private final DmTruongdaihocMapper dmTruongdaihocMapper;

    public DmTruongdaihocServiceImpl(DmTruongdaihocMapper dmTruongdaihocMapper) {
        this.dmTruongdaihocMapper = dmTruongdaihocMapper;
    }

    @Override
    public int insert(DmTruongdaihoc row) {
        return dmTruongdaihocMapper.insert(row);
    }

    @Override
    public int insertSelective(DmTruongdaihoc row) {
        return dmTruongdaihocMapper.insertSelective(row);
    }

    @Override
    public DmTruongdaihoc selectByPrimaryKey(Integer id) {
        return dmTruongdaihocMapper.selectByPrimaryKey(id);
    }

    @Override
    public Page<DmTruongdaihoc> searchPaged(DmTruongdaihoc search, Pageable pageable, boolean exact) {
        long total = 0;
        List<DmTruongdaihoc> content = dmTruongdaihocMapper.searchPaged(search, pageable, exact);
        if (!content.isEmpty()) {
            total = dmTruongdaihocMapper.countPaged(search, exact);
        }
        return new PageImpl<>(content, pageable, total);
    }
}