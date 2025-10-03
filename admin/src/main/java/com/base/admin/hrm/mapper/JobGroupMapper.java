package com.base.admin.hrm.mapper;

import com.base.admin.hrm.entity.JobGroup;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Mapper
public interface JobGroupMapper {
    int deleteByPrimaryKey(Integer jobgroupid);

    int insert(JobGroup row);

    int insertSelective(JobGroup row);

    JobGroup selectByPrimaryKey(Integer jobgroupid);

    int updateByPrimaryKeySelective(JobGroup row);

    int updateByPrimaryKey(JobGroup row);

    long countPaged();

    List<JobGroup> searchPaged(@Param("pageable") Pageable pageable);
}