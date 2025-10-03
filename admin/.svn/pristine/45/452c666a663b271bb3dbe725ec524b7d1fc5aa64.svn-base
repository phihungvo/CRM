/**
 * @mbg.generated generator on Wed Mar 06 09:21:37 ICT 2024
 */
package com.base.admin.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.base.admin.constant.AppConstant;
import com.base.admin.constant.UserStatus;
import com.base.admin.constant.UserType;
import com.base.admin.dto.ResetTokenPasswordDTO;
import com.base.admin.dto.UsersDTO;
import com.base.admin.dto.authentication.ChangePasswordDTO;
import com.base.admin.entity.*;
import com.base.admin.mapper.*;
import com.base.admin.utils.ClassUtils;

@Service
public class UsersServiceImpl implements UsersService {
    private final UsersMapper usersMapper;
    private final UsersAuthoritiesMapper usersAuthoritiesMapper;
    private final UsersRolesMapper usersRolesMapper;
    private final UsersOrgsMapper usersOrgsMapper;
    private final RolesMapper rolesMapper;
    private final AuthoritiesMapper authoritiesMapper;
    private final OrganizationsMapper organizationsMapper;

    private final ResetpasswordtokenMapper resetpasswordtokenMapper;
    private final EmailsMapper emailsMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UsersServiceImpl(
            UsersMapper usersMapper,
            UsersAuthoritiesMapper usersAuthoritiesMapper,
            UsersRolesMapper usersRolesMapper,
            UsersOrgsMapper usersOrgsMapper,
            RolesMapper rolesMapper,
            AuthoritiesMapper authoritiesMapper,
            OrganizationsMapper organizationsMapper,
            ResetpasswordtokenMapper resetpasswordtokenMapper,
            EmailsMapper emailsMapper) {
        this.usersMapper = usersMapper;
        this.usersAuthoritiesMapper = usersAuthoritiesMapper;
        this.usersRolesMapper = usersRolesMapper;
        this.usersOrgsMapper = usersOrgsMapper;
        this.rolesMapper = rolesMapper;
        this.authoritiesMapper = authoritiesMapper;
        this.organizationsMapper = organizationsMapper;
        this.resetpasswordtokenMapper = resetpasswordtokenMapper;
        this.emailsMapper = emailsMapper;
    }

    @Override
    public UsersDTO findDTOById(UUID userid) {
        return usersMapper.findDTOById(userid);
    }

    @Override
    public boolean initializeUsers() {
        usersAuthoritiesMapper.deleteAll();
        usersRolesMapper.deleteAll();
        usersOrgsMapper.deleteAll();
        usersMapper.deleteAll();

        // Add Default Organization
        UsersDTO dtosuperadmin =
                new UsersDTO(UUID.randomUUID(), "superadmin", "superadmin@waza.com", UserType.SUPER_ADMIN.getValue());
        UsersDTO dtoadmin = new UsersDTO(UUID.randomUUID(), "admin", "admin@waza.com", UserType.ADMIN.getValue());
        UsersDTO dtouser = new UsersDTO(UUID.randomUUID(), "user", "user@waza.com", UserType.USER.getValue());
        List<UsersDTO> list = new ArrayList<UsersDTO>();
        list.add(dtosuperadmin);
        list.add(dtoadmin);
        list.add(dtouser);
        addListUsersDTOs(list);
        return true;
    }

    @Override
    public int addUsersDTO(UsersDTO dto, UUID organizationid) {
        String passwordEncrypt = passwordEncoder.encode(AppConstant.DEFAULT_USER_PASSWORD);
        Users user = createDefaultUserEntity(dto, passwordEncrypt);
        addDefaultAuthorities(user);
        addDefaultRoles(user);
        if (organizationid == null) {
            addRelationshipUserToDefaultOrgs(user);
        } else { // default organization !=  org
            user.setOrganizationid(organizationid);
            addRelationshipUserToOrgs(organizationid, user.getUserid());
        }

        return usersMapper.insert(user);
    }

    @Override
    public int addRelationshipUserToOrgs(UUID organizationid, UUID userid) {
        UsersOrgs userOrgsRelationship = new UsersOrgs(organizationid, userid);
        return usersOrgsMapper.insert(userOrgsRelationship);
    }

    @Override
    public int addListUsersDTOs(List<UsersDTO> list) {
        List<Users> users = new ArrayList<Users>();
        List<UsersAuthorities> authoritiesRelationship = new ArrayList<>();
        List<UsersRoles> usersRolesRelationship = new ArrayList<>();
        List<UsersOrgs> userOrgsRelationship = new ArrayList<>();
        String passwordEncrypt = passwordEncoder.encode(AppConstant.DEFAULT_USER_PASSWORD);
        list.forEach(dto -> {
            Users user = createDefaultUserEntity(dto, passwordEncrypt);
            users.add(user);
            authoritiesRelationship.addAll(getRelationshipDefaultAuthorities(user));
            usersRolesRelationship.addAll(getRelationshipDefaultRoles(user));
        });
        userOrgsRelationship = getLostRelationshipDefaultOrgs(users);
        usersRolesMapper.saveAll(usersRolesRelationship);
        usersAuthoritiesMapper.saveAll(authoritiesRelationship);
        usersOrgsMapper.saveAll(userOrgsRelationship);
        return usersMapper.saveAll(users);
    }

