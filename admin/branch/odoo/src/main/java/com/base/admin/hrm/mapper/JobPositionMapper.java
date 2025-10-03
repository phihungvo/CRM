package com.base.admin.hrm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.domain.Pageable;

import com.base.admin.hrm.entity.JobPosition;

@Mapper
public interface JobPositionMapper {
    int insert(JobPosition row);

    int updateByPrimaryKey(JobPosition row);

    int deleteByPrimaryKey(String jobcode);

    int insertSelective(JobPosition row);

    JobPosition selectByPrimaryKey(@Param("jobcode") String jobcode);

    long countPaged(@Param("search") JobPosition search, @Param("exact") boolean exact);

    List<JobPosition> searchPaged(
            @Param("search") JobPosition search, @Param("pageable") Pageable pageable, @Param("exact") boolean exact);

    @Select(
            "SELECT EXISTS(SELECT 1 FROM job_position WHERE upper(jobcode)=upper(#{jobcode}) OR upper(jobname)=upper(#{jobname}))")
    boolean existsByJobcodeORJobname(@Param("jobcode") String jobcode, @Param("jobname") String jobname);

    @Select(
            "SELECT EXISTS(SELECT 1 FROM job_position WHERE upper(jobcode)!=upper(#{jobcode}) AND upper(jobname)=upper(#{jobname}))")
    boolean existsByJobNameAndDifferentJobCode(@Param("jobname") String jobname, @Param("jobcode") String jobcode);
}
