package com.base.admin.controller;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import jakarta.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.base.admin.constant.UserType;
import com.base.admin.dto.*;
import com.base.admin.dto.authentication.ChangePasswordDTO;
import com.base.admin.entity.Emails;
import com.base.admin.handler.ResponseHandler;
import com.base.admin.quartz.job.MailStatus;
import com.base.admin.quartz.util.EmailTemplate;
import com.base.admin.service.*;
import com.base.admin.utils.ClassUtils;

@RequestMapping("/api/v1/settings/user")
@RestController
public class UserController {
    private final UsersService usersService;
    private final OrganizationsService organizationsService;

    private final MenuService menuService;

    private final RolesService rolesService;

    private final EmailsService emailsService;
    private final ResetpasswordtokenService resetpasswordtokenService;

    public UserController(
            UsersService usersService,
            OrganizationsService organizationsService,
            MenuService menuService,
            RolesService rolesService,
            EmailsService emailsService,
            ResetpasswordtokenService resetpasswordtokenService) {
        this.usersService = usersService;
        this.organizationsService = organizationsService;
        this.menuService = menuService;
        this.rolesService = rolesService;
        this.emailsService = emailsService;
        this.resetpasswordtokenService = resetpasswordtokenService;
    }

    @PostMapping("/findById")
    public ResponseEntity<Object> findById(@RequestParam(name = "userid") UUID userid) {
        UsersDTO user = usersService.findDTOById(userid);
        if (user == null) {
            return ResponseHandler.generateResponseError("User not found", HttpStatus.NOT_FOUND);
        }
        return ResponseHandler.generateResponseSuccess("", user);
    }

    @PostMapping(value = "/searchByOrganizationId")
    public ResponseEntity<Object> searchByOrganizationId(
            @RequestBody UsersSearchDTO userSearchDTO,
            @RequestParam(name = "organizationid") UUID organizationid,
            @RequestParam(name = "inOrOut", defaultValue = "true") boolean inOrOut,
            @RequestParam(required = false, defaultValue = "false") boolean exact) {
        Pagination pagination = userSearchDTO.getPagination();
        List<String> listFields = ClassUtils.getAllPropertyNames(UsersDTO.class);

        if (!pagination.isValidSortField(listFields)) {
            return ResponseHandler.generateResponseError(
                    "sortFiels invalid. In list: " + StringUtils.join(listFields, ','), HttpStatus.BAD_REQUEST);
        }
        Pageable pageable = pagination.convertToPageable();
        Page<UsersDTO> paged = usersService.searchPagedByOrganizationId(
                userSearchDTO.getDto(), pageable, organizationid, inOrOut, exact);
        PagedResponse<UsersDTO> response = new PagedResponse<>(
                paged.getContent(),
                paged.getNumber(),
                paged.getSize(),
                paged.getTotalElements(),
                paged.getTotalPages(),
                paged.isLast());
        return ResponseHandler.generateResponseSuccess("", response);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> create(
            @RequestBody @Validated UsersDTO userDto, @RequestParam(required = false) UUID organizationid) {
        // validate parameters
        if (StringUtils.isEmpty(userDto.getUsername()) || StringUtils.isEmpty(userDto.getEmailaddress())) {
            return ResponseHandler.generateResponseError(
                    "Invalid parameters. User name and email address not null", HttpStatus.BAD_REQUEST);
        }
        if (userDto.getUsertype() == null
                || userDto.getUsertype() > UserType.USER.getValue()
                || userDto.getUsertype() < UserType.SUPER_ADMIN.getValue()) {
            return ResponseHandler.generateResponseError("UserType from 0 to 2", HttpStatus.NOT_FOUND);
        }
        if (userDto.getUsername() == null || usersService.existsByUsername(userDto.getUsername())) {
            return ResponseHandler.generateResponseError("User name is null or already exists", HttpStatus.BAD_REQUEST);
        }
        if (userDto.getEmailaddress() == null || usersService.existsByEmailaddress(userDto.getEmailaddress())) {
            return ResponseHandler.generateResponseError("Email Address already exists", HttpStatus.BAD_REQUEST);
        }

        if (userDto.getOrganizationid() != null && !organizationsService.existsById(userDto.getOrganizationid())) {
            return ResponseHandler.generateResponseError("Organization ID DTO not found", HttpStatus.NOT_FOUND);
        }

        if (organizationid != null && !organizationsService.existsById(organizationid)) {
            return ResponseHandler.generateResponseError("Organization ID Param not found", HttpStatus.NOT_FOUND);
        }
        ////////////////////////////////
        int count = usersService.addUsersDTO(userDto, organizationid);
        if (count == 0) {
            return ResponseHandler.generateResponseError("Save User fail", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseHandler.generateResponseSuccess("Suessfully created", null);
    }

    @PostMapping("/update")
    public ResponseEntity<Object> update(@RequestBody @Validated UsersDTO userDto) {
        JSONObject jsonObject = ClassUtils.newJSONObject(userDto);
        // validate parameters
        if (userDto.getUserid() == null) {
            return ResponseHandler.generateResponseError(
                    "Invalid parameters. Group ID, name and organiztionid not null", HttpStatus.BAD_REQUEST);
        }
        if (jsonObject != null
                && ClassUtils.existsParameter(jsonObject, "usertype")
                && userDto.getUsertype() != null
                && (userDto.getUsertype() > UserType.USER.getValue()
                        || userDto.getUsertype() < UserType.SUPER_ADMIN.getValue())) {
            return ResponseHandler.generateResponseError("UserType from 0 to 2", HttpStatus.NOT_FOUND);
        }
        if (jsonObject != null
                && ClassUtils.existsParameter(jsonObject, "organizationid")
                && userDto.getOrganizationid() != null
                && !organizationsService.existsById(userDto.getOrganizationid())) {
            return ResponseHandler.generateResponseError("Organization ID not found", HttpStatus.NOT_FOUND);
        }

        if (jsonObject != null
                && ClassUtils.existsParameter(jsonObject, "userid")
                && userDto.getUserid() != null
                && !usersService.existsById(userDto.getUserid())) {
            return ResponseHandler.generateResponseError("User ID not found", HttpStatus.NOT_FOUND);
        }

        if (jsonObject != null
                && ClassUtils.existsParameter(jsonObject, "username")
                && userDto.getUsername() != null
                && usersService.existsByUsernameAndDifferentUserId(userDto.getUserid(), userDto.getUsername())) {
            return ResponseHandler.generateResponseError("User name already exists", HttpStatus.BAD_REQUEST);
        }

        if (jsonObject != null
                && ClassUtils.existsParameter(jsonObject, "emailaddress")
                && userDto.getEmailaddress() != null
                && usersService.existsByEmailaddressAndDifferentUserId(
                        userDto.getUserid(), userDto.getEmailaddress())) {
            return ResponseHandler.generateResponseError("Email Address already exists", HttpStatus.BAD_REQUEST);
        }
        ////////////////////////////////
        int count = usersService.update(userDto);
        if (count == 0) {
            return ResponseHandler.generateResponseError("Save User fail", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseHandler.generateResponseSuccess("Suessfully updated", null);
    }

    @PostMapping("/delete")
    public ResponseEntity<Object> delete(@RequestParam(name = "userid") UUID userid) {
        // validate parameters
        UsersDTO usersDTO = usersService.findDTOById(userid);
        if (usersDTO == null || Objects.equals(usersDTO.getUsertype(), UserType.SUPER_ADMIN.getValue())) {
            return ResponseHandler.generateResponseError(
                    "User not found or user is super admin", HttpStatus.BAD_REQUEST);
        }
        ////////////////////////////////
        if (usersService.deleteById(userid) == 0) { // TODO: Delete relationship
            return ResponseHandler.generateResponseError("User not found", HttpStatus.NOT_FOUND);
        }
        return ResponseHandler.generateResponseSuccess("Suessfully deleted", null);
    }

    @PostMapping("/findOrgs")
    public ResponseEntity<Object> findOrgs(@RequestParam(name = "userid") UUID userid) {
        List<OrganizationsDTO> listOrgs = organizationsService.findDTOByUserId(userid);
        return ResponseHandler.generateResponseSuccess("", listOrgs);
    }

    @PostMapping("/findRoles")
    public ResponseEntity<Object> findRoles(
            @RequestParam(name = "organizationid") UUID organizationid, @RequestParam(name = "userid") UUID userid) {
        List<RolesDTO> roles = rolesService.findByOrganizationIdAndUserId(organizationid, userid);
        return ResponseHandler.generateResponseSuccess("", roles);
    }

    @PostMapping("/changeOrganization") // resetPassword or resent email password
    public ResponseEntity<Object> changeOrganization(
            @RequestParam(name = "userid") UUID userid, @RequestParam(name = "organizationid") UUID organizationid) {
        // validate parameters
        if (!organizationsService.existsById(organizationid)) {
            return ResponseHandler.generateResponseError("Organization not found", HttpStatus.NOT_FOUND);
        }
        ////////////////////////////////
        if (usersService.updateDefaultOrganization(userid, organizationid) == 0) {
            return ResponseHandler.generateResponseError("Update User fail", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseHandler.generateResponseSuccess(
                "New menu info", menuService.getUserMenu(userid, organizationid));
    }

    @PostMapping("/setdefaultOrg")
    public ResponseEntity<Object> setdefaultOrg(
            @RequestParam(name = "userid") UUID userid, @RequestParam(name = "organizationid") UUID organizationid) {
        // validate parameters
        if (!organizationsService.existsById(organizationid)) {
            return ResponseHandler.generateResponseError("Organization not found", HttpStatus.NOT_FOUND);
        }
        ////////////////////////////////

        if (usersService.updateDefaultOrganization(userid, organizationid) == 0) {
            return ResponseHandler.generateResponseError(
                    "Update default organization fail", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return ResponseHandler.generateResponseError("Fail Set default organization", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping("/updatePassword") // Update current password
    public ResponseEntity<Object> updatePassword(@RequestBody @Validated ChangePasswordDTO passwordDTO) {
        String oldPassword = passwordDTO.getOldPassword();
        String newPassword = passwordDTO.getNewPassword();
        String newConfirmPassword = passwordDTO.getNewConfirmPassword();

        // validate parameters
        if (StringUtils.isEmpty(oldPassword)
                || StringUtils.isEmpty(newPassword)
                || StringUtils.isEmpty(newConfirmPassword)
                || oldPassword.equals(newConfirmPassword)
                || !newPassword.equals(newConfirmPassword)) {
            return ResponseHandler.generateResponseError("Validation failed", HttpStatus.BAD_REQUEST);
        }
        ////////////////////////////////
        if (usersService.updatePassword(passwordDTO) == 0) {
            return ResponseHandler.generateResponseError("Update Password fail", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseHandler.generateResponseSuccess("Suessfully password updated", null);
    }

    @PostMapping("/forgotPassword") // resetPassword or resent email password
    public ResponseEntity<Object> forgot_password(
            HttpServletRequest request, @RequestParam(name = "emailaddress") String emailaddress) {

        UsersDTO user = usersService.findDTOByEmailaddress(emailaddress);
        if (user == null) {
            return ResponseHandler.generateResponseError("Email not found", HttpStatus.NOT_FOUND);
        }
        //        eventPublisher.publishEvent(new OnResetPasswordCompleteEvent(request, user));
        String token = UUID.randomUUID().toString();
        if (0 == usersService.createPasswordResetTokenForUser(user, token)) {
            return ResponseHandler.generateResponseError(
                    "Create password reset token fail", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        EmailTemplate emailTemplate = new EmailTemplate(request, user, token);
        String body = emailTemplate.createMessagePasswordResetTokenForUser();
        Emails email = new Emails();
        email.setUserid(user.getUserid());
        email.setUsername(user.getUsername());
        email.setToemail(user.getEmailaddress());
        email.setSubject("Reset Password");
        email.setMessage(body);
        email.setScheduledtime(new Date());
        email.setZoneid(ZoneId.systemDefault().toString());
        email.setStatus(MailStatus.SCHEDULED.getValue());
        email.setSentdate(LocalDate.now());
        email.setErrordescription("");

        emailsService.insert(email);
        return ResponseHandler.generateResponseSuccess("Suessfully Email to " + user.getEmailaddress(), null);
    }

    @PostMapping("/resetPassword") // Update password with token
    public ResponseEntity<Object> resetPassword(@RequestBody @Validated ResetTokenPasswordDTO tokenDto) {

        String newPassword = tokenDto.getNewPassword();
        String newConfirmPassword = tokenDto.getNewConfirmPassword();

        if (!newPassword.equals(newConfirmPassword)) {
            return ResponseHandler.generateResponseError("Validation failed", HttpStatus.BAD_REQUEST);
        }

        final String isInvalid = resetpasswordtokenService.validatePasswordResetToken(tokenDto.getToken());
        if (isInvalid != null) {
            return ResponseHandler.generateResponseError("invalid token or expired", HttpStatus.BAD_REQUEST);
        }
        if (usersService.updatePasswordReset(tokenDto) == 0) {
            return ResponseHandler.generateResponseError("Update Password fail", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return ResponseHandler.generateResponseSuccess("Suessfully password updated", null);
    }
}
