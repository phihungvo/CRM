/**
 * @mbg.generated generator on Fri Mar 22 13:18:31 ICT 2024
 */
package com.base.admin.hrm.service;

import com.base.admin.hrm.dto.EmployeesDTO;
import com.base.admin.hrm.entity.Avatars;
import com.base.admin.hrm.entity.Employees;
import com.base.admin.hrm.mapper.AvatarsMapper;
import com.base.admin.hrm.mapper.EmployeesMapper;
import com.base.admin.utils.ClassUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeesServiceImpl implements EmployeesService {
    private final EmployeesMapper employeesMapper;

    private final AvatarsMapper avatarsMapper;

    public EmployeesServiceImpl(EmployeesMapper employeesMapper, AvatarsMapper avatarsMapper) {
        this.employeesMapper = employeesMapper;
        this.avatarsMapper = avatarsMapper;
    }

    @Override
    public boolean existsById(UUID employeeid) {
        return employeesMapper.existsById(employeeid);
    }

    @Override
    public boolean existsByUserId(UUID userid) {
        return employeesMapper.existsByUserId(userid);
    }


    @Override
    public boolean existsByFullname(String fullname) {
        return employeesMapper.existsByFullname(fullname);
    }

    @Override
    public boolean existsByEmployeeCodeAndDifferentEmployeeId(String employeecode, UUID employeeid) {
        return employeesMapper.existsByEmployeeCodeAndDifferentEmployeeId(employeecode, employeeid);
    }

    @Override
    public EmployeesDTO findDTOById(UUID employeeid) {
        return employeesMapper.findDTOById(employeeid);
    }

    @Override
    public Page<EmployeesDTO> searchPaged(EmployeesDTO search, Pageable pageable, boolean exact) {
        long total = 0;
        List<EmployeesDTO> content = employeesMapper.searchPaged(search, pageable, exact);
        if (!content.isEmpty()) {
            total = employeesMapper.countPaged(search, exact);
        }
        return new PageImpl<>(content, pageable, total);
    }

    @Override
    public int addEmployeeDTO(EmployeesDTO employeesDTO) {
        Employees employee = employeesDTO.newEntity();
        return employeesMapper.insert(employee);
    }

    @Override
    public int update(EmployeesDTO employeesDTO) {
        Employees employee = employeesMapper.findById(employeesDTO.getEmployeeid());
        if (employee != null) {
            employee = (Employees) ClassUtils.convertDTOToEntity(employeesDTO, employee);
            return employeesMapper.updateByPrimaryKey(employee);
        }
        return 0;
    }

    @Override
    public int deleteById(UUID employeeid) {
        return employeesMapper.deleteByPrimaryKey(employeeid);
    }

    @Override
    public int deleteByIds(List<UUID> deleteByIds) {
        return employeesMapper.deleteByPrimaryKeys(deleteByIds);
    }

    @Override
    public boolean existsByEmployeeCode(String employeecode) {
        return employeesMapper.existsByEmployeeCode(employeecode);
    }

    @Override
    public int addOrupdateAvatar(UUID userid, String filename, String imageAsString) {
        Avatars avatars = avatarsMapper.selectByPrimaryKey(userid);
        if (avatars != null) {
            avatars.setFilename(filename);
            avatars.setBase64avatar(imageAsString);
            return avatarsMapper.updateByPrimaryKey(avatars);
        }
        avatars = new Avatars(userid, filename, imageAsString);
        return avatarsMapper.insert(avatars);
    }

    @Override
    public int removeAvatar(UUID userid) {
        return avatarsMapper.deleteByPrimaryKey(userid);
    }
//
//    @Override
//    public int deleteByPrimaryKey(UUID employeeid) {
//        return employeesMapper.deleteByPrimaryKey(employeeid);
//    }
//
//    @Override
//    public int insert(Employees row) {
//        return employeesMapper.insert(row);
//    }
//
//    @Override
//    public int insertSelective(Employees row) {
//        return employeesMapper.insertSelective(row);
//    }
//
//    @Override
//    public Employees selectByPrimaryKey(UUID employeeid) {
//        return employeesMapper.selectByPrimaryKey(employeeid);
//    }
//
//    @Override
//    public int updateByPrimaryKeySelective(Employees row) {
//        return employeesMapper.updateByPrimaryKeySelective(row);
//    }
//
//    @Override
//    public int updateByPrimaryKey(Employees row) {
//        return employeesMapper.updateByPrimaryKey(row);
//    }
}
