package com.base.admin.hrm.mapper;

import com.base.admin.hrm.dto.TerminationsDTO;
import com.base.admin.hrm.entity.Terminations;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

@Mapper
public interface TerminationsMapper {
    int deleteByPrimaryKey(UUID terminationid);

    int insert(Terminations record);

    int insertSelective(Terminations record);

    Terminations selectByPrimaryKey(UUID terminationid);

    int updateByPrimaryKeySelective(Terminations record);

    int updateByPrimaryKey(Terminations record);

    TerminationsDTO findById(@Param("terminationid") UUID terminationid);

    List<TerminationsDTO> searchPaged(@Param("search") TerminationsDTO search, @Param("pageable") Pageable pageable, @Param("exact") boolean exact);

    long countPaged(@Param("search") TerminationsDTO search, @Param("exact") boolean exact);

    @Select("SELECT EXISTS(SELECT 1 FROM terminations WHERE terminationid=#{terminationid,jdbcType=OTHER,typeHandler=UUIDTypeHandler})")
    boolean existsById(@Param("terminationid") UUID terminationid);

    int deleteByPrimaryKeys(List<UUID> listTerminationids);
}
