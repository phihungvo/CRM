/**
 * @mbg.generated generator on Wed Mar 06 09:21:37 ICT 2024
 */
package com.base.admin.service;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.base.admin.dto.OrgAddUsersDTO;
import com.base.admin.dto.OrganizationsDTO;

public interface OrganizationsService {
    void initializeOrganizations();

    boolean existsById(UUID organizationid);

    boolean existsByOrganizationName(String organizationname);

    boolean existsByNameAndDifferentId(UUID organizationid, String organizationname);

    OrganizationsDTO findDTOById(UUID organizationid);

    List<OrganizationsDTO> findDTOByUserId(UUID userid);

    Page<OrganizationsDTO> searchPaged(OrganizationsDTO search, Pageable pageable, boolean exact);

    int addOrganizationDTO(OrganizationsDTO organizationsDTO);

    int update(OrganizationsDTO organizationsDTO);

    int deleteById(UUID organizationid);

    UUID getDefaultOrganizationId();

    int addRelationshipUserIdAndOrgId(OrgAddUsersDTO orgAddUsersDTO);

    int deleteRelationshipUserIdAndOrgId(OrgAddUsersDTO orgAddUsersDTO);
}
