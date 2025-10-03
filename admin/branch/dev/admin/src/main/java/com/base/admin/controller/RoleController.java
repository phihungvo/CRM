package com.base.admin.controller;

import com.base.admin.constant.UserType;
import com.base.admin.dto.*;
import com.base.admin.handler.ResponseHandler;
import com.base.admin.service.ModulesService;
import com.base.admin.service.OrganizationsService;
import com.base.admin.service.RolesService;
import com.base.admin.service.UsersService;
import com.base.admin.utils.ClassUtils;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

//@CrossOrigin("*")
@RequestMapping("/api/v1/settings/role")
@RestController
public class RoleController {
    private final RolesService rolesService;
    private final UsersService usersService;
    private final ModulesService modulesService;
    private final OrganizationsService organizationsService;

    public RoleController(RolesService rolesService, UsersService usersService, ModulesService modulesService, OrganizationsService organizationsService) {
        this.rolesService = rolesService;
        this.usersService = usersService;
        this.modulesService = modulesService;
        this.organizationsService = organizationsService;
    }


    @PostMapping("/findById")
    public ResponseEntity<Object> findById(@RequestParam(name = "roleid", required = true) UUID roleid) {
        RolesDTO role = rolesService.findDTOById(roleid);
        if (role == null) {
            return ResponseHandler.generateResponseError("Role not found", HttpStatus.NOT_FOUND);
        }
        return ResponseHandler.generateResponseSuccess("", role);
    }

    @PostMapping(value = "/search")
    public ResponseEntity<Object> search(@RequestBody RolesSearchDTO roleSearchDTO, @RequestParam(required = false, defaultValue = "false") boolean exact) {
        Pagination pagination = roleSearchDTO.getPagination();
        List<String> listFields = ClassUtils.getAllPropertyNames(RolesDTO.class);

        if (!pagination.isValidSortField(listFields)) {
            return ResponseHandler.generateResponseError("sortFiels invalid. In list: " + StringUtils.join(listFields, ','), HttpStatus.BAD_REQUEST);
        }
        Pageable pageable = pagination.convertToPageable();
        Page<RolesDTO> paged = rolesService.searchPaged(roleSearchDTO.getDto(), pageable, exact);
        PagedResponse<RolesDTO> response = new PagedResponse<>(paged.getContent(), paged.getNumber(), paged.getSize(), paged.getTotalElements(), paged.getTotalPages(), paged.isLast());
        return ResponseHandler.generateResponseSuccess("", response);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody @Validated RolesDTO rolesDTO) {
        //validate parameters
        UUID organizationid = null;
        if (StringUtils.isEmpty(rolesDTO.getRolename())) {
            return ResponseHandler.generateResponseError("Role name not empty", HttpStatus.BAD_REQUEST);
        }
        if (rolesDTO.getRolename().equalsIgnoreCase("SUPER_ADMIN")
                || rolesDTO.getRolename().equalsIgnoreCase("ADMIN")
                || rolesDTO.getRolename().equalsIgnoreCase("USER")) {
            return ResponseHandler.generateResponseError("Role name not default roles", HttpStatus.BAD_REQUEST);
        }

        if (rolesDTO.getRoletype() == null || rolesDTO.getRoletype() > UserType.USER.getValue() || rolesDTO.getRoletype() < UserType.ADMIN.getValue()) {
            return ResponseHandler.generateResponseError("UserType from 1 to 2", HttpStatus.NOT_FOUND);
        }
        if (rolesDTO.getOrganizationid() != null && !organizationsService.existsById(rolesDTO.getOrganizationid())) {
            return ResponseHandler.generateResponseError("Organization ID not found", HttpStatus.NOT_FOUND);
        }

        if (rolesDTO.getOrganizationid() != null) {
            organizationid = rolesDTO.getOrganizationid();
        } else {
            organizationid = organizationsService.getDefaultOrganizationId();
            rolesDTO.setOrganizationid(organizationid);
        }
        if (rolesService.existsByRolenameAndOrganizationId(rolesDTO.getRolename(), organizationid)) {
            return ResponseHandler.generateResponseError("Role name already exists", HttpStatus.BAD_REQUEST);
        }
        ////////////////////////////////
        int count = rolesService.addRolesDTO(rolesDTO);
        if (count == 0) {
            return ResponseHandler.generateResponseError("Save User fail", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseHandler.generateResponseSuccess("Suessfully created", null);

    }

    @PostMapping("/update")
    public ResponseEntity<Object> update(@RequestBody @Validated RolesDTO rolesDTO) {
        JSONObject jsonObject = ClassUtils.newJSONObject(rolesDTO);
        //validate parameters
        if (rolesDTO.getRoleid() == null) {
            return ResponseHandler.generateResponseError("Role Id, name not empty", HttpStatus.BAD_REQUEST);
        }
        if (jsonObject != null && ClassUtils.existsParameter(jsonObject, "rolename") && !StringUtils.isEmpty(rolesDTO.getRolename()) &&
                (rolesDTO.getRolename().equalsIgnoreCase("SUPER_ADMIN")
                        || rolesDTO.getRolename().equalsIgnoreCase("ADMIN")
                        || rolesDTO.getRolename().equalsIgnoreCase("USER"))) {
            return ResponseHandler.generateResponseError("Role name not default roles", HttpStatus.BAD_REQUEST);
        }
        if (jsonObject != null && ClassUtils.existsParameter(jsonObject, "roletype") && rolesDTO.getRoletype() != null && (rolesDTO.getRoletype() > UserType.USER.getValue() || rolesDTO.getRoletype() < UserType.ADMIN.getValue())) {
            return ResponseHandler.generateResponseError("UserType from 1 to 2", HttpStatus.NOT_FOUND);
        }
        if (jsonObject != null && ClassUtils.existsParameter(jsonObject, "organizationid") && rolesDTO.getOrganizationid() != null && !organizationsService.existsById(rolesDTO.getOrganizationid())) {
            return ResponseHandler.generateResponseError("Organization ID not found", HttpStatus.NOT_FOUND);
        }
        ////////////////////////////////
        int count = rolesService.update(rolesDTO);
        if (count == 0) {
            return ResponseHandler.generateResponseError("Save Roles fail", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseHandler.generateResponseSuccess("Suessfully updated", null);

    }

    @PostMapping("/delete")
    public ResponseEntity<Object> delete(@RequestParam(name = "roleid", required = true) UUID roleid) {
        if (rolesService.deleteById(roleid) == 0) {
            return ResponseHandler.generateResponseError("Delete fail", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseHandler.generateResponseSuccess("Suessfully deleted", null);
    }

    @PostMapping("/assignUser")
    public ResponseEntity<Object> assignUser(@RequestBody @Validated RoleAddUsersDTO roleAddUsersDTO) {
        //validate parameters
        if (roleAddUsersDTO.getRoleid() == null || roleAddUsersDTO.getUserid() == null || roleAddUsersDTO.getUserid().size() == 0) {
            return ResponseHandler.generateResponseError("Invalid parameters. Role ID and list User ID not null", HttpStatus.BAD_REQUEST);
        }
        if (!rolesService.existById(roleAddUsersDTO.getRoleid())) {
            return ResponseHandler.generateResponseError("Role ID not found", HttpStatus.NOT_FOUND);
        }
        if (!usersService.existsByListUserId(roleAddUsersDTO.getUserid())) {
            return ResponseHandler.generateResponseError("Some User ID not exists", HttpStatus.BAD_REQUEST);
        }
        ////////////////////////////////
        int count = rolesService.addRelationshipUserIdAndRoleId(roleAddUsersDTO);
        if (count == 0) {

            return ResponseHandler.generateResponseError("Assign User fail", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseHandler.generateResponseSuccess("Successfully assigned", null);

    }

    @PostMapping("/removeUser")
    public ResponseEntity<Object> removeUser(@RequestBody @Validated RoleAddUsersDTO roleAddUsersDTO) {
        //validate parameters
        if (roleAddUsersDTO.getRoleid() == null || roleAddUsersDTO.getUserid() == null || roleAddUsersDTO.getUserid().size() == 0) {
            return ResponseHandler.generateResponseError("Invalid parameters. Role ID and list User ID not null", HttpStatus.BAD_REQUEST);
        }
        ////////////////////////////////
        int count = rolesService.deleteRelationshipUserIdAndRoleId(roleAddUsersDTO);
        if (count == 0) {
            return ResponseHandler.generateResponseError("Remove fail", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseHandler.generateResponseSuccess("Successfully remove", null);
    }

    @PostMapping("/assignModule")
    public ResponseEntity<Object> assignModule(@RequestBody @Validated RoleAddModulesDTO roleAddModulesDTO) {
        //validate parameters
        if (roleAddModulesDTO.getRoleid() == null || roleAddModulesDTO.getModuleid() == null || roleAddModulesDTO.getModuleid().isEmpty()) {
            return ResponseHandler.generateResponseError("Invalid parameters. Role ID and list module ID not null", HttpStatus.BAD_REQUEST);
        }
        if (!rolesService.existById(roleAddModulesDTO.getRoleid())) {
            return ResponseHandler.generateResponseError("Role ID not found", HttpStatus.NOT_FOUND);
        }
        if (!modulesService.existsByListUserId(roleAddModulesDTO.getModuleid())) {
            return ResponseHandler.generateResponseError("Some Module ID not exists", HttpStatus.BAD_REQUEST);
        }
        ////////////////////////////////
        int count = rolesService.addRelationshipModuleIdAndRoleId(roleAddModulesDTO);
        if (count == 0) {

            return ResponseHandler.generateResponseError("Assign Module fail", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseHandler.generateResponseSuccess("Successfully assigned", null);

    }

    @PostMapping("/removeModule")
    public ResponseEntity<Object> removeModule(@RequestBody @Validated RoleAddModulesDTO roleAddModulesDTO) {
        //validate parameters
        if (roleAddModulesDTO.getRoleid() == null || roleAddModulesDTO.getModuleid() == null || roleAddModulesDTO.getModuleid().isEmpty()) {
            return ResponseHandler.generateResponseError("Invalid parameters. Role ID and list module ID not null", HttpStatus.BAD_REQUEST);
        }
        ////////////////////////////////
        int count = rolesService.deleteRelationshipModuleIdAndRoleId(roleAddModulesDTO);
        if (count == 0) {

            return ResponseHandler.generateResponseError("Remove Module fail", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseHandler.generateResponseSuccess("Successfully removed", null);
    }
}
