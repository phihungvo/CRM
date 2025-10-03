/**
 * @mbg.generated generator on Wed Mar 06 09:21:37 ICT 2024
 */
package com.base.admin.service;

import com.base.admin.constant.ApiRole;
import com.base.admin.constant.UserType;
import com.base.admin.dto.RoleAddModulesDTO;
import com.base.admin.dto.RoleAddUsersDTO;
import com.base.admin.dto.RolesDTO;
import com.base.admin.entity.Roles;
import com.base.admin.entity.RolesModules;
import com.base.admin.entity.UsersRoles;
import com.base.admin.mapper.OrganizationsMapper;
import com.base.admin.mapper.RolesMapper;
import com.base.admin.mapper.RolesModulesMapper;
import com.base.admin.mapper.UsersRolesMapper;
import com.base.admin.utils.ClassUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class RolesServiceImpl implements RolesService {
    private final RolesMapper rolesMapper;
    private final RolesModulesMapper rolesModulesMapper;
    private final UsersRolesMapper usersRolesMapper;
    private final OrganizationsMapper organizationsMapper;

    private final RolemodulepageService rolemodulepageService;

    public RolesServiceImpl(RolesMapper rolesMapper, RolesModulesMapper rolesModulesMapper, UsersRolesMapper usersRolesMapper, OrganizationsMapper organizationsMapper, RolemodulepageService rolemodulepageService) {
        this.rolesMapper = rolesMapper;
        this.rolesModulesMapper = rolesModulesMapper;
        this.usersRolesMapper = usersRolesMapper;
        this.organizationsMapper = organizationsMapper;
        this.rolemodulepageService = rolemodulepageService;
    }


    public boolean initializeRole() {
        try {
            rolesModulesMapper.deleteAll();
            usersRolesMapper.deleteAll();
            rolesMapper.deleteAll();
            List<Roles> roles = new ArrayList<Roles>();
            UUID organizationId = organizationsMapper.getIdByName("DEFAULT");
            roles.add(new Roles(UUID.randomUUID(), organizationId, ApiRole.SUPER_ADMIN.name(), UserType.SUPER_ADMIN.getValue(), true));
            roles.add(new Roles(UUID.randomUUID(), organizationId, ApiRole.ADMIN.name(), UserType.ADMIN.getValue(), true));
            roles.add(new Roles(UUID.randomUUID(), organizationId, ApiRole.USER.name(), UserType.USER.getValue(), true));

            rolesMapper.saveAll(roles);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean existById(UUID roleid) {
        return rolesMapper.existById(roleid);
    }


    @Override
    public boolean existsByListRoleId(List<UUID> roleid) {
        long count = rolesMapper.countByListRoleId(roleid);
        return count == roleid.size();
    }

    @Override
    public boolean existsByRolenameAndOrganizationId(String rolename, UUID organizationid) {
        return rolesMapper.existsByRolenameAndOrganizationId(rolename, organizationid);
    }

    @Override
    public int addRelationshipUserIdAndRoleId(RoleAddUsersDTO roleAddUsersDTO) {
        List<UsersRoles> list = new ArrayList<>();
        for (UUID userid : roleAddUsersDTO.getUserid()) {
            UsersRoles usersRoles = new UsersRoles(userid, roleAddUsersDTO.getRoleid());
            if (!usersRolesMapper.existsById(userid, roleAddUsersDTO.getRoleid())) {
                list.add(usersRoles);
            }
        }
        if (list.size() > 0) {
            return usersRolesMapper.saveAll(list);
        }
        return 0;
    }

    @Override
    public int addRelationshipModuleIdAndRoleId(RoleAddModulesDTO roleAddModulesDTO) {
        List<RolesModules> list = new ArrayList<>();
        for (UUID moduleid : roleAddModulesDTO.getModuleid()) {
            RolesModules rolesModules = new RolesModules(roleAddModulesDTO.getRoleid(), moduleid);
            if (!rolesModulesMapper.existsById(roleAddModulesDTO.getRoleid(), moduleid)) {
                list.add(rolesModules);
                rolemodulepageService.addModuleForRole(roleAddModulesDTO.getRoleid(), moduleid);
            }
        }
        if (!list.isEmpty()) {
            return rolesModulesMapper.saveAll(list);
        }
        return 0;
    }

    @Override
    public int deleteRelationshipUserIdAndRoleId(RoleAddUsersDTO roleAddUsersDTO) {
        List<UsersRoles> list = new ArrayList<>();
        for (UUID userid : roleAddUsersDTO.getUserid()) {
            UsersRoles usersRoles = new UsersRoles(userid, roleAddUsersDTO.getRoleid());
            if (usersRolesMapper.existsById(userid, roleAddUsersDTO.getRoleid())) {
                list.add(usersRoles);
            }
        }
        if (!list.isEmpty()) {
            return usersRolesMapper.deleteListByIds(list);
        }
        return 0;
    }

    @Override
    public int deleteRelationshipModuleIdAndRoleId(RoleAddModulesDTO roleAddModulesDTO) {
        List<RolesModules> list = new ArrayList<>();
        for (UUID moduleid : roleAddModulesDTO.getModuleid()) {
            RolesModules rolesModules = new RolesModules(roleAddModulesDTO.getRoleid(), moduleid);
            if (rolesModulesMapper.existsById(roleAddModulesDTO.getRoleid(), moduleid)) {
                list.add(rolesModules);
                rolemodulepageService.removeModuleForRole(roleAddModulesDTO.getRoleid(), moduleid);
            }
        }
        if (list.size() > 0) {
            return rolesModulesMapper.deleteListByIds(list);
        }
        return 0;
    }


    @Override
    public RolesDTO findDTOById(UUID roleid) {
        return rolesMapper.findDTOById(roleid);
    }

    @Override
    public Page<RolesDTO> searchPaged(RolesDTO search, Pageable pageable, boolean exact) {
        long total = 0;
        List<RolesDTO> content = rolesMapper.searchPaged(search, pageable, exact);
        if (!content.isEmpty()) {
            total = rolesMapper.countPaged(search, exact);
        }
        return new PageImpl<>(content, pageable, total);
    }

//    @Override
//    public Page<RolesDTO> searchPagedWithGroupId(RolesDTO search, Pageable pageable, UUID groupid, boolean exact) {
//        long total = 0;
//        List<RolesDTO> content = rolesMapper.searchPagedWithGroupId(search, pageable, groupid, exact);
//        if (!content.isEmpty()) {
//            total = rolesMapper.countPagedWithGroupId(search, groupid, exact);
//        }
//        return new PageImpl<>(content, pageable, total);
//    }

    @Override
    public List<RolesDTO> findByOrganizationIdAndUserId(UUID organizationid, UUID userid) {
        return rolesMapper.findByOrganizationIdAndUserId(organizationid, userid);
    }

    @Override
    public int addRolesDTO(RolesDTO rolesDTO) {
        Roles role = rolesDTO.newEntity();
        return rolesMapper.insert(role);
    }

    @Override
    public int update(RolesDTO rolesDTO) {
        Roles role = rolesMapper.findById(rolesDTO.getRoleid());
        if (role != null) {
            if (!role.getRolename().equalsIgnoreCase(rolesDTO.getRolename())) {
                if (rolesMapper.existsByRolenameAndOrganizationIdAndDiffRoleId(rolesDTO.getRolename(), rolesDTO.getOrganizationid(), rolesDTO.getRoleid())) {
                    return 0;
                }
            }
//            role.updateFromDTO(rolesDTO);
            role = (Roles) ClassUtils.convertDTOToEntity(rolesDTO, role);
            return rolesMapper.update(role);
        }
        return 0;
    }

    @Override
    public int deleteById(UUID roleid) {
        List<String> listRoleName = Arrays.asList("SUPER_ADMIN", "ADMIN", "USER");
        List<UUID> ids = rolesMapper.getIdsByName(listRoleName);
        if (!ids.isEmpty()) {
            if (ids.parallelStream().anyMatch(id -> (
                    id.equals(roleid)))) {
                return 0;
            }
        }

        usersRolesMapper.deleteByRoleId(roleid);
        rolesModulesMapper.deleteByRoleId(roleid);
        return rolesMapper.deleteById(roleid);
    }

    @Override
    public int deleteByOrganizationId(UUID organizationid) {
        usersRolesMapper.deleteByOrganizationId(organizationid);
        rolesModulesMapper.deleteByOrganizationId(organizationid);
        return rolesMapper.deleteByOrganizationId(organizationid);
    }
}