package com.base.admin.service;

import com.base.admin.dto.authentication.MenuDTO;

import java.util.List;
import java.util.UUID;

public interface MenuService {

    boolean initializeMenus();

    List<MenuDTO> getUserMenu(UUID userid, UUID organizationid);

}

