/**
 * @mbg.generated generator on Sun Mar 24 20:54:30 ICT 2024
 */
package com.base.admin.masterdata.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.base.admin.masterdata.entity.DmNganhnghe;
import com.base.admin.masterdata.mapper.DmNganhngheMapper;

@Service
public class DmNganhngheServiceImpl implements DmNganhngheService {
    private final DmNganhngheMapper dmNganhngheMapper;

    public DmNganhngheServiceImpl(DmNganhngheMapper dmNganhngheMapper) {
        this.dmNganhngheMapper = dmNganhngheMapper;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return dmNganhngheMapper.deleteByPrimaryKey(id);
    }

    @Override
    public DmNganhnghe selectByPrimaryKey(Integer id) {
        return dmNganhngheMapper.selectByPrimaryKey(id);
    }

    @Override
    public int insert(DmNganhnghe row) {
        return dmNganhngheMapper.insert(row);
    }

    @Override
    public int insertSelective(DmNganhnghe row) {
        return dmNganhngheMapper.insertSelective(row);
    }

    @Override
    public Page<DmNganhnghe> searchPaged(DmNganhnghe search, Pageable pageable, boolean exact) {
        long total = 0;
        List<DmNganhnghe> content = dmNganhngheMapper.searchPaged(search, pageable, exact);
        if (!content.isEmpty()) {
            total = dmNganhngheMapper.countPaged(search, exact);
        }
        return new PageImpl<>(content, pageable, total);
    }
}
