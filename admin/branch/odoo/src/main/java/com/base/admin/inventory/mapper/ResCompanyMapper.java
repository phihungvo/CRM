package com.base.admin.inventory.mapper;

import java.util.List;
import java.util.UUID;

import com.base.admin.inventory.entity.ResCompany;

public interface ResCompanyMapper {
    List<ResCompany> getAll();

    int deleteByPrimaryKey(UUID id);

    int insert(ResCompany record);

    int insertSelective(ResCompany record);

    ResCompany selectByPrimaryKey(UUID id);

    int updateByPrimaryKeySelective(ResCompany record);

    int updateByPrimaryKey(ResCompany record);
}
