package com.base.admin.hrm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import com.base.admin.hrm.entity.JobLevel;

@Mapper
public interface JobLevelMapper {
    int deleteByPrimaryKey(Integer joblevelid);

    int insert(JobLevel row);

    int insertSelective(JobLevel row);

    JobLevel selectByPrimaryKey(Integer joblevelid);

    int updateByPrimaryKeySelective(JobLevel row);

    int updateByPrimaryKey(JobLevel row);

    long countPaged();

    List<JobLevel> searchPaged(@Param("pageable") Pageable pageable);
}
