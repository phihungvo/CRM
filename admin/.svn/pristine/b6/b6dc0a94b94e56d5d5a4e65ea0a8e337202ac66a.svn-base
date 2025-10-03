/**
 * @mbg.generated generator on Fri Mar 22 12:34:29 ICT 2024
 */
package com.base.admin.masterdata.service;

import com.base.admin.masterdata.entity.DmTinhtranghonnhan;
import com.base.admin.masterdata.mapper.DmTinhtranghonnhanMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DmTinhtranghonnhanServiceImpl implements DmTinhtranghonnhanService {
    private final DmTinhtranghonnhanMapper dmTinhtranghonnhanMapper;

    public DmTinhtranghonnhanServiceImpl(DmTinhtranghonnhanMapper dmTinhtranghonnhanMapper) {
        this.dmTinhtranghonnhanMapper = dmTinhtranghonnhanMapper;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return dmTinhtranghonnhanMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(DmTinhtranghonnhan row) {
        return dmTinhtranghonnhanMapper.insert(row);
    }

    @Override
    public int insertSelective(DmTinhtranghonnhan row) {
        return dmTinhtranghonnhanMapper.insertSelective(row);
    }

    @Override
    public DmTinhtranghonnhan selectByPrimaryKey(Integer id) {
        return dmTinhtranghonnhanMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(DmTinhtranghonnhan row) {
        return dmTinhtranghonnhanMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int updateByPrimaryKey(DmTinhtranghonnhan row) {
        return dmTinhtranghonnhanMapper.updateByPrimaryKey(row);
    }

    @Override
    public Page<DmTinhtranghonnhan> searchPaged(DmTinhtranghonnhan search, Pageable pageable, boolean exact) {
        long total = 0;
        List<DmTinhtranghonnhan> content = dmTinhtranghonnhanMapper.searchPaged(search, pageable, exact);
        if (!content.isEmpty()) {
            total = dmTinhtranghonnhanMapper.countPaged(search, exact);
        }
        return new PageImpl<>(content, pageable, total);
    }
}