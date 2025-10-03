/**
 * @mbg.generated generator on Fri Mar 22 12:34:29 ICT 2024
 */
package com.base.admin.masterdata.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.base.admin.masterdata.entity.DmLoaigiayto;

public interface DmLoaigiaytoService {
    int deleteByPrimaryKey(Integer id);

    int insert(DmLoaigiayto row);

    int insertSelective(DmLoaigiayto row);

    DmLoaigiayto selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DmLoaigiayto row);

    int updateByPrimaryKey(DmLoaigiayto row);

    Page<DmLoaigiayto> searchPaged(DmLoaigiayto search, Pageable pageable, boolean exact);
}
