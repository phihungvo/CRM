/**
 * @mbg.generated generator on Fri Mar 22 12:34:29 ICT 2024
 */
package com.base.admin.masterdata.service;

import com.base.admin.masterdata.entity.DmTinhtranghonnhan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DmTinhtranghonnhanService {
    int deleteByPrimaryKey(Integer id);

    int insert(DmTinhtranghonnhan row);

    int insertSelective(DmTinhtranghonnhan row);

    DmTinhtranghonnhan selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DmTinhtranghonnhan row);

    int updateByPrimaryKey(DmTinhtranghonnhan row);

    Page<DmTinhtranghonnhan> searchPaged(DmTinhtranghonnhan search, Pageable pageable, boolean exact);
}