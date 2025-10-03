package com.base.admin.service;

import java.util.List;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.base.admin.constant.UserStatus;
import com.base.admin.dto.OrganizationsDTO;
import com.base.admin.dto.authentication.AuthenticationResponse;
import com.base.admin.dto.authentication.LoginRequest;
import com.base.admin.dto.authentication.OrgInfoDTO;
import com.base.admin.dto.authentication.UserInfoDTO;
import com.base.admin.jwt.JwtUserDetails;
import com.base.admin.jwt.JwtUtils;

@Service
public class AuthenticationService {
    private final AuthenticationManager authenticationManager;
    private final MenuService menuService;
    private final OrganizationsService organizationsService;
    private final JwtUtils jwtUtils;

    public AuthenticationService(
            AuthenticationManager authenticationManager,
            MenuService menuService,
            OrganizationsService organizationsService,
            JwtUtils jwtUtils) {
        this.authenticationManager = authenticationManager;
        this.menuService = menuService;
        this.organizationsService = organizationsService;
        this.jwtUtils = jwtUtils;
    }

    public Authentication authenticateUser(LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return authentication;
    }

    public AuthenticationResponse buildAuthenticateResponse(Authentication authentication) {

        String jwtToken = jwtUtils.generateJwtToken(authentication);

        JwtUserDetails userDetails = (JwtUserDetails) authentication.getPrincipal();
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        userInfoDTO.setUserid(userDetails.getUserid());
        userInfoDTO.setUsername(userDetails.getUsername());
        userInfoDTO.setFullname(userDetails.getFullname());
        userInfoDTO.setJobtitle(userDetails.getJobtitle());
        userInfoDTO.setUsertype(userDetails.getUsertype());
        userInfoDTO.setStatus(userDetails.getStatus());

        if (userDetails.getStatus() == UserStatus.FORCE_CHANGE_PASSWORD.getValue()) {
            return AuthenticationResponse.builder()
                    .accessToken(jwtToken)
                    .userinfo(userInfoDTO)
                    .build();
        }

        List<OrganizationsDTO> orgs = organizationsService.findDTOByUserId(userDetails.getUserid());

        if (!orgs.isEmpty()) {
            List<OrgInfoDTO> orgInfoDTOS = orgs.stream()
                    .map(organization -> {
                        OrgInfoDTO orgInfoDTO = new OrgInfoDTO();
                        orgInfoDTO.setOrganizationid(organization.getOrganizationid());
                        orgInfoDTO.setIsDefault(Boolean.FALSE);
                        orgInfoDTO.setOrganizationname(organization.getOrganizationname());
                        if (userDetails.getOrganizationid() != null
                                && organization
                                        .getOrganizationid()
                                        .toString()
                                        .equalsIgnoreCase(
                                                userDetails.getOrganizationid().toString())) {
                            orgInfoDTO.setIsDefault(Boolean.TRUE);
                        }
                        return orgInfoDTO;
                    })
                    .toList();
            if (!orgInfoDTOS.isEmpty()) {
                userInfoDTO.setOrgs(orgInfoDTOS);
            }
        }

        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                //                .refreshToken(refreshToken)
                .userinfo(userInfoDTO)
                .menus(menuService.getUserMenu(userDetails.getUserid(), userDetails.getOrganizationid()))
                .build();
    }

    public boolean logout() {
        return true;
    }
}
