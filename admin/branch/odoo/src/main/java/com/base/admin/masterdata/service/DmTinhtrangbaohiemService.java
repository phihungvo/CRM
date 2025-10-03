/**
 * @mbg.generated generator on Fri Mar 22 12:34:29 ICT 2024
 */
package com.base.admin.masterdata.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.base.admin.masterdata.entity.DmTinhtrangbaohiem;

public interface DmTinhtrangbaohiemService {
    int deleteByPrimaryKey(Integer id);

    int insert(DmTinhtrangbaohiem row);

    int insertSelective(DmTinhtrangbaohiem row);

    DmTinhtrangbaohiem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DmTinhtrangbaohiem row);

    int updateByPrimaryKey(DmTinhtrangbaohiem row);

    Page<DmTinhtrangbaohiem> searchPaged(DmTinhtrangbaohiem search, Pageable pageable, boolean exact);
}
