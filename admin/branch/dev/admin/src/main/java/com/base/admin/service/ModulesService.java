/**
 * @mbg.generated generator on Wed Mar 06 09:21:37 ICT 2024
 */
package com.base.admin.service;

import com.base.admin.dto.ModulesDTO;
import com.base.admin.dto.PagesDTO;
import com.base.admin.entity.Permissions;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface ModulesService {
    boolean initializeModules();

    boolean existsByListUserId(List<UUID> moduleids);

    ModulesDTO findDTOById(UUID moduleid);

    Page<ModulesDTO> searchPaged(ModulesDTO search, Pageable pageable, boolean exact);

    List<ModulesDTO> findByRoleId(UUID roleId);

    List<PagesDTO> findMenuItemByRoleIdAndModuleId(UUID roleId, UUID moduleId);

    int selecttedMenuItem(UUID roleId, UUID moduleId, UUID pageId, boolean isselected);

    int updatePermission(List<Permissions> permissions);


//    int insert(Modules row);
//
//
//    Modules findById(UUID moduleid);
//
//
//    int update(Modules row);
//
//
//    int deleteById(UUID moduleid);
}