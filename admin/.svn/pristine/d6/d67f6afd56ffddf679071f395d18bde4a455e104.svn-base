/**
 * @mbg.generated generator on Fri Mar 22 12:34:29 ICT 2024
 */
package com.base.admin.masterdata.service;

import com.base.admin.masterdata.entity.DmNoicap;
import com.base.admin.masterdata.mapper.DmNoicapMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DmNoicapServiceImpl implements DmNoicapService {
    private final DmNoicapMapper dmNoicapMapper;

    public DmNoicapServiceImpl(DmNoicapMapper dmNoicapMapper) {
        this.dmNoicapMapper = dmNoicapMapper;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return dmNoicapMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(DmNoicap row) {
        return dmNoicapMapper.insert(row);
    }

    @Override
    public int insertSelective(DmNoicap row) {
        return dmNoicapMapper.insertSelective(row);
    }

    @Override
    public DmNoicap selectByPrimaryKey(Integer id) {
        return dmNoicapMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(DmNoicap row) {
        return dmNoicapMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int updateByPrimaryKey(DmNoicap row) {
        return dmNoicapMapper.updateByPrimaryKey(row);
    }

    @Override
    public Page<DmNoicap> searchPaged(DmNoicap search, Pageable pageable, boolean exact) {
        long total = 0;
        List<DmNoicap> content = dmNoicapMapper.searchPaged(search, pageable, exact);
        if (!content.isEmpty()) {
            total = dmNoicapMapper.countPaged(search, exact);
        }
        return new PageImpl<>(content, pageable, total);
    }
}