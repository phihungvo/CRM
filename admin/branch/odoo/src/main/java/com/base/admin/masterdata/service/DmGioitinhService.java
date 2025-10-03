/**
 * @mbg.generated generator on Fri Mar 22 12:34:29 ICT 2024
 */
package com.base.admin.masterdata.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.base.admin.masterdata.entity.DmGioitinh;

public interface DmGioitinhService {
    int deleteByPrimaryKey(Integer id);

    int insert(DmGioitinh row);

    int insertSelective(DmGioitinh row);

    DmGioitinh selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DmGioitinh row);

    int updateByPrimaryKey(DmGioitinh row);

    Page<DmGioitinh> searchPaged(DmGioitinh search, Pageable pageable, boolean exact);
}
