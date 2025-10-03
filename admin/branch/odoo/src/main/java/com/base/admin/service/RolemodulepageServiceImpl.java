/**
 * @mbg.generated generator on Mon Apr 01 14:57:31 ICT 2024
 */
package com.base.admin.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.base.admin.entity.Pages;
import com.base.admin.entity.Permissions;
import com.base.admin.entity.Rolemodulepage;
import com.base.admin.entity.RolesModules;
import com.base.admin.mapper.*;

@Service
public class RolemodulepageServiceImpl implements RolemodulepageService {
    private final RolemodulepageMapper rolemodulepageMapper;
    private final RolesModulesMapper rolesModulesMapper;
    private final PagesMapper pagesMapper;
    private final ActionsMapper actionsMapper;
    private final PermissionsMapper permissionsMapper;

    public RolemodulepageServiceImpl(
            RolemodulepageMapper rolemodulepageMapper,
            RolesModulesMapper rolesModulesMapper,
            PagesMapper pagesMapper,
            ActionsMapper actionsMapper,
            PermissionsMapper permissionsMapper) {
        this.rolemodulepageMapper = rolemodulepageMapper;
        this.rolesModulesMapper = rolesModulesMapper;
        this.pagesMapper = pagesMapper;
        this.actionsMapper = actionsMapper;
        this.permissionsMapper = permissionsMapper;
    }

    @Override
    public int deleteByPrimaryKey(UUID roleid, UUID moduleid, UUID pageid) {
        return rolemodulepageMapper.deleteByPrimaryKey(roleid, moduleid, pageid);
    }

    @Override
    public int insert(Rolemodulepage row) {
        return rolemodulepageMapper.insert(row);
    }

    @Override
    public int insertSelective(Rolemodulepage row) {
        return rolemodulepageMapper.insertSelective(row);
    }

    @Override
    public void initializeRoleModulePage() {
        rolemodulepageMapper.deleteAll();
        permissionsMapper.deleteAll();
        List<Rolemodulepage> list = new ArrayList<>();
        List<Permissions> permissionsList = new ArrayList<>();
        List<RolesModules> rolesModulesList = rolesModulesMapper.findAll();
        rolesModulesList.forEach(
                rolesModules -> addPermissionAndRelationshipRoleModule(rolesModules, list, permissionsList));
        rolemodulepageMapper.saveAll(list);
        permissionsMapper.saveAll(permissionsList);
    }

    public int addModuleForRole(UUID roleId, UUID moduleId) {
        try {
            RolesModules rolesModules = new RolesModules(roleId, moduleId);
            if (!rolesModulesMapper.existsById(roleId, moduleId)) {
                List<Rolemodulepage> list = new ArrayList<>();
                List<Permissions> permissionsList = new ArrayList<>();
                addPermissionAndRelationshipRoleModule(rolesModules, list, permissionsList);
                rolemodulepageMapper.saveAll(list);
                return permissionsMapper.saveAll(permissionsList);
                //                 rolesModulesMapper.insert(rolesModules);
            }
        } catch (Exception e) {
            e.printStackTrace();
            removeModuleForRole(roleId, moduleId);
        }
        return 0;
    }

    private void addPermissionAndRelationshipRoleModule(
            RolesModules rolesModules, List<Rolemodulepage> list, List<Permissions> permissionsList) {
        List<Pages> pages = pagesMapper.findByModuleId(rolesModules.getModuleid());
        pages.forEach(page -> {
            Rolemodulepage rolemodulepage = new Rolemodulepage();
            rolemodulepage.setRoleid(rolesModules.getRoleid());
            rolemodulepage.setModuleid(rolesModules.getModuleid());
            rolemodulepage.setIsselected(true);
            rolemodulepage.setPageid(page.getPageid());
            list.add(rolemodulepage);
            List<UUID> actionIds = actionsMapper.findActionIdByResourceid(page.getPageid());
            actionIds.forEach(actionId -> {
                Permissions permissions = new Permissions();
                permissions.setRoleid(rolesModules.getRoleid());
                permissions.setModuleid(rolesModules.getModuleid());
                permissions.setPageid(page.getPageid());
                permissions.setIsselected(true);
                permissions.setActionid(actionId);
                permissionsList.add(permissions);
            });
        });
    }

    public int removeModuleForRole(UUID roleId, UUID moduleId) {
        if (rolesModulesMapper.existsById(roleId, moduleId)) {
            int count = permissionsMapper.deleteByRoleIdAndModuleId(roleId, moduleId);
            count = rolemodulepageMapper.deleteByRoleIdAndModuleId(roleId, moduleId);
            //            count = rolesModulesMapper.deleteById(roleId, moduleId);
            return count;
        }
        return 0;
    }
}
