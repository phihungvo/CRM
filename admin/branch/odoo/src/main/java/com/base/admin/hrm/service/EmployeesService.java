/**
 * @mbg.generated generator on Fri Mar 22 13:18:31 ICT 2024
 */
package com.base.admin.hrm.service;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.base.admin.hrm.dto.EmployeesDTO;

public interface EmployeesService {
    boolean existsById(UUID employeeid);

    boolean existsByUserId(UUID userid);

    boolean existsByFullname(String fullname);

    boolean existsByEmployeeCodeAndDifferentEmployeeId(String employeecode, UUID employeeid);

    EmployeesDTO findDTOById(UUID employeeid);

    Page<EmployeesDTO> searchPaged(EmployeesDTO dto, Pageable pageable, boolean exact);

    int addEmployeeDTO(EmployeesDTO employeesDTO);

    int update(EmployeesDTO employeesDTO);

    int deleteById(UUID employeeid);

    int deleteByIds(List<UUID> deleteByIds);

    boolean existsByEmployeeCode(String employeecode);

    int addOrupdateAvatar(UUID userid, String filename, String imageAsString);

    int removeAvatar(UUID userid);

    //
    //    Page<UsersDTO> searchPaged(UsersDTO search, Pageable pageable, boolean exact);
    //
    //    Page<UsersDTO> searchPagedWithOrganizationId(UsersDTO search, Pageable pageable, UUID organizationid, boolean
    // exact);
    //
    //    Page<UsersDTO> searchPagedWithGroupId(UsersDTO search, Pageable pageable, UUID groupid, boolean exact);
    ////    int insert(Users user);
    //
    //    int addUsersDTO(UsersDTO dto);
    //
    ////    int update(Users row);
    //
    //    int update(UsersDTO dto);
    //
    //
    //    int deleteById(UUID userid);
    //
    //    int deleteListByIds(List<UUID> list);

    //    int deleteByPrimaryKey(UUID employeeid);
    //
    //    int insert(Employees row);
    //
    //    int insertSelective(Employees row);
    //
    //    Employees selectByPrimaryKey(UUID employeeid);
    //
    //    int updateByPrimaryKeySelective(Employees row);
    //
    //    int updateByPrimaryKey(Employees row);
}
