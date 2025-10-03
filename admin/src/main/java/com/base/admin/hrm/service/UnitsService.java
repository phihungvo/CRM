/**
 * @mbg.generated generator on Fri Mar 29 11:27:03 ICT 2024
 */
package com.base.admin.hrm.service;

import com.base.admin.hrm.dto.UnitItemDTO;
import com.base.admin.hrm.entity.Units;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface UnitsService {
    int deleteByPrimaryKey(UUID unitid);

    int insert(Units row);

    int insertSelective(Units row);

    Units selectByPrimaryKey(UUID unitid);

    int updateByPrimaryKeySelective(Units row);

    int updateByPrimaryKey(Units row);

    Units findById(UUID unitid);

    Page<Units> searchPaged(Units dto, Pageable pageable, boolean exact);

    int addUnit(Units unitDTO);

    int update(Units unitDTO);

    int deleteById(UUID unitid);

    List<UnitItemDTO> getTreeOfUnits(UUID organizationid);
}