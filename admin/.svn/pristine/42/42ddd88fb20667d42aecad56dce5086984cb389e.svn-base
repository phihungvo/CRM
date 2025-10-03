package com.base.admin.hrm.mapper;

import com.base.admin.hrm.entity.JobLevel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

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