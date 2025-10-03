/**
 * @mbg.generated generator on Wed Mar 27 21:29:22 ICT 2024
 */
package com.base.admin.hrm.service;

import com.base.admin.hrm.entity.JobTitle;
import com.base.admin.hrm.mapper.JobTitleMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobTitleServiceImpl implements JobTitleService {
    private final JobTitleMapper jobTitleMapper;

    public JobTitleServiceImpl(JobTitleMapper jobTitleMapper) {
        this.jobTitleMapper = jobTitleMapper;
    }

    @Override
    public int deleteByPrimaryKey(Integer jobtitleid) {
        return jobTitleMapper.deleteByPrimaryKey(jobtitleid);
    }

    @Override
    public int insert(JobTitle row) {
        return jobTitleMapper.insert(row);
    }

    @Override
    public int insertSelective(JobTitle row) {
        return jobTitleMapper.insertSelective(row);
    }

    @Override
    public JobTitle selectByPrimaryKey(Integer jobtitleid) {
        return jobTitleMapper.selectByPrimaryKey(jobtitleid);
    }

    @Override
    public int updateByPrimaryKeySelective(JobTitle row) {
        return jobTitleMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int updateByPrimaryKey(JobTitle row) {
        return jobTitleMapper.updateByPrimaryKey(row);
    }

    @Override
    public JobTitle findById(Integer jobtitleid) {
        return jobTitleMapper.selectByPrimaryKey(jobtitleid);
    }

    @Override
    public Page<JobTitle> searchPaged(Pageable pageable) {
        long total = 0;
        List<JobTitle> content = jobTitleMapper.searchPaged(pageable);
        if (!content.isEmpty()) {
            total = jobTitleMapper.countPaged();
        }
        return new PageImpl<>(content, pageable, total);
    }
}