package com.base.admin.controller;

import com.base.admin.dto.*;
import com.base.admin.handler.ResponseHandler;
import com.base.admin.service.OrganizationsService;
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
@RequestMapping("/api/v1/settings/org")
@RestController
public class OrganizationController {
    private final OrganizationsService organizationsService;
    private final UsersService usersService;

    public OrganizationController(OrganizationsService organizationsService, UsersService usersService) {
        this.organizationsService = organizationsService;
        this.usersService = usersService;
    }

    @PostMapping("/findById")
    public ResponseEntity<Object> findById(@RequestParam(name = "organizationid", required = true) UUID organizationid) {
        OrganizationsDTO org = organizationsService.findDTOById(organizationid);
        if (org == null) {
            return ResponseHandler.generateResponseError("Organization not found", HttpStatus.NOT_FOUND);
        }
        return ResponseHandler.generateResponseSuccess("", org);
    }

    @PostMapping(value = "/search")
    public ResponseEntity<Object> search(@RequestBody OrganizationsSearchDTO orgSearchDTO, @RequestParam(required = false, defaultValue = "false") boolean exact) {
        Pagination pagination = orgSearchDTO.getPagination();
        List<String> listFields = ClassUtils.getAllPropertyNames(OrganizationsDTO.class);

        if (!pagination.isValidSortField(listFields)) {
            return ResponseHandler.generateResponseError("sortFiels invalid. In list: " + StringUtils.join(listFields, ','), HttpStatus.BAD_REQUEST);
        }
        Pageable pageable = pagination.convertToPageable();

        Page<OrganizationsDTO> paged = organizationsService.searchPaged(orgSearchDTO.getDto(), pageable, exact);
        PagedResponse<OrganizationsDTO> response = new PagedResponse<>(paged.getContent(), paged.getNumber(), paged.getSize(), paged.getTotalElements(), paged.getTotalPages(), paged.isLast());
        return ResponseHandler.generateResponseSuccess("", response);
    }

//    @PostMapping(value = "/searchUser")
//    public ResponseEntity<Object> searchUser(@RequestBody UsersSearchDTO usersSearchDTO, @RequestParam(name = "organizationid", required = true) UUID organizationid, @RequestParam(required = false, defaultValue = "false") boolean exact) {
//        Pagination pagination = usersSearchDTO.getPagination();
//        List<String> listFields = ClassUtils.getAllPropertyNames(UsersDTO.class);
//
//        if (!pagination.isValidSortField(listFields)) {
//            return ResponseHandler.generateResponseError("sortFiels invalid. In list: " + StringUtils.join(listFields, ','), HttpStatus.BAD_REQUEST);
//        }
//        Pageable pageable = pagination.convertToPageable();
//
//        Page<UsersDTO> paged = usersService.searchPagedWithOrganizationId(usersSearchDTO.getDto(), pageable, organizationid, exact);
//        PagedResponse<UsersDTO> response = new PagedResponse<>(paged.getContent(), paged.getNumber(), paged.getSize(), paged.getTotalElements(), paged.getTotalPages(), paged.isLast());
//        return ResponseHandler.generateResponseSuccess("", response);
//    }

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody @Validated OrganizationsDTO organizationsDTO) {
        //validate parameters
        if (StringUtils.isEmpty(organizationsDTO.getOrganizationname()) || organizationsService.existsByOrganizationName(organizationsDTO.getOrganizationname())) {
            return ResponseHandler.generateResponseError("Organization name not null or already exists", HttpStatus.BAD_REQUEST);
        }

        if (organizationsDTO.getParentorganizationid() != null && !organizationsService.existsById(organizationsDTO.getParentorganizationid())) {
            return ResponseHandler.generateResponseError("Organization not exists", HttpStatus.BAD_REQUEST);
        }
        ////////////////////////////////
        int count = organizationsService.addOrganizationDTO(organizationsDTO);
        if (count == 0) {
            return ResponseHandler.generateResponseError("Save Organization fail", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseHandler.generateResponseSuccess("Suessfully created", null);

    }

    @PostMapping("/update")
    public ResponseEntity<Object> update(@RequestBody @Validated OrganizationsDTO organizationsDTO) {
        JSONObject jsonObject = ClassUtils.newJSONObject(organizationsDTO);
        //validate parameters
        if (organizationsDTO.getOrganizationid() == null) {
            return ResponseHandler.generateResponseError("Organization ID or name not null", HttpStatus.BAD_REQUEST);
        }
        if (jsonObject != null && ClassUtils.existsParameter(jsonObject, "parentorganizationid") && organizationsDTO.getParentorganizationid() != null && organizationsDTO.getOrganizationid().equals(organizationsDTO.getParentorganizationid())) {
            return ResponseHandler.generateResponseError("Organization not same with parent", HttpStatus.BAD_REQUEST);
        }
        if (jsonObject != null && ClassUtils.existsParameter(jsonObject, "parentorganizationid") &&
                (organizationsDTO.getParentorganizationid() != null && !organizationsService.existsById(organizationsDTO.getParentorganizationid()))) {
            return ResponseHandler.generateResponseError("Organization not exists", HttpStatus.BAD_REQUEST);
        }
        if (jsonObject != null && ClassUtils.existsParameter(jsonObject, "organizationid") && !organizationsService.existsById(organizationsDTO.getOrganizationid())) {
            return ResponseHandler.generateResponseError("Organization ID not exists", HttpStatus.BAD_REQUEST);
        }
        if (jsonObject != null && ClassUtils.existsParameter(jsonObject, "organizationname") &&
                (organizationsDTO.getOrganizationid() != null && organizationsDTO.getOrganizationname() != null &&
                        organizationsService.existsByNameAndDifferentId(organizationsDTO.getOrganizationid(), organizationsDTO.getOrganizationname()))) {
            return ResponseHandler.generateResponseError("Other Organization name already exists", HttpStatus.BAD_REQUEST);
        }
        ////////////////////////////////
        int count = organizationsService.update(organizationsDTO);
        if (count == 0) {
            return ResponseHandler.generateResponseError("Save User fail", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseHandler.generateResponseSuccess("Suessfully updated", null);

    }

    @PostMapping("/delete")
    public ResponseEntity<Object> delete(@RequestParam(name = "organizationid", required = true) UUID organizationid) {
        //validate parameters
        OrganizationsDTO organizationsDTO = organizationsService.findDTOById(organizationid);
        if (organizationsDTO == null || organizationsDTO.getOrganizationname().equalsIgnoreCase("DEFAULT")) {
            return ResponseHandler.generateResponseError("Organization not found or Organization is default", HttpStatus.BAD_REQUEST);
        }
        ////////////////////////////////
        if (organizationsService.deleteById(organizationid) == 0) {
            return ResponseHandler.generateResponseError("Organization not found", HttpStatus.NOT_FOUND);
        }
        return ResponseHandler.generateResponseSuccess("Suessfully deleted", null);

    }

    @PostMapping("/assignUser")
    public ResponseEntity<Object> assignUser(@RequestBody @Validated OrgAddUsersDTO orgAddUsersDTO) {
        //validate parameters
        if (orgAddUsersDTO.getOrganizationid() == null || orgAddUsersDTO.getUserid() == null || orgAddUsersDTO.getUserid().isEmpty()) {
            return ResponseHandler.generateResponseError("Invalid parameters", HttpStatus.BAD_REQUEST);
        }
        if (!organizationsService.existsById(orgAddUsersDTO.getOrganizationid())) {
            return ResponseHandler.generateResponseError("Organization ID not exists", HttpStatus.BAD_REQUEST);
        }
        if (!usersService.existsByListUserId(orgAddUsersDTO.getUserid())) {
            return ResponseHandler.generateResponseError("Some User ID not exists", HttpStatus.BAD_REQUEST);
        }
        ////////////////////////////////
        int count = organizationsService.addRelationshipUserIdAndOrgId(orgAddUsersDTO);
        if (count == 0) {

            return ResponseHandler.generateResponseError("Assign User fail", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseHandler.generateResponseSuccess("Successfully assigned", null);
    }

    @PostMapping("/removeUser")
    public ResponseEntity<Object> removeUser(@RequestBody @Validated OrgAddUsersDTO orgAddUsersDTO) {
        //validate parameters
        if (orgAddUsersDTO.getOrganizationid() == null || orgAddUsersDTO.getUserid() == null || orgAddUsersDTO.getUserid().isEmpty()) {
            return ResponseHandler.generateResponseError("Invalid parameters", HttpStatus.BAD_REQUEST);
        }
        ////////////////////////////////
        int count = organizationsService.deleteRelationshipUserIdAndOrgId(orgAddUsersDTO);
        if (count == 0) {
            return ResponseHandler.generateResponseError("Remove fail", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseHandler.generateResponseSuccess("Successfully remove", null);
    }

}
