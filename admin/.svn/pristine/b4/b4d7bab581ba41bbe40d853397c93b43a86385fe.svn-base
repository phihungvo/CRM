package com.base.admin.hrm.mapper;

import com.base.admin.hrm.dto.TerminationReasonDTO;
import com.base.admin.hrm.entity.TerminationReason;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Mapper
public interface TerminationReasonMapper {
    int deleteByPrimaryKey(Integer terminationreasonid);

    int insert(TerminationReason record);

    int insertSelective(TerminationReason record);

    TerminationReason selectByPrimaryKey(Integer terminationreasonid);

    int updateByPrimaryKeySelective(TerminationReason record);

    int updateByPrimaryKey(TerminationReason record);

    TerminationReasonDTO findById(@Param("terminationreasonid") Integer terminationreasonid);

    long countPaged();

    List<TerminationReasonDTO> searchPaged(@Param("pageable") Pageable pageable);
}