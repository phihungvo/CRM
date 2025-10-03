package com.base.admin.service;

import com.base.admin.constant.MenuDefault;
import com.base.admin.dto.MenuInitDTO;
import com.base.admin.dto.PermissionsDTO;
import com.base.admin.dto.authentication.MenuDTO;
import com.base.admin.entity.Actions;
import com.base.admin.entity.Modules;
import com.base.admin.entity.Pages;
import com.base.admin.mapper.ActionsMapper;
import com.base.admin.mapper.ModulesMapper;
import com.base.admin.mapper.PagesMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.*;
import java.util.stream.Collectors;

//https://github.com/AnghelLeonard/Hibernate-SpringBoot/blob/master/HibernateSpringBootBatchInsertOrderBatchPerTransaction/src/main/java/com/bookstore/service/BookstoreService.java

@Service
public class MenuServiceImpl implements MenuService {
    private final PagesMapper pagesMapper;
    private final ModulesMapper modulesMapper;
    private final ActionsMapper actionsMapper;

    public MenuServiceImpl(PagesMapper pagesMapper, ModulesMapper modulesMapper, ActionsMapper actionsMapper) {
        this.pagesMapper = pagesMapper;
        this.modulesMapper = modulesMapper;
        this.actionsMapper = actionsMapper;
    }

    @Override
    public List<MenuDTO> getUserMenu(UUID userid, UUID organizationid) {
        List<MenuDTO> pages = pagesMapper.getUserMenuForOrganization(userid, organizationid);
        if (pages.size() == 0) {
            pages = pagesMapper.getUserMenuForOrganizationNormal(userid, organizationid);
        }
        List<PermissionsDTO> listpermisions = pagesMapper.getMenuPermission(userid, organizationid);
        List<MenuDTO> menus = recursiveMenuItem(pages, listpermisions, null);
        return menus;
    }


    @Override
    public boolean initializeMenus() {
        try {
            Gson gson = new Gson();
            Type userListType = new TypeToken<ArrayList<MenuInitDTO>>() {
            }.getType();
            ArrayList<MenuInitDTO> menus = gson.fromJson(MenuDefault.jsonMenu, userListType);
            List<Pages> pages = new ArrayList<>();
            List<Actions> actions = new ArrayList<>();

            actionsMapper.deleteAll();
            pagesMapper.deleteAll();
            List<Modules> modules = modulesMapper.findAll();
            generateMenuTree(modules, pages, menus, actions, null);
            pagesMapper.saveAll(pages);
            actionsMapper.saveAll(actions);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    //private functions
    private List<MenuDTO> GetPageSameLevelAndSort(List<MenuDTO> pages, UUID parent) {
        List<MenuDTO> pagesSameParent = pages.parallelStream().filter(page ->
                        ((page.getParentpageid() == null && parent == null) ||
                                ((page.getParentpageid() != null && parent != null) && page.getParentpageid().equals(parent))
                        ))
                .sorted(Comparator.comparing(MenuDTO::getPosition)).collect(Collectors.toList());

        if (!pagesSameParent.isEmpty()) {
            pages.removeAll(pagesSameParent);
        }

        return pagesSameParent;
    }

    private boolean isHasChildren(List<MenuDTO> pages, UUID parent) {
        return pages.parallelStream()
                .anyMatch(page -> (
                        page.getParentpageid().equals(parent)));
    }

    private List<PermissionsDTO> fillterPermission(List<PermissionsDTO> pages, MenuDTO menu) {
        List<PermissionsDTO> pagesSameParent = pages.parallelStream().filter(page ->
                        ((page.getRoleid().equals(menu.getRoleid()) && page.getModuleid().equals(menu.getModuleid()) && page.getPageid().equals(menu.getPageid()))
                        ))
                .collect(Collectors.toList());

        if (!pagesSameParent.isEmpty()) {
            pages.removeAll(pagesSameParent);
        }

        return pagesSameParent;
    }

    private List<MenuDTO> recursiveMenuItem(List<MenuDTO> pages, List<PermissionsDTO> listpermisions, UUID parent) {
        if (!pages.isEmpty()) {
            List<MenuDTO> menus = GetPageSameLevelAndSort(pages, parent);
            if (!menus.isEmpty()) {
                for (MenuDTO menu : menus) {
                    List<PermissionsDTO> permissions = fillterPermission(listpermisions, menu);
                    menu.setPermissions(permissions);
                    if (isHasChildren(pages, menu.getPageid())) {
                        menu.setChildMenu(recursiveMenuItem(pages, listpermisions, menu.getPageid()));
                    }
                }
                return menus;
            }
        }
        return null;
    }

    private UUID moduleID(List<Modules> modules, String modulename) {
        Modules module = modules.parallelStream()
                .filter(s -> s.getModulename().equalsIgnoreCase(modulename))
                .findAny()
                .orElse(null);
        if (module == null) return null;

        return module.getModuleid();
    }

    private void generateMenuTree(List<Modules> modules, List<Pages> pages, List<MenuInitDTO> menus, List<Actions> actions, UUID parentpageid) {
        int order = 0;
        List<String> actionsListName = Arrays.asList("View", "Create", "Edit", "Delete", "Import", "Export");
        for (MenuInitDTO item : menus) {
            if (item.getId() == null) {
                UUID pageid = UUID.randomUUID();
                UUID moduleid = moduleID(modules, item.getModulename());
                item.setId(pageid);
                Pages page = new Pages(pageid, moduleid, parentpageid, item.getPagename(), item.getHref(), item.getIcon(), "", item.getIstitle(), order++, true);
                pages.add(page);
                if (item.getChildMenu() != null && !item.getChildMenu().isEmpty()) {
                    List<MenuInitDTO> child = item.getChildMenu();
                    generateMenuTree(modules, pages, child, actions, pageid);
                } else {
                    if (!item.getIstitle()) {
                        actionsListName.forEach(action -> {
                            Actions actionItem = new Actions(UUID.randomUUID(), pageid, action, item.getPagename());
                            actions.add(actionItem);
                        });
                    }
                }
            }
        }
    }
}
