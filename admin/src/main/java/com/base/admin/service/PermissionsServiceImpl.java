/**
 * @mbg.generated generator on Tue Apr 02 20:12:52 ICT 2024
 */
package com.base.admin.service;

import com.base.admin.entity.Permissions;
import com.base.admin.mapper.PermissionsMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PermissionsServiceImpl implements PermissionsService {
    private final PermissionsMapper permissionsMapper;

    public PermissionsServiceImpl(PermissionsMapper permissionsMapper) {
        this.permissionsMapper = permissionsMapper;
    }

    @Override
    public int deleteByPrimaryKey(UUID roleid, UUID moduleid, UUID pageid, UUID actionid) {
        return permissionsMapper.deleteByPrimaryKey(roleid, moduleid, pageid, actionid);
    }

    @Override
    public int insert(Permissions row) {
        return permissionsMapper.insert(row);
    }

    @Override
    public int insertSelective(Permissions row) {
        return permissionsMapper.insertSelective(row);
    }
}