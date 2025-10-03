package com.base.admin.controller;

import com.base.admin.dto.*;
import com.base.admin.entity.Permissions;
import com.base.admin.handler.ResponseHandler;
import com.base.admin.service.ModulesService;
import com.base.admin.utils.ClassUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/settings/module")
public class ModuleController {

    private final ModulesService modulesService;

    public ModuleController(ModulesService modulesService) {
        this.modulesService = modulesService;
    }

    @PostMapping("/findById")
    public ResponseEntity<Object> findById(@RequestParam(name = "moduleid", required = true) UUID moduleid) {
        ModulesDTO module = modulesService.findDTOById(moduleid);
        if (module == null) {
            return ResponseHandler.generateResponseError("Organization not found", HttpStatus.NOT_FOUND);
        }
        return ResponseHandler.generateResponseSuccess("", module);
    }

    @PostMapping(value = "/search")
    public ResponseEntity<Object> search(@RequestBody ModulesSearchDTO modulesSearchDTO, @RequestParam(required = false, defaultValue = "false") boolean exact) {
        Pagination pagination = modulesSearchDTO.getPagination();
        List<String> listFields = ClassUtils.getAllPropertyNames(ModulesDTO.class);

        if (!pagination.isValidSortField(listFields)) {
            return ResponseHandler.generateResponseError("sortFiels invalid. In list: " + StringUtils.join(listFields, ','), HttpStatus.BAD_REQUEST);
        }
        Pageable pageable = pagination.convertToPageable();

        Page<ModulesDTO> paged = modulesService.searchPaged(modulesSearchDTO.getDto(), pageable, exact);
        PagedResponse<ModulesDTO> response = new PagedResponse<>(paged.getContent(), paged.getNumber(), paged.getSize(), paged.getTotalElements(), paged.getTotalPages(), paged.isLast());
        return ResponseHandler.generateResponseSuccess("", response);
    }

    @PostMapping("/findByRoleId")
    public ResponseEntity<Object> findByRoleId(@RequestParam(name = "roleId", required = true) UUID roleId) {
        List<ModulesDTO> modules = modulesService.findByRoleId(roleId);

        return ResponseHandler.generateResponseSuccess("", modules);
    }

    @PostMapping("/findMenuItemByRoleIdAndModuleId")
    public ResponseEntity<Object> findMenuItemByRoleIdAndModuleId(@RequestParam(name = "roleId", required = true) UUID roleId,
                                                                  @RequestParam(name = "moduleId", required = true) UUID moduleId) {
        List<PagesDTO> pages = modulesService.findMenuItemByRoleIdAndModuleId(roleId, moduleId);

        return ResponseHandler.generateResponseSuccess("", pages);
    }

    @PostMapping("/selecttedMenuItem")
    public ResponseEntity<Object> selecttedMenuItem(@RequestParam(name = "roleId", required = true) UUID roleId,
                                                    @RequestParam(name = "moduleId", required = true) UUID moduleId,
                                                    @RequestParam(name = "pageId", required = true) UUID pageId,
                                                    @RequestParam(name = "isselected", required = true) boolean isselected) {
        int count = modulesService.selecttedMenuItem(roleId, moduleId, pageId, isselected);
        if (count == 0) {
            return ResponseHandler.generateResponseError("Save item fail", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseHandler.generateResponseSuccess("Suessfully created", null);
    }

    @PostMapping("/updatePermission")
    public ResponseEntity<Object> updatePermission(@RequestBody List<Permissions> permissions) {
        int count = modulesService.updatePermission(permissions);
        if (count == 0) {
            return ResponseHandler.generateResponseError("Save item fail", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseHandler.generateResponseSuccess("Suessfully updated", null);
    }

}
