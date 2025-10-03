package com.base.admin.masterdata.service;

import com.base.admin.masterdata.entity.DmNganhang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DmNganhangService {
    int deleteByPrimaryKey(Integer id);

    int insert(DmNganhang record);

    DmNganhang selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(DmNganhang record);


    Page<DmNganhang> searchPaged(DmNganhang search, Pageable pageable, boolean exact);
}
