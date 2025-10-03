/**
 * @mbg.generated generator on Fri Mar 22 12:34:29 ICT 2024
 */
package com.base.admin.masterdata.service;

import com.base.admin.masterdata.entity.DmThanhphancanhan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DmThanhphancanhanService {
    int deleteByPrimaryKey(Integer id);

    int insert(DmThanhphancanhan row);

    int insertSelective(DmThanhphancanhan row);

    DmThanhphancanhan selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DmThanhphancanhan row);

    int updateByPrimaryKey(DmThanhphancanhan row);

    Page<DmThanhphancanhan> searchPaged(DmThanhphancanhan search, Pageable pageable, boolean exact);
}