/**
 * @mbg.generated generator on Wed Mar 27 21:29:21 ICT 2024
 */
package com.base.admin.hrm.service;

import com.base.admin.hrm.entity.JobLevel;
import com.base.admin.hrm.mapper.JobLevelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobLevelServiceImpl implements JobLevelService {
    private final JobLevelMapper jobLevelMapper;

    public JobLevelServiceImpl(JobLevelMapper jobLevelMapper) {
        this.jobLevelMapper = jobLevelMapper;
    }

    @Override
    public int deleteByPrimaryKey(Integer joblevelid) {
        return jobLevelMapper.deleteByPrimaryKey(joblevelid);
    }

    @Override
    public int insert(JobLevel row) {
        return jobLevelMapper.insert(row);
    }

    @Override
    public int insertSelective(JobLevel row) {
        return jobLevelMapper.insertSelective(row);
    }

    @Override
    public JobLevel selectByPrimaryKey(Integer joblevelid) {
        return jobLevelMapper.selectByPrimaryKey(joblevelid);
    }

    @Override
    public int updateByPrimaryKeySelective(JobLevel row) {
        return jobLevelMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int updateByPrimaryKey(JobLevel row) {
        return jobLevelMapper.updateByPrimaryKey(row);
    }

    @Override
    public JobLevel findById(Integer joblevelid) {
        return jobLevelMapper.selectByPrimaryKey(joblevelid);
    }

    @Override
    public Page<JobLevel> searchPaged(Pageable pageable) {
        long total = 0;
        List<JobLevel> content = jobLevelMapper.searchPaged(pageable);
        if (!content.isEmpty()) {
            total = jobLevelMapper.countPaged();
        }
        return new PageImpl<>(content, pageable, total);
    }
}