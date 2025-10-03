/**
 * @mbg.generated generator on Wed Mar 06 09:21:37 ICT 2024
 */
package com.base.admin.service;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.base.admin.dto.ResetTokenPasswordDTO;
import com.base.admin.dto.UsersDTO;
import com.base.admin.dto.authentication.ChangePasswordDTO;

public interface UsersService {
    boolean initializeUsers();

    boolean existsById(UUID userid);

    boolean existsByUsername(String username);

    boolean existsByEmailaddress(String emailaddress);

    boolean existsByUsernameAndDifferentUserId(UUID userid, String username);

    boolean existsByEmailaddressAndDifferentUserId(UUID userid, String emailaddress);

    boolean existsByListUserId(List<UUID> userids);

    UsersDTO findDTOById(UUID userid);

    Page<UsersDTO> searchPaged(UsersDTO search, Pageable pageable, boolean exact);

    Page<UsersDTO> searchPagedByOrganizationId(
            UsersDTO search, Pageable pageable, UUID organizationid, boolean inOrOut, boolean exact);

    int addUsersDTO(UsersDTO dto, UUID organizationid);

    int update(UsersDTO dto);

    int deleteById(UUID userid);

    int deleteListByIds(List<UUID> list);

    // CRUD methods

    int addRelationshipUserToOrgs(UUID userid, UUID organizationid);

    int addListUsersDTOs(List<UsersDTO> list);

    int updatePassword(ChangePasswordDTO passwordDTO);

    int updatePasswordReset(ResetTokenPasswordDTO tokenDto);

    int updateDefaultOrganization(UUID userid, UUID organizationid);

    int createPasswordResetTokenForUser(UsersDTO user, String token);

    UsersDTO findDTOByEmailaddress(String emailaddress);

    // Relationship methods

}
