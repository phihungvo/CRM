/**
 * @mbg.generated generator on Thu Mar 28 09:26:05 ICT 2024
 */
package com.base.admin.hrm.service;

import com.base.admin.hrm.entity.JobPosition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface JobPositionService {
    JobPosition selectByPrimaryKey(String jobcode);

    int insert(JobPosition row);

    int insertSelective(JobPosition row);

    JobPosition findById(String jobcode);

    Page<JobPosition> searchPaged(JobPosition search, Pageable pageable, boolean exact);

    boolean existsByJobcodeORJobname(String jobcode, String jobname);

    boolean existsByJobNameAndDifferentJobCode(String jobname, String jobcode);

    int addJobPosition(JobPosition jobPosition);

    int update(JobPosition jobPosition);

    int deleteById(String jobcode);
}