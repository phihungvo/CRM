/**
 * @mbg.generated generator on Fri Mar 22 12:34:29 ICT 2024
 */
package com.base.admin.masterdata.service;

import com.base.admin.masterdata.entity.DmTinhchatlaodong;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DmTinhchatlaodongService {
    int deleteByPrimaryKey(Integer id);

    int insert(DmTinhchatlaodong row);

    int insertSelective(DmTinhchatlaodong row);

    DmTinhchatlaodong selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DmTinhchatlaodong row);

    int updateByPrimaryKey(DmTinhchatlaodong row);

    Page<DmTinhchatlaodong> searchPaged(DmTinhchatlaodong search, Pageable pageable, boolean exact);
}