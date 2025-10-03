/**
 * @mbg.generated generator on Fri Mar 22 12:34:29 ICT 2024
 */
package com.base.admin.masterdata.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.base.admin.masterdata.entity.DmDantoc;

public interface DmDantocService {
    Page<DmDantoc> searchPaged(DmDantoc dto, Pageable pageable, boolean exact);

    int deleteByPrimaryKey(Integer id);

    int insert(DmDantoc row);

    int insertSelective(DmDantoc row);

    DmDantoc selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DmDantoc row);

    int updateByPrimaryKey(DmDantoc row);
}
