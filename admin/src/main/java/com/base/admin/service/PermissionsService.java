/**
 * @mbg.generated generator on Tue Apr 02 20:12:52 ICT 2024
 */
package com.base.admin.service;

import com.base.admin.entity.Permissions;

import java.util.UUID;

public interface PermissionsService {
    int deleteByPrimaryKey(UUID roleid, UUID moduleid, UUID pageid, UUID actionid);

    int insert(Permissions row);

    int insertSelective(Permissions row);
}