package com.base.admin.hrm.mapper;

import com.base.admin.hrm.dto.EmployeesDTO;
import com.base.admin.hrm.entity.Employees;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

@Mapper
public interface EmployeesMapper {
    int deleteByPrimaryKey(UUID employeeid);

    int deleteByPrimaryKeys(List<UUID> listEmployeeid);

    int insert(Employees row);

    int insertSelective(Employees row);

    Employees findById(UUID employeeid);

    int updateByPrimaryKeySelective(Employees row);

    int updateByPrimaryKey(Employees row);

    @Select("SELECT EXISTS(SELECT 1 FROM employees WHERE employeeid=#{employeeid,jdbcType=OTHER,typeHandler=UUIDTypeHandler})")
    boolean existsById(@Param("employeeid") UUID employeeid);

    @Select("SELECT EXISTS(SELECT 1 FROM employees WHERE UPPER(fullname)=UPPER(#{fullname}))")
    boolean existsByFullname(@Param("fullname") String fullname);

    @Select("SELECT EXISTS(SELECT 1 FROM employees WHERE UPPER(employeecode)=UPPER(#{employeecode}) AND employeeid != #{employeeid,jdbcType=OTHER,typeHandler=UUIDTypeHandler})")
    boolean existsByEmployeeCodeAndDifferentEmployeeId(@Param("employeecode") String employeecode, @Param("employeeid") UUID employeeid);

    EmployeesDTO findDTOById(UUID employeeid);

    List<EmployeesDTO> searchPaged(@Param("search") EmployeesDTO search, @Param("pageable") Pageable pageable, @Param("exact") boolean exact);

    long countPaged(@Param("search") EmployeesDTO search, @Param("exact") boolean exact);

    @Select("SELECT EXISTS(SELECT 1 FROM employees WHERE UPPER(employeecode)=UPPER(#{employeecode}))")
    boolean existsByEmployeeCode(@Param("employeecode") String employeecode);

    @Select("SELECT EXISTS(SELECT 1 FROM employees WHERE userid=#{userid,jdbcType=OTHER,typeHandler=UUIDTypeHandler})")
    boolean existsByUserId(UUID userid);
}
