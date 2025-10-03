/**
 * @mbg.generated generator on Wed Mar 27 21:29:21 ICT 2024
 */
package com.base.admin.hrm.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.base.admin.hrm.entity.JobGroup;
import com.base.admin.hrm.mapper.JobGroupMapper;

@Service
public class JobGroupServiceImpl implements JobGroupService {
    private final JobGroupMapper jobGroupMapper;

    public JobGroupServiceImpl(JobGroupMapper jobGroupMapper) {
        this.jobGroupMapper = jobGroupMapper;
    }

    @Override
    public int deleteByPrimaryKey(Integer jobgroupid) {
        return jobGroupMapper.deleteByPrimaryKey(jobgroupid);
    }

    @Override
    public int insert(JobGroup row) {
        return jobGroupMapper.insert(row);
    }

    @Override
    public int insertSelective(JobGroup row) {
        return jobGroupMapper.insertSelective(row);
    }

    @Override
    public JobGroup selectByPrimaryKey(Integer jobgroupid) {
        return jobGroupMapper.selectByPrimaryKey(jobgroupid);
    }

    @Override
    public int updateByPrimaryKeySelective(JobGroup row) {
        return jobGroupMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int updateByPrimaryKey(JobGroup row) {
        return jobGroupMapper.updateByPrimaryKey(row);
    }

    @Override
    public JobGroup findById(Integer jobgroupid) {
        return jobGroupMapper.selectByPrimaryKey(jobgroupid);
    }

    @Override
    public Page<JobGroup> searchPaged(Pageable pageable) {
        long total = 0;
        List<JobGroup> content = jobGroupMapper.searchPaged(pageable);
        if (!content.isEmpty()) {
            total = jobGroupMapper.countPaged();
        }
        return new PageImpl<>(content, pageable, total);
    }
}
