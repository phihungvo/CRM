/**
 * @mbg.generated generator on Wed Mar 06 09:21:37 ICT 2024
 */
package com.base.admin.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.base.admin.constant.UserType;
import com.base.admin.dto.OrgAddUsersDTO;
import com.base.admin.dto.OrganizationsDTO;
import com.base.admin.entity.Organizations;
import com.base.admin.entity.Users;
import com.base.admin.entity.UsersOrgs;
import com.base.admin.mapper.*;
import com.base.admin.utils.ClassUtils;

@Service
public class OrganizationsServiceImpl implements OrganizationsService {
    private final OrganizationsMapper organizationsMapper;

    private final UsersOrgsMapper usersOrgsMapper;
    private final RolesMapper rolesMapper;
    private final UsersRolesMapper usersRolesMapper;
    private final RolesModulesMapper rolesModulesMapper;

    private final UsersMapper usersMapper;

    public OrganizationsServiceImpl(
            OrganizationsMapper organizationsMapper,
            UsersOrgsMapper usersOrgsMapper,
            RolesMapper rolesMapper,
            UsersRolesMapper usersRolesMapper,
            RolesModulesMapper rolesModulesMapper,
            UsersMapper usersMapper) {
        this.organizationsMapper = organizationsMapper;
        this.usersOrgsMapper = usersOrgsMapper;
        this.rolesMapper = rolesMapper;
        this.usersRolesMapper = usersRolesMapper;
        this.rolesModulesMapper = rolesModulesMapper;
        this.usersMapper = usersMapper;
    }

    @Override
    public void initializeOrganizations() {
        organizationsMapper.deleteAll();

        Organizations organizations = new Organizations(UUID.randomUUID(), "DEFAULT", true);
        organizationsMapper.insert(organizations);
    }

    @Override
    public boolean existsById(UUID organizationid) {
        return organizationsMapper.existsById(organizationid);
    }

    @Override
    public OrganizationsDTO findDTOById(UUID organizationid) {
        return organizationsMapper.findDTOById(organizationid);
    }

    @Override
    public List<OrganizationsDTO> findDTOByUserId(UUID userid) {
        Users user = usersMapper.findById(userid);
        boolean isSuperAmin = false;
        if (user != null) {
            isSuperAmin = (user.getUsertype() == UserType.SUPER_ADMIN.getValue());
        }
        return organizationsMapper.findDTOByUserId(userid, isSuperAmin);
    }

    @Override
    public Page<OrganizationsDTO> searchPaged(OrganizationsDTO search, Pageable pageable, boolean exact) {
        long total = 0;
        List<OrganizationsDTO> content = organizationsMapper.searchPaged(search, pageable, exact);
        if (!content.isEmpty()) {
            total = organizationsMapper.countPaged(search, exact);
        }
        return new PageImpl<>(content, pageable, total);
    }

    @Override
    public int addOrganizationDTO(OrganizationsDTO dto) {
        Organizations organizations = dto.newEntity();
        return organizationsMapper.insert(organizations);
    }

    @Override
    public int update(OrganizationsDTO dto) {
        Organizations organization = organizationsMapper.findById(dto.getOrganizationid());
        if (organization != null) {
            //            organization.updateFromDTO(dto);
            organization = (Organizations) ClassUtils.convertDTOToEntity(dto, organization);
            return organizationsMapper.update(organization);
        }
        return 0;
    }

    @Override
    public int deleteById(UUID organizationid) {
        // ORGANIZATIONS
        usersOrgsMapper.deleteByOrganizationId(organizationid);

        // GROUPS

        // ROLES
        usersRolesMapper.deleteByOrganizationId(organizationid);
        rolesModulesMapper.deleteByOrganizationId(organizationid);
        rolesMapper.deleteByOrganizationId(organizationid);
        //
        //        //user org
        //        if(usersOrgsMapper.existsByOrganizationId(organizationid))
        //        {
        //            usersOrgsMapper.deleteByOrganizationId(organizationid);
        //            return -1;
        //        }
        //        groupsService.deleteByOrganizationId(organizationid);
        //        rolesService.deleteByOrganizationId(organizationid);
        //
        //        // user groups of organizations
        //        if(usersGro.existsByOrganizationId(organizationid))
        //        {
        //            usersOrgsMapper.deleteByOrganizationId(organizationid);
        //            return -1;
        //        }

        // group role
        //        if(groupsRolesMapper.existsByOrganizationId(organizationid))
        //        {
        //            groupsRolesMapper.deleteByOrganizationId(organizationid);
        //            return -2;
        //        }
        // group
        //        if(groupsMapper.existsByOrganizationId(organizationid))
        //        {
        //            groupsMapper.deleteByOrganizationId(organizationid);
        //            return -3;
        //        }
        //        //role
        //        if(rolesMapper.existsByOrganizationId(organizationid))
        //        {
        //            rolesMapper.deleteByOrganizationId(organizationid);
        //            return -4;
        //        }
        return organizationsMapper.deleteById(organizationid);
    }

    @Override
    public UUID getDefaultOrganizationId() {
        return organizationsMapper.getIdByName("DEFAULT");
    }

    @Override
    public int addRelationshipUserIdAndOrgId(OrgAddUsersDTO orgAddUsersDTO) {
        List<UsersOrgs> list = new ArrayList<>();
        for (UUID userid : orgAddUsersDTO.getUserid()) {
            UsersOrgs usersOrgs = new UsersOrgs(orgAddUsersDTO.getOrganizationid(), userid);
            if (!usersOrgsMapper.existsById(orgAddUsersDTO.getOrganizationid(), userid)) {
                list.add(usersOrgs);
            }
        }
        if (list.size() > 0) {
            return usersOrgsMapper.saveAll(list);
        }
        return 0;
    }

    @Override
    public int deleteRelationshipUserIdAndOrgId(OrgAddUsersDTO orgAddUsersDTO) {
        List<UsersOrgs> list = new ArrayList<>();
        for (UUID userid : orgAddUsersDTO.getUserid()) {
            UsersOrgs usersOrgs = new UsersOrgs(orgAddUsersDTO.getOrganizationid(), userid);
            list.add(usersOrgs);
        }
        return usersOrgsMapper.deleteListByIds(list);
    }

    @Override
    public boolean existsByOrganizationName(String organizationname) {
        return organizationsMapper.existsByOrganizationName(organizationname);
    }

    @Override
    public boolean existsByNameAndDifferentId(UUID organizationid, String organizationname) {
        return organizationsMapper.existsByNameAndDifferentId(organizationid, organizationname);
    }
}
