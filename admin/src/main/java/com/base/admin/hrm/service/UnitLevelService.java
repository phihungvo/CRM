/**
 * @mbg.generated generator on Wed Mar 27 21:29:22 ICT 2024
 */
package com.base.admin.hrm.service;

import com.base.admin.hrm.entity.UnitLevel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UnitLevelService {
    int deleteByPrimaryKey(Integer unitlevelid);

    int insert(UnitLevel row);

    int insertSelective(UnitLevel row);

    UnitLevel selectByPrimaryKey(Integer unitlevelid);

    int updateByPrimaryKeySelective(UnitLevel row);

    int updateByPrimaryKey(UnitLevel row);

    UnitLevel findById(Integer unitlevelid);

    Page<UnitLevel> searchPaged(Integer level, Pageable pageable);
}