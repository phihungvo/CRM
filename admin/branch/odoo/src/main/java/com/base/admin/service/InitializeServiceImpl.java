package com.base.admin.service;

import org.springframework.stereotype.Service;

@Service
public class InitializeServiceImpl implements InitializeService {
    private final AuthoritiesService authoritiesService;
    private final RolesService rolesService;
    private final ModulesService moduleService;
    private final MenuService menuService;

    private final OrganizationsService organizationsService;
    private final UsersService usersService;

    private final RolemodulepageService rolemodulepageService;

    public InitializeServiceImpl(
            AuthoritiesService authoritiesService,
            RolesService rolesService,
            ModulesService moduleService,
            MenuService menuService,
            OrganizationsService organizationsService,
            UsersService usersService,
            RolemodulepageService rolemodulepageService) {
        this.authoritiesService = authoritiesService;
        this.rolesService = rolesService;
        this.moduleService = moduleService;
        this.menuService = menuService;
        this.organizationsService = organizationsService;
        this.usersService = usersService;
        this.rolemodulepageService = rolemodulepageService;
    }

    @Override
    public boolean initializeRoleMenuAuthority() {
        authoritiesService.initializeAuthorities();
        organizationsService.initializeOrganizations();
        rolesService.initializeRole();
        moduleService.initializeModules();
        menuService.initializeMenus();
        usersService.initializeUsers();

        rolemodulepageService.initializeRoleModulePage();

        return true;
    }
}
