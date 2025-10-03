/**
 * @mbg.generated generator on Fri Mar 22 12:34:30 ICT 2024
 */
package com.base.admin.masterdata.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.base.admin.masterdata.entity.DmTrangthailamviec;

public interface DmTrangthailamviecService {
    int deleteByPrimaryKey(Integer id);

    int insert(DmTrangthailamviec row);

    int insertSelective(DmTrangthailamviec row);

    DmTrangthailamviec selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DmTrangthailamviec row);

    int updateByPrimaryKey(DmTrangthailamviec row);

    Page<DmTrangthailamviec> searchPaged(DmTrangthailamviec search, Pageable pageable, boolean exact);
}
