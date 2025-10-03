/**
 * @mbg.generated generator on Fri Mar 22 12:34:29 ICT 2024
 */
package com.base.admin.masterdata.service;

import com.base.admin.masterdata.entity.DmLoaihopdong;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DmLoaihopdongService {
    int deleteByPrimaryKey(Integer id);

    int insert(DmLoaihopdong row);

    int insertSelective(DmLoaihopdong row);

    DmLoaihopdong selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DmLoaihopdong row);

    int updateByPrimaryKey(DmLoaihopdong row);

    Page<DmLoaihopdong> searchPaged(DmLoaihopdong search, Pageable pageable, boolean exact);
}