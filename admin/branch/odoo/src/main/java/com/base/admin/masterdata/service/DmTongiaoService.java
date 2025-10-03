/**
 * @mbg.generated generator on Fri Mar 22 12:34:30 ICT 2024
 */
package com.base.admin.masterdata.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.base.admin.masterdata.entity.DmTongiao;

public interface DmTongiaoService {
    int deleteByPrimaryKey(Integer id);

    int insert(DmTongiao row);

    int insertSelective(DmTongiao row);

    DmTongiao selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DmTongiao row);

    int updateByPrimaryKey(DmTongiao row);

    Page<DmTongiao> searchPaged(DmTongiao search, Pageable pageable, boolean exact);
}
