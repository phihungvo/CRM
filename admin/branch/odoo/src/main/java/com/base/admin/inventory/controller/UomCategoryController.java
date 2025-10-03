package com.base.admin.inventory.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.base.admin.constant.APIConstant;
import com.base.admin.handler.ResponseHandler;
import com.base.admin.inventory.dto.request.UomCategoryDTO;
import com.base.admin.inventory.entity.UomCategory;
import com.base.admin.inventory.service.UomCategoryService;

@RestController()
@RequestMapping(APIConstant.INVENTORY + "/uom-category")
public class UomCategoryController {
    private final UomCategoryService uomCategoryService;

    public UomCategoryController(UomCategoryService uomCategoryService) {
        this.uomCategoryService = uomCategoryService;
    }

    @PostMapping("/findById")
    public ResponseEntity<Object> findById(@RequestParam(name = "uomCategoryId") UUID id) {
        UomCategory uomCategory = uomCategoryService.findById(id);
        if (uomCategory == null) {
            ResponseHandler.generateResponseError("Uom category not found", HttpStatus.NOT_FOUND);
        }
        return ResponseHandler.generateResponseSuccess("", uomCategory);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody UomCategoryDTO request) {
        int count = uomCategoryService.create(request);
        if (count == 0) {
            return ResponseHandler.generateResponseError(
                    "Failed to add Uom Category", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseHandler.generateResponseSuccess("Create Uom Category successfully", null);
    }
    //    @PostMapping("/search")

    @PostMapping("/deleteById")
    public ResponseEntity<Object> deleteById(@RequestParam(name = "uomCategoryId") UUID id) {
        int count = uomCategoryService.deleteById(id);
        if (count == 0) {
            return ResponseHandler.generateResponseError("Uom category not found", HttpStatus.NOT_FOUND);
        }
        return ResponseHandler.generateResponseSuccess("Uom category deleted successfully", null);
    }

    @PostMapping("/update")
    public ResponseEntity<Object> update(@RequestBody UomCategory request) {
        if (request.getId() == null) {
            return ResponseHandler.generateResponseError(
                    "Invalid parameters. Uom Category ID not null", HttpStatus.BAD_REQUEST);
        }
        int count = uomCategoryService.update(request);
        if (count == 0) {
            return ResponseHandler.generateResponseError(
                    "Failed to update Uom category", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseHandler.generateResponseSuccess("Uom category updated successfully", null);
    }
}
