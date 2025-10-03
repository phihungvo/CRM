/**
 * @mbg.generated generator on Wed Mar 06 09:21:37 ICT 2024
 */
package com.base.admin.service;

import com.base.admin.constant.ApiRole;
import com.base.admin.constant.ModuleType;
import com.base.admin.dto.ModulesDTO;
import com.base.admin.dto.PagesDTO;
import com.base.admin.entity.*;
import com.base.admin.mapper.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ModulesServiceImpl implements ModulesService {
    private final ModulesMapper modulesMapper;
    private final RolesMapper rolesMapper;
    private final RolesModulesMapper rolesModulesMapper;
    private final RolemodulepageMapper rolemodulepageMapper;

    private final PagesMapper pagesMapper;
    private final RolemodulepageService rolemodulepageService;
    private final PermissionsMapper permissionsMapper;

    public ModulesServiceImpl(ModulesMapper modulesMapper, RolesMapper rolesMapper, RolesModulesMapper rolesModulesMapper, RolemodulepageMapper rolemodulepageMapper, PagesMapper pagesMapper, RolemodulepageService rolemodulepageService, PermissionsMapper permissionsMapper) {
        this.modulesMapper = modulesMapper;
        this.rolesMapper = rolesMapper;
        this.rolesModulesMapper = rolesModulesMapper;
        this.rolemodulepageMapper = rolemodulepageMapper;
        this.pagesMapper = pagesMapper;
        this.rolemodulepageService = rolemodulepageService;
        this.permissionsMapper = permissionsMapper;
    }

    @Override
    public boolean existsByListUserId(List<UUID> moduleids) {
        long count = modulesMapper.countByListModuleId(moduleids);
        return count == moduleids.size();
    }

    @Override
    public ModulesDTO findDTOById(UUID moduleid) {
        return modulesMapper.findDTOById(moduleid);
    }

    @Override
    public Page<ModulesDTO> searchPaged(ModulesDTO search, Pageable pageable, boolean exact) {
        long total = 0;
        List<ModulesDTO> content = modulesMapper.searchPaged(search, pageable, exact);
        if (!content.isEmpty()) {
            total = modulesMapper.countPaged(search, exact);
        }
        return new PageImpl<>(content, pageable, total);
    }

    @Override
    public List<ModulesDTO> findByRoleId(UUID roleId) {
        return modulesMapper.findByRoleId(roleId);
    }

    @Override
    public List<PagesDTO> findMenuItemByRoleIdAndModuleId(UUID roleId, UUID moduleId) {
        List<PagesDTO> pages = pagesMapper.findMenuItemByRoleIdAndModuleId(roleId, moduleId);

        return pages;//recursiveMenuItem(pages, null);
    }

    private List<PagesDTO> recursiveMenuItem(List<PagesDTO> pages, UUID parent) {
//        if (!pages.isEmpty()) {
//            List<PagesDTO> menus = GetPageSameLevelAndSort(pages, parent);
//            if (!menus.isEmpty()) {
//                for (PagesDTO menu : menus) {
//                    if (isHasChildren(pages, menu.getPageid())) {
//                        menu.setChildMenu(recursiveMenuItem(pages, menu.getPageid()));
//                    }
//                }
//                return menus;
//            }
//        }
        return null;
    }

    private List<PagesDTO> GetPageSameLevelAndSort(List<PagesDTO> pages, UUID parent) {
        List<PagesDTO> pagesSameParent = pages.parallelStream().filter(page ->
                        ((page.getParentpageid() == null && parent == null) ||
                                ((page.getParentpageid() != null && parent != null) && page.getParentpageid().equals(parent))
                        ))
                .sorted(Comparator.comparing(PagesDTO::getPosition)).collect(Collectors.toList());

        if (!pagesSameParent.isEmpty()) {
            pages.removeAll(pagesSameParent);
        }

        return pagesSameParent;
    }

    private boolean isHasChildren(List<PagesDTO> pages, UUID parent) {
        return pages.parallelStream()
                .anyMatch(page -> (
                        page.getParentpageid().equals(parent)));
    }

    @Override
    public int selecttedMenuItem(UUID roleId, UUID moduleId, UUID pageId, boolean isselected) {
        Rolemodulepage rolemodulepage = new Rolemodulepage(roleId, moduleId, pageId, isselected);
        if (isselected) {
            rolemodulepageService.addModuleForRole(roleId, moduleId);
        } else {
            rolemodulepageService.removeModuleForRole(roleId, moduleId);
        }
        return rolemodulepageMapper.updateFieldSelectted(rolemodulepage);

    }

    @Override
    public int updatePermission(List<Permissions> permissions) {
        return permissionsMapper.updateListPermission(permissions);
    }


//    @Override
//    public int deleteById(UUID moduleid) {
//        return modulesMapper.deleteById(moduleid);
//    }
//
//    @Override
//    public int insert(Modules row) {
//        return modulesMapper.insert(row);
//    }
//
//
//    @Override
//    public Modules findById(UUID moduleid) {
//        return modulesMapper.findById(moduleid);
//    }
//
//
//    @Override
//    public int update(Modules row) {
//        return modulesMapper.update(row);
//    }

    @Override
    public boolean initializeModules() {
        try {
            modulesMapper.deleteAll();
            rolesModulesMapper.deleteAll();
            List<Roles> rolesAll = rolesMapper.findAll();

            List<Modules> modules = new ArrayList<Modules>();
            List<Roles> roles = new ArrayList<Roles>();
            List<RolesModules> rolesModules = new ArrayList<RolesModules>();


            Modules module = new Modules(UUID.randomUUID(), "Default", "Default", ModuleType.PUBLIC.getValue(), 0);
            modules.add(module);
            AddRoleForModule(module, getRole(rolesAll, ApiRole.SUPER_ADMIN.toString()), roles, rolesModules);
            AddRoleForModule(module, getRole(rolesAll, ApiRole.ADMIN.toString()), roles, rolesModules);
            AddRoleForModule(module, getRole(rolesAll, ApiRole.USER.toString()), roles, rolesModules);

            module = new Modules(UUID.randomUUID(), "Applications", "Applications", ModuleType.PUBLIC.getValue(), 1);
            modules.add(module);
//            AddRoleForModule(module, getRole(rolesAll, ApiRole.USER.toString()), roles, rolesModules);
            AddRoleForModule(module, getRole(rolesAll, ApiRole.SUPER_ADMIN.toString()), roles, rolesModules);
            AddRoleForModule(module, getRole(rolesAll, ApiRole.ADMIN.toString()), roles, rolesModules);
            AddRoleForModule(module, getRole(rolesAll, ApiRole.USER.toString()), roles, rolesModules);

            module = new Modules(UUID.randomUUID(), "Inventory", "Inventory", ModuleType.USER.getValue(), 2);
            modules.add(module);
            AddRoleForModule(module, getRole(rolesAll, ApiRole.USER.toString()), roles, rolesModules);

            module = new Modules(UUID.randomUUID(), "HRM", "HRM", ModuleType.USER.getValue(), 3);
            modules.add(module);
            AddRoleForModule(module, getRole(rolesAll, ApiRole.USER.toString()), roles, rolesModules);

            module = new Modules(UUID.randomUUID(), "Admin", "Admin", ModuleType.ADMIN.getValue(), 98);
            modules.add(module);
            AddRoleForModule(module, getRole(rolesAll, ApiRole.SUPER_ADMIN.toString()), roles, rolesModules);
            AddRoleForModule(module, getRole(rolesAll, ApiRole.ADMIN.toString()), roles, rolesModules);

            module = new Modules(UUID.randomUUID(), "SuperAdmin", "SuperAdmin", ModuleType.SUPER_ADMIN.getValue(), 99);
            modules.add(module);
            AddRoleForModule(module, getRole(rolesAll, ApiRole.SUPER_ADMIN.toString()), roles, rolesModules);

            modulesMapper.saveAll(modules);
            rolesModulesMapper.saveAll(rolesModules);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    private void AddRoleForModule(Modules module, Roles role, List<Roles> roles, List<RolesModules> rolesModules) {
        roles.add(role);
        rolesModules.add(new RolesModules(role.getRoleid(), module.getModuleid()));
    }

    //    private fuctions
    private Roles getRole(List<Roles> roles, String rolename) {
        Roles role = roles.parallelStream()
                .filter(s -> s.getRolename().equalsIgnoreCase(rolename))
                .findAny()
                .orElse(null);

        return role;
    }
}