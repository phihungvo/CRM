/**
 * @mbg.generated generator on Wed Mar 27 21:29:21 ICT 2024
 */
package com.base.admin.hrm.service;

import com.base.admin.hrm.entity.JobGroup;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface JobGroupService {
    int deleteByPrimaryKey(Integer jobgroupid);

    int insert(JobGroup row);

    int insertSelective(JobGroup row);

    JobGroup selectByPrimaryKey(Integer jobgroupid);

    int updateByPrimaryKeySelective(JobGroup row);

    int updateByPrimaryKey(JobGroup row);

    JobGroup findById(Integer jobgroupid);

    Page<JobGroup> searchPaged(Pageable pageable);
}