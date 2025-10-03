package com.base.admin.hrm.controller;

import com.base.admin.dto.PagedResponse;
import com.base.admin.dto.Pagination;
import com.base.admin.handler.ResponseHandler;
import com.base.admin.hrm.dto.EmployeesDTO;
import com.base.admin.hrm.dto.EmployeesSearchDTO;
import com.base.admin.hrm.entity.Avatars;
import com.base.admin.hrm.service.AvatarService;
import com.base.admin.hrm.service.EmployeesService;
import com.base.admin.utils.ClassUtils;
import jakarta.validation.constraints.NotNull;
import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.json.JSONObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v1/hrm/employees")
@RestController
public class EmployeeController {

    private final EmployeesService employeesService;
    private final AvatarService avatarService;

    public EmployeeController(EmployeesService employeesService, AvatarService avatarService) {
        this.employeesService = employeesService;
        this.avatarService = avatarService;
    }

    @PostMapping("/findById")
    public ResponseEntity<Object> findById(@RequestParam(name = "employeeid", required = true) UUID employeeid) {
        EmployeesDTO employee = employeesService.findDTOById(employeeid);
        if (employee == null) {
            return ResponseHandler.generateResponseError("Employee not found", HttpStatus.NOT_FOUND);
        }
        Avatars avatar = avatarService.getBase64avatarByEmployeeId(employee.getUserid());
        if (avatar != null) {
            employee.setBase64avatar(avatar.getBase64avatar());
        }
        return ResponseHandler.generateResponseSuccess("", employee);
    }

    @PostMapping(value = "/search")
    public ResponseEntity<Object> search(@RequestBody EmployeesSearchDTO employeesSearchDTO, @RequestParam(required = false, defaultValue = "false") boolean exact) {
        Pagination pagination = employeesSearchDTO.getPagination();
        List<String> listFields = ClassUtils.getAllPropertyNames(EmployeesDTO.class);

        if (!pagination.isValidSortField(listFields)) {
            return ResponseHandler.generateResponseError("sortFiels invalid. In list: " + StringUtils.join(listFields, ','), HttpStatus.BAD_REQUEST);
        }
        Pageable pageable = pagination.convertToPageable();
        Page<EmployeesDTO> paged = employeesService.searchPaged(employeesSearchDTO.getDto(), pageable, exact);
        if (!paged.getContent().isEmpty()) {
            List<UUID> userIds = paged.getContent().stream().map(EmployeesDTO::getUserid).toList();
            List<Avatars> avatars = avatarService.getBase64avatarsByUserIds(userIds);
            if (!avatars.isEmpty()) {
                for (EmployeesDTO employee : paged.getContent()) {
                    for (Avatars avatar : avatars) {
                        if (employee.getUserid().equals(avatar.getUserid())) {
                            employee.setBase64avatar(avatar.getBase64avatar());
                            break;
                        }
                    }
                }

            }
        }
        PagedResponse<EmployeesDTO> response = new PagedResponse<>(paged.getContent(), paged.getNumber(), paged.getSize(), paged.getTotalElements(), paged.getTotalPages(), paged.isLast());
        return ResponseHandler.generateResponseSuccess("", response);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody @Validated EmployeesDTO employeesDTO) {
        //validate parameters
        if (StringUtils.isEmpty(employeesDTO.getEmployeecode()) || StringUtils.isEmpty(employeesDTO.getFullname())) {
            return ResponseHandler.generateResponseError("Invalid parameters. employee code, full name not null", HttpStatus.BAD_REQUEST);
        }
        if (employeesDTO.getFullname() != null && employeesService.existsByFullname(employeesDTO.getFullname())) {
            return ResponseHandler.generateResponseError("Employee name is already exists", HttpStatus.BAD_REQUEST);
        }
        if (employeesDTO.getEmployeecode() != null && employeesService.existsByEmployeeCode(employeesDTO.getEmployeecode())) {
            return ResponseHandler.generateResponseError("Employee code is already exists", HttpStatus.BAD_REQUEST);
        }
        ////////////////////////////////
        int count = employeesService.addEmployeeDTO(employeesDTO);
        if (count == 0) {
            return ResponseHandler.generateResponseError("Save Employee fail", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseHandler.generateResponseSuccess("Suessfully created", null);

    }

    @PostMapping("/update")
    public ResponseEntity<Object> update(@RequestBody @Validated EmployeesDTO employeesDTO) {
        JSONObject jsonObject = ClassUtils.newJSONObject(employeesDTO);
        //validate parameters
        if (employeesDTO.getEmployeeid() == null) {
            return ResponseHandler.generateResponseError("Invalid parameters. Employee ID not null", HttpStatus.BAD_REQUEST);
        }

        if (jsonObject != null && ClassUtils.existsParameter(jsonObject, "employeecode") && employeesDTO.getEmployeecode() != null && employeesService.existsByEmployeeCodeAndDifferentEmployeeId(employeesDTO.getEmployeecode(), employeesDTO.getEmployeeid())) {
            return ResponseHandler.generateResponseError("Employee Code already exists", HttpStatus.BAD_REQUEST);
        }

//        if (jsonObject != null && ClassUtils.existsParameter(jsonObject, "fullname") && employeesDTO.getFullname() != null && !employeesService.existsByFullnameAndDifferentEmployeeId(employeesDTO.getFullname(), employeesDTO.getEmployeeid())) {
//            return ResponseHandler.generateResponseError("Employee name already exists", HttpStatus.BAD_REQUEST);
//        }
        ////////////////////////////////
        int count = employeesService.update(employeesDTO);
        if (count == 0) {
            return ResponseHandler.generateResponseError("Save User fail", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseHandler.generateResponseSuccess("Suessfully updated", null);

    }

    @PostMapping("/delete")
    public ResponseEntity<Object> delete(@RequestParam(name = "employeeid", required = true) UUID employeeid) {
        if (employeesService.deleteById(employeeid) == 0) { //TODO: Delete relationship
            return ResponseHandler.generateResponseError("Employee not found", HttpStatus.NOT_FOUND);
        }
        return ResponseHandler.generateResponseSuccess("Suessfully deleted", null);
    }

    @PostMapping("/deleteByIds")
    public ResponseEntity<Object> deleteByIds(@RequestBody List<UUID> listEmployeeid) {
        if (employeesService.deleteByIds(listEmployeeid) == 0) { //TODO: Delete relationship
            return ResponseHandler.generateResponseError("Employee not found", HttpStatus.NOT_FOUND);
        }
        return ResponseHandler.generateResponseSuccess("Suessfully deleted", null);
    }

    @PostMapping(value = "/uploadavatar", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Object> uploadavatar(@RequestParam("uploadfile") @NotNull MultipartFile uploadfile, @RequestParam(name = "userid", required = true) UUID userid) throws IOException {
        if (uploadfile.isEmpty()) {
            return ResponseHandler.generateResponseError("File is Empty", HttpStatus.BAD_REQUEST);
        }
        boolean exists = employeesService.existsByUserId(userid);
        if (!exists) {
            return ResponseHandler.generateResponseError("User not found", HttpStatus.NOT_FOUND);
        }

        String filename = uploadfile.getOriginalFilename();

        //convert the uploaded file to byte array
        byte[] imageArr = uploadfile.getBytes();
        //Base64 that converts imageâs bytes to
        //base64 encoded string, and this string store in a
        //varchar column of database.
        String imageAsString = Base64.encodeBase64String(imageArr);
        // to database}


        int count = employeesService.addOrupdateAvatar(userid, filename, imageAsString);
        if (count == 0) {
            return ResponseHandler.generateResponseError("Update avatar fail", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseHandler.generateResponseSuccess("Suessfully avatar updated", null);
    }

    @PostMapping("/removeAvatar")
    public ResponseEntity<Object> removeAvatar(@RequestParam(name = "userid", required = true) UUID userid) {
        int count = employeesService.removeAvatar(userid);
        if (count == 0) {
            return ResponseHandler.generateResponseError("Remove avatar fail", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseHandler.generateResponseSuccess("Suessfully avatar removed", null);
    }

}
