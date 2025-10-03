/**
 * @mbg.generated generator on Tue Apr 02 16:25:57 ICT 2024
 */
package com.base.admin.service;

import com.base.admin.entity.Actions;
import com.base.admin.mapper.ActionsMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ActionsServiceImpl implements ActionsService {
    private final ActionsMapper actionsMapper;

    public ActionsServiceImpl(ActionsMapper actionsMapper) {
        this.actionsMapper = actionsMapper;
    }

    @Override
    public int deleteByPrimaryKey(UUID actionid, UUID resourceid) {
        return actionsMapper.deleteByPrimaryKey(actionid, resourceid);
    }

    @Override
    public int insert(Actions row) {
        return actionsMapper.insert(row);
    }

    @Override
    public int insertSelective(Actions row) {
        return actionsMapper.insertSelective(row);
    }

    @Override
    public Actions selectByPrimaryKey(UUID actionid, UUID resourceid) {
        return actionsMapper.selectByPrimaryKey(actionid, resourceid);
    }

    @Override
    public int updateByPrimaryKeySelective(Actions row) {
        return actionsMapper.updateByPrimaryKeySelective(row);
    }

    @Override
    public int updateByPrimaryKey(Actions row) {
        return actionsMapper.updateByPrimaryKey(row);
    }
}