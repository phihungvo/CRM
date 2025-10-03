/**
 * @mbg.generated generator on Fri Mar 22 12:34:29 ICT 2024
 */
package com.base.admin.masterdata.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.base.admin.masterdata.entity.DmThanhphangiadinh;

public interface DmThanhphangiadinhService {
    int deleteByPrimaryKey(Integer id);

    int insert(DmThanhphangiadinh row);

    int insertSelective(DmThanhphangiadinh row);

    DmThanhphangiadinh selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DmThanhphangiadinh row);

    int updateByPrimaryKey(DmThanhphangiadinh row);

    Page<DmThanhphangiadinh> searchPaged(DmThanhphangiadinh search, Pageable pageable, boolean exact);
}
