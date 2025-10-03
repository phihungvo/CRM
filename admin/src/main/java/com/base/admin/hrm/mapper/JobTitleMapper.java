package com.base.admin.hrm.mapper;

import com.base.admin.hrm.entity.JobTitle;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Mapper
public interface JobTitleMapper {
    int deleteByPrimaryKey(Integer jobtitleid);

    int insert(JobTitle row);

    int insertSelective(JobTitle row);

    JobTitle selectByPrimaryKey(Integer jobtitleid);

    int updateByPrimaryKeySelective(JobTitle row);

    int updateByPrimaryKey(JobTitle row);

    long countPaged();

    List<JobTitle> searchPaged(@Param("pageable") Pageable pageable);
}