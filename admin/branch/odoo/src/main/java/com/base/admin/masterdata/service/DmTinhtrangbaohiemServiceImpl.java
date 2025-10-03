/**
 * @mbg.generated generator on Fri Mar 22 12:34:29 ICT 2024
 */
package com.base.admin.masterdata.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.base.admin.masterdata.entity.DmTinhtrangbaohiem;
import com.base.admin.masterdata.mapper.DmTinhtrangbaohiemMapper;

@Service
public class DmTinhtrangbaohiemServiceImpl implements DmTinhtrangbaohiemService {
    private final DmTinhtrangbaohiemMapper dmTinhtrangbaohiemMapper;

    public DmTinhtrangbaohiemServiceImpl(DmTinhtrangbaohiemMapper dmTinhtrangbaohiemMapper) {
        this.dmTinhtrangbaohiemMapper = dmTinhtrangbaohiemMapper;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return dmTinhtrangbaohiemMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(DmTinhtrangbaohiem row) {
        return dmTinhtrangbaohiemMapper.insert(row);
    }

    @Override
    public int insertSelective(DmTinhtrangbaohiem row) {
        return dmTinhtrangbaohiemMapper.insertSelective(row);
    }

    @Override
    public DmTinhtrangbaohiem selectByPrimaryKey(Integer id) {
        return dmTinhtrangbaohiemMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(DmTinhtrangbaohiem row) {
        return dmTinhtrangbaohiemMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int updateByPrimaryKey(DmTinhtrangbaohiem row) {
        return dmTinhtrangbaohiemMapper.updateByPrimaryKey(row);
    }

    @Override
    public Page<DmTinhtrangbaohiem> searchPaged(DmTinhtrangbaohiem search, Pageable pageable, boolean exact) {
        long total = 0;
        List<DmTinhtrangbaohiem> content = dmTinhtrangbaohiemMapper.searchPaged(search, pageable, exact);
        if (!content.isEmpty()) {
            total = dmTinhtrangbaohiemMapper.countPaged(search, exact);
        }
        return new PageImpl<>(content, pageable, total);
    }
}