    @Override
    public int update(UsersDTO dto) {
        Users user = usersMapper.findById(dto.getUserid());
        if (user != null) {
            //            user.updateFromDTO(dto);
            user = (Users) ClassUtils.convertDTOToEntity(dto, user);
            if (user.getOrganizationid() != null) {
                if (!usersOrgsMapper.existsById(user.getOrganizationid(), user.getUserid())) {
                    addRelationshipUserToOrgs(user.getOrganizationid(), user.getUserid());
                }
            }
            return usersMapper.update(user);
        }
        return 0;
    }

    @Override
    public int deleteById(UUID userid) {
        usersAuthoritiesMapper.deleteByUserId(userid);
        usersOrgsMapper.deleteByUserId(userid);
        usersRolesMapper.deleteByUserId(userid);
        return usersMapper.deleteById(userid);
    }

    @Override
    public int deleteListByIds(List<UUID> list) {
        usersAuthoritiesMapper.deleteListByUserIds(list);
        usersRolesMapper.deleteListByUserIds(list);
        usersOrgsMapper.deleteListByUserIds(list);
        return usersMapper.deleteListByIds(list);
    }

    @Override
    public Page<UsersDTO> searchPaged(UsersDTO search, Pageable pageable, boolean exact) {
        long total = 0;
        List<UsersDTO> content = usersMapper.searchPaged(search, pageable, exact);
        if (!content.isEmpty()) {
            total = usersMapper.countPaged(search, exact);
        }
        return new PageImpl<>(content, pageable, total);
    }

    @Override
    public Page<UsersDTO> searchPagedByOrganizationId(
            UsersDTO search, Pageable pageable, UUID organizationid, boolean inOrOut, boolean exact) {
        long total = 0;
        List<UsersDTO> content =
                usersMapper.searchPagedByOrganizationId(search, pageable, organizationid, inOrOut, exact);
        if (!content.isEmpty()) {
            total = usersMapper.countPagedByOrganizationId(search, organizationid, inOrOut, exact);
        }
        return new PageImpl<>(content, pageable, total);
    }

    //    @Override
    //    public Page<UsersDTO> searchPagedWithGroupId(UsersDTO search, Pageable pageable, UUID groupid, boolean exact)
    // {
    //        long total = 0;
    //        List<UsersDTO> content = usersMapper.searchPagedWithGroupId(search, pageable, groupid, exact);
    //        if (!content.isEmpty()) {
    //            total = usersMapper.countPagedWithGroupId(search, groupid, exact);
    //        }
    //        return new PageImpl<>(content, pageable, total);
    //    }

    @Override
    public boolean existsByUsername(String username) {
        return usersMapper.existsByUsername(username);
    }

    @Override
    public boolean existsByEmailaddress(String emailaddress) {
        return usersMapper.existsByEmailaddress(emailaddress);
    }

    @Override
    public boolean existsByUsernameAndDifferentUserId(UUID userid, String username) {
        return usersMapper.existsByUsernameAndDifferentUserId(userid, username);
    }

    @Override
    public boolean existsByEmailaddressAndDifferentUserId(UUID userid, String emailaddress) {
        return usersMapper.existsByEmailaddressAndDifferentUserId(userid, emailaddress);
    }

    @Override
    public boolean existsByListUserId(List<UUID> userids) {
        long count = usersMapper.countByListUserId(userids);
        return count == userids.size();
    }

    @Override
    public boolean existsById(UUID userid) {
        return usersMapper.existsById(userid);
    }

    @Override
    public int updatePassword(ChangePasswordDTO passwordDTO) {
        Users user = usersMapper.findById(passwordDTO.getUserid());
        if (user != null) {
            //            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            //            if (!(authentication instanceof AnonymousAuthenticationToken)) {
            //                JwtUserDetails userPrincipal = (JwtUserDetails) authentication.getPrincipal();
            //                if (userPrincipal.getUserid().equals(user.getUserid())) {
            if (passwordEncoder.matches(passwordDTO.getOldPassword(), user.getPassword())
                    && !passwordEncoder.matches(passwordDTO.getNewConfirmPassword(), user.getPassword())) {
                user.setPassword(passwordEncoder.encode(passwordDTO.getNewConfirmPassword()));
                user.setStatus(UserStatus.STATUS_NORMAL.getValue());
                return usersMapper.update(user);
            }
            //                }
            //            }
        }
        return 0;
    }

    @Override
    public int updatePasswordReset(ResetTokenPasswordDTO tokenDto) {
        final Resetpasswordtoken passToken = resetpasswordtokenMapper.findByToken(tokenDto.getToken());
        if (passToken != null) {
            Users user = usersMapper.findById(passToken.getUserid());
            if (user != null) {
                user.setPassword(passwordEncoder.encode(tokenDto.getNewConfirmPassword()));
                user.setStatus(UserStatus.STATUS_NORMAL.getValue());
                resetpasswordtokenMapper.deleteByToken(passToken.getToken());
                emailsMapper.deleteByUserId(user.getUserid());
                return usersMapper.update(user);
            }
        }
        return 0;
    }

    @Override
    public int updateDefaultOrganization(UUID userid, UUID organizationid) {
        Users user = usersMapper.findById(userid);
        if (user != null) {
            if (!usersOrgsMapper.existsById(organizationid, userid)) {
                addRelationshipUserToOrgs(organizationid, userid);
            }
            user.setOrganizationid(organizationid);
            return usersMapper.update(user);
        }
        return 0;
    }

    @Override
    public int createPasswordResetTokenForUser(UsersDTO user, String token) {
        if (user != null) {
            Resetpasswordtoken resetpasswordtoken = new Resetpasswordtoken();
            resetpasswordtoken.setUserid(user.getUserid());
            resetpasswordtoken.setToken(token);
            resetpasswordtoken.setExpirydate(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24));
            resetpasswordtokenMapper.deleteById(user.getUserid());
            return resetpasswordtokenMapper.insert(resetpasswordtoken);
        }
        return 0;
    }

    @Override
    public UsersDTO findDTOByEmailaddress(String emailaddress) {
        return usersMapper.findDTOByEmailaddress(emailaddress);
    }

    private List<UsersAuthorities> getRelationshipDefaultAuthorities(Users user) {
        List<String> listAuthorityName = null;
        List<UsersAuthorities> relationships = new ArrayList<>();
        switch (user.getUsertype()) {
            case 0: // SUPER_ADMIN
                listAuthorityName = Arrays.asList("SUPER_ADMIN", "ADMIN", "USER");
                break;
            case 1: // ADMIN
                listAuthorityName = Arrays.asList("ADMIN", "USER");
                break;
            case 2: // USER
                listAuthorityName = List.of("USER");
                break;
        }
        if (listAuthorityName != null) {
            List<UUID> ids = authoritiesMapper.getIdsByName(listAuthorityName);

            for (UUID uuid : ids) {
                UsersAuthorities relationship = new UsersAuthorities(user.getUserid(), uuid);
                relationships.add(relationship);
            }
        }
        return relationships;
    }

    private List<UsersRoles> getRelationshipDefaultRoles(Users user) {
        List<String> listRoleName = null;
        List<UsersRoles> relationships = new ArrayList<>();
        switch (user.getUsertype()) {
            case 0: // SUPER_ADMIN
                listRoleName = List.of("SUPER_ADMIN");
                //                listRoleName = Arrays.asList("SUPER_ADMIN", "ADMIN", "USER");
                break;
            case 1: // ADMIN
                listRoleName = List.of("ADMIN");
                //                listRoleName = Arrays.asList("ADMIN", "USER");
                break;
            case 2: // USER
                listRoleName = List.of("USER");
                break;
        }
        if (listRoleName != null) {
            List<UUID> ids = rolesMapper.getIdsByName(listRoleName);

            for (UUID uuid : ids) {
                UsersRoles relationship = new UsersRoles(user.getUserid(), uuid);
                relationships.add(relationship);
            }
        }
        return relationships;
    }

    private UsersOrgs getRelationshipDefaultOrgs(Users user) {
        UUID organizationid = organizationsMapper.getIdByName("DEFAULT");
        if (organizationid != null) {
            user.setOrganizationid(organizationid);
            return new UsersOrgs(organizationid, user.getUserid());
        }
        return null;
    }

    private List<UsersOrgs> getLostRelationshipDefaultOrgs(List<Users> users) {
        List<UsersOrgs> relationships = new ArrayList<>();
        UUID organizationid = organizationsMapper.getIdByName("DEFAULT");
        if (organizationid != null) {
            for (Users user : users) {
                user.setOrganizationid(organizationid);
                UsersOrgs relationship = new UsersOrgs(organizationid, user.getUserid());
                relationships.add(relationship);
            }
        }
        return relationships;
    }

    private void addDefaultRoles(Users user) {
        List<UsersRoles> usersRolesRelationship = getRelationshipDefaultRoles(user);
        usersRolesMapper.saveAll(usersRolesRelationship);
    }

    private void addDefaultAuthorities(Users user) {
        List<UsersAuthorities> authoritiesRelationship = getRelationshipDefaultAuthorities(user);
        usersAuthoritiesMapper.saveAll(authoritiesRelationship);
    }

    private void addRelationshipUserToDefaultOrgs(Users user) {
        UsersOrgs userOrgsRelationship = getRelationshipDefaultOrgs(user);
        usersOrgsMapper.insert(userOrgsRelationship);
    }

    private Users createDefaultUserEntity(UsersDTO dto, String passwordEncrypt) {
        Users user = dto.newEntity();
        user.setPassword(passwordEncrypt);
        return user;
    }
}
