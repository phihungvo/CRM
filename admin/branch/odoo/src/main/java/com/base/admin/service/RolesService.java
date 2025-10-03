/**
 * @mbg.generated generator on Wed Mar 06 09:21:37 ICT 2024
 */
package com.base.admin.service;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.base.admin.dto.RoleAddModulesDTO;
import com.base.admin.dto.RoleAddUsersDTO;
import com.base.admin.dto.RolesDTO;

public interface RolesService {
    boolean initializeRole();

    boolean existById(UUID roleid);

    //    boolean existsByRolename(String rolename);

    boolean existsByListRoleId(List<UUID> roleid);

    //    Roles findById(UUID roleid);

    RolesDTO findDTOById(UUID roleid);

    List<RolesDTO> findByOrganizationIdAndUserId(UUID organizationid, UUID userid);

    Page<RolesDTO> searchPaged(RolesDTO search, Pageable pageable, boolean exact);

    //    Page<RolesDTO> searchPagedWithGroupId(RolesDTO search, Pageable pageable, UUID groupid, boolean exact);

    int addRolesDTO(RolesDTO rolesDTO);

    int update(RolesDTO rolesDTO);

    int deleteById(UUID roleid);

    int deleteByOrganizationId(UUID organizationid);

    boolean existsByRolenameAndOrganizationId(String rolename, UUID organizationid);

    int addRelationshipUserIdAndRoleId(RoleAddUsersDTO roleAddUsersDTO);

    int addRelationshipModuleIdAndRoleId(RoleAddModulesDTO roleAddModulesDTO);

    int deleteRelationshipUserIdAndRoleId(RoleAddUsersDTO roleAddUsersDTO);

    int deleteRelationshipModuleIdAndRoleId(RoleAddModulesDTO roleAddModulesDTO);
}
