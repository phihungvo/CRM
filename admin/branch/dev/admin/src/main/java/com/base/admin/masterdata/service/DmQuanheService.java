/**
 * @mbg.generated generator on Fri Mar 22 12:34:29 ICT 2024
 */
package com.base.admin.masterdata.service;

import com.base.admin.masterdata.entity.DmQuanhe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DmQuanheService {
    int deleteByPrimaryKey(Integer id);

    int insert(DmQuanhe row);

    int insertSelective(DmQuanhe row);

    DmQuanhe selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DmQuanhe row);

    int updateByPrimaryKey(DmQuanhe row);

    Page<DmQuanhe> searchPaged(DmQuanhe search, Pageable pageable, boolean exact);
}