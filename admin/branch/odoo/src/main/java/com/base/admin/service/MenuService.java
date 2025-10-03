package com.base.admin.service;

import java.util.List;
import java.util.UUID;

import com.base.admin.dto.authentication.MenuDTO;

public interface MenuService {

    boolean initializeMenus();

    List<MenuDTO> getUserMenu(UUID userid, UUID organizationid);
}
