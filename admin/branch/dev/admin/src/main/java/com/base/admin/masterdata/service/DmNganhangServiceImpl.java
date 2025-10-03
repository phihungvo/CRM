package com.base.admin.masterdata.service;

import com.base.admin.masterdata.entity.DmNganhang;
import com.base.admin.masterdata.mapper.DmNganhangMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DmNganhangServiceImpl implements DmNganhangService {

    private final DmNganhangMapper dmNganhangMapper;

    public DmNganhangServiceImpl(DmNganhangMapper dmNganhangMapper) {
        this.dmNganhangMapper = dmNganhangMapper;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return dmNganhangMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(DmNganhang record) {
        return dmNganhangMapper.insert(record);
    }

    @Override
    public DmNganhang selectByPrimaryKey(Integer id) {
        return dmNganhangMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKey(DmNganhang record) {
        return dmNganhangMapper.updateByPrimaryKey(record);
    }

    @Override
    public Page<DmNganhang> searchPaged(DmNganhang search, Pageable pageable, boolean exact) {
        long total = 0;
        List<DmNganhang> content = dmNganhangMapper.searchPaged(search, pageable, exact);
        if (!content.isEmpty()) {
            total = dmNganhangMapper.countPaged(search, exact);
        }
        return new PageImpl<>(content, pageable, total);
    }
}
