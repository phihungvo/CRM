/**
 * @mbg.generated generator on Thu Mar 28 09:26:05 ICT 2024
 */
package com.base.admin.hrm.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.base.admin.hrm.entity.JobPosition;
import com.base.admin.hrm.mapper.JobPositionMapper;
import com.base.admin.utils.ClassUtils;

@Service
public class JobPositionServiceImpl implements JobPositionService {
    private final JobPositionMapper jobPositionMapper;

    public JobPositionServiceImpl(JobPositionMapper jobPositionMapper) {
        this.jobPositionMapper = jobPositionMapper;
    }

    @Override
    public JobPosition selectByPrimaryKey(String jobcode) {
        return jobPositionMapper.selectByPrimaryKey(jobcode);
    }

    @Override
    public int insert(JobPosition row) {
        return jobPositionMapper.insert(row);
    }

    @Override
    public int insertSelective(JobPosition row) {
        return jobPositionMapper.insertSelective(row);
    }

    @Override
    public JobPosition findById(String jobcode) {
        return jobPositionMapper.selectByPrimaryKey(jobcode);
    }

    @Override
    public Page<JobPosition> searchPaged(JobPosition search, Pageable pageable, boolean exact) {
        long total = 0;
        List<JobPosition> content = jobPositionMapper.searchPaged(search, pageable, exact);
        if (!content.isEmpty()) {
            total = jobPositionMapper.countPaged(search, exact);
        }
        return new PageImpl<>(content, pageable, total);
    }

    @Override
    public boolean existsByJobcodeORJobname(String jobcode, String jobname) {
        return jobPositionMapper.existsByJobcodeORJobname(jobcode, jobname);
    }

    @Override
    public boolean existsByJobNameAndDifferentJobCode(String jobname, String jobcode) {
        return jobPositionMapper.existsByJobNameAndDifferentJobCode(jobname, jobcode);
    }

    @Override
    public int addJobPosition(JobPosition jobPosition) {
        return jobPositionMapper.insert(jobPosition);
    }

    @Override
    public int update(JobPosition jobPositionDTO) {
        JobPosition jobPosition = jobPositionMapper.selectByPrimaryKey(jobPositionDTO.getJobcode());
        if (jobPosition != null) {
            jobPosition = (JobPosition) ClassUtils.convertDTOToEntity(jobPositionDTO, jobPosition);
            return jobPositionMapper.updateByPrimaryKey(jobPosition);
        }
        return 0;
    }

    @Override
    public int deleteById(String jobcode) {
        return jobPositionMapper.deleteByPrimaryKey(jobcode);
    }
}
