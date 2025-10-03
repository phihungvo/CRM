package com.base.admin.hrm.controller;

import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.base.admin.dto.PagedResponse;
import com.base.admin.dto.Pagination;
import com.base.admin.handler.ResponseHandler;
import com.base.admin.hrm.dto.UnitItemDTO;
import com.base.admin.hrm.dto.UnitsSearchDTO;
import com.base.admin.hrm.entity.Units;
import com.base.admin.hrm.service.UnitsService;
import com.base.admin.service.OrganizationsService;
import com.base.admin.utils.ClassUtils;

@RequestMapping("/api/v1/hrm/unit")
@RestController
public class UnitController {
    private final UnitsService unitsService;
    private final OrganizationsService organizationsService;

    public UnitController(UnitsService unitsService, OrganizationsService organizationsService) {
        this.unitsService = unitsService;
        this.organizationsService = organizationsService;
    }

    @PostMapping("/findById")
    public ResponseEntity<Object> findById(@RequestParam(name = "unitid", required = true) UUID unitid) {
        Units unit = unitsService.findById(unitid);
        if (unit == null) {
            return ResponseHandler.generateResponseError("Unit not found", HttpStatus.NOT_FOUND);
        }
        return ResponseHandler.generateResponseSuccess("", unit);
    }

    @PostMapping(value = "/search")
    public ResponseEntity<Object> search(
            @RequestBody UnitsSearchDTO unitsSearchDTO,
            @RequestParam(required = false, defaultValue = "false") boolean exact) {
        Pagination pagination = unitsSearchDTO.getPagination();
        List<String> listFields = ClassUtils.getAllPropertyNames(Units.class);

        if (!pagination.isValidSortField(listFields)) {
            return ResponseHandler.generateResponseError(
                    "sortFiels invalid. In list: " + StringUtils.join(listFields, ','), HttpStatus.BAD_REQUEST);
        }
        Pageable pageable = pagination.convertToPageable();
        Page<Units> paged = unitsService.searchPaged(unitsSearchDTO.getDto(), pageable, exact);
        PagedResponse<Units> response = new PagedResponse<>(
                paged.getContent(),
                paged.getNumber(),
                paged.getSize(),
                paged.getTotalElements(),
                paged.getTotalPages(),
                paged.isLast());
        return ResponseHandler.generateResponseSuccess("", response);
    }

    @PostMapping(value = "/getTreeOfUnits")
    public ResponseEntity<Object> getTreeOfUnits(
            @RequestParam(name = "organizationid", required = true) UUID organizationid) {
        List<UnitItemDTO> response = unitsService.getTreeOfUnits(organizationid);
        return ResponseHandler.generateResponseSuccess("", response);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody @Validated Units unitDTO) {
        // validate parameters
        if (StringUtils.isEmpty(unitDTO.getUnitname()) || StringUtils.isEmpty(unitDTO.getUnitcode())) {
            return ResponseHandler.generateResponseError(
                    "Invalid parameters. Unit code, name not null", HttpStatus.BAD_REQUEST);
        }
        if (unitDTO.getOrganizationid() == null) {
            return ResponseHandler.generateResponseError("Invalid parameters. org id not null", HttpStatus.BAD_REQUEST);
        }
        if (!organizationsService.existsById(unitDTO.getOrganizationid())) {
            return ResponseHandler.generateResponseError("Organization not found", HttpStatus.NOT_FOUND);
        }
        ////////////////////////////////
        int count = unitsService.addUnit(unitDTO);
        if (count == 0) {
            return ResponseHandler.generateResponseError("Save Unit fail", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseHandler.generateResponseSuccess("Suessfully created", null);
    }

    @PostMapping("/update")
    public ResponseEntity<Object> update(@RequestBody @Validated Units unitDTO) {
        JSONObject jsonObject = ClassUtils.newJSONObject(unitDTO);
        // validate parameters
        if (unitDTO.getUnitid() == null) {
            return ResponseHandler.generateResponseError(
                    "Invalid parameters. Unit ID not null", HttpStatus.BAD_REQUEST);
        }

        if (jsonObject != null
                && ClassUtils.existsParameter(jsonObject, "organizationid")
                && !organizationsService.existsById(unitDTO.getOrganizationid())) {
            return ResponseHandler.generateResponseError("Organization not found", HttpStatus.NOT_FOUND);
        }
        ////////////////////////////////
        int count = unitsService.update(unitDTO);
        if (count == 0) {
            return ResponseHandler.generateResponseError("Save Unit fail", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseHandler.generateResponseSuccess("Suessfully updated", null);
    }

    @PostMapping("/delete")
    public ResponseEntity<Object> delete(@RequestParam(name = "unitid", required = true) UUID unitid) {
        if (unitsService.deleteById(unitid) == 0) { // TODO: Delete relationship
            return ResponseHandler.generateResponseError("Unit not found", HttpStatus.NOT_FOUND);
        }
        return ResponseHandler.generateResponseSuccess("Suessfully deleted", null);
    }
}
