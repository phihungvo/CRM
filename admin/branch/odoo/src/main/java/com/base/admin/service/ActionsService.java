/**
 * @mbg.generated generator on Tue Apr 02 16:25:57 ICT 2024
 */
package com.base.admin.service;

import java.util.UUID;

import com.base.admin.entity.Actions;

public interface ActionsService {
    int deleteByPrimaryKey(UUID actionid, UUID resourceid);

    int insert(Actions row);

    int insertSelective(Actions row);

    Actions selectByPrimaryKey(UUID actionid, UUID resourceid);

    int updateByPrimaryKeySelective(Actions row);

    int updateByPrimaryKey(Actions row);
}
