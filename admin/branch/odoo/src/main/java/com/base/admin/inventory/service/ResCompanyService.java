package com.base.admin.inventory.service;

import java.util.List;
import java.util.UUID;

import com.base.admin.inventory.dto.request.ResCompanyDTO;
import com.base.admin.inventory.dto.request.ResCompanyUpdateDTO;
import com.base.admin.inventory.entity.ResCompany;

public interface ResCompanyService {
    List<ResCompany> getAll();

    int create(ResCompanyDTO request);

    ResCompany findById(UUID resCompanyId);

    int update(ResCompanyUpdateDTO request);

    int deleteById(UUID id);
}
