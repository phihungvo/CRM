/**
 * @mbg.generated generator on Fri Mar 22 12:34:30 ICT 2024
 */
package com.base.admin.masterdata.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.base.admin.masterdata.entity.DmTrinhdodaotao;

public interface DmTrinhdodaotaoService {
    int deleteByPrimaryKey(Integer id);

    int insert(DmTrinhdodaotao row);

    int insertSelective(DmTrinhdodaotao row);

    DmTrinhdodaotao selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DmTrinhdodaotao row);

    int updateByPrimaryKey(DmTrinhdodaotao row);

    Page<DmTrinhdodaotao> searchPaged(DmTrinhdodaotao search, Pageable pageable, boolean exact);
}
