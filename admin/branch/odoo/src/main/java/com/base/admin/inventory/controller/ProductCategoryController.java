package com.base.admin.inventory.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.base.admin.constant.APIConstant;
import com.base.admin.handler.ResponseHandler;
import com.base.admin.inventory.dto.request.ProductCategoryDTO;
import com.base.admin.inventory.entity.ProductCategory;
import com.base.admin.inventory.service.ProductCategoryService;

@RestController
@RequestMapping(APIConstant.INVENTORY + "/product-category")
public class ProductCategoryController {
    private final ProductCategoryService productCategoryService;

    public ProductCategoryController(ProductCategoryService productCategoryService) {
        this.productCategoryService = productCategoryService;
    }

    @PostMapping("/findById")
    public ResponseEntity<Object> findById(
            @RequestParam(name = "productCategoryId", required = true) UUID productCategoryId) {

        return null;
    }

    /*    @PostMapping("/search")*/

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody ProductCategoryDTO request) {
        int count = productCategoryService.create(request);
        if (count == 0) {
            return ResponseHandler.generateResponseError(
                    "Failed to add product category", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseHandler.generateResponseSuccess("Product Attribute added successfully", null);
    }

    @PostMapping("/update")
    public ResponseEntity<Object> update(@RequestBody ProductCategory request) {

        if (request.getId() == null) {
            return ResponseHandler.generateResponseError(
                    "Invalid parameter. Product Category Attributre ID not null", HttpStatus.BAD_REQUEST);
        }
        int count = productCategoryService.update(request);
        if (count == 0) {
            return ResponseHandler.generateResponseError(
                    "Faild to update product category", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseHandler.generateResponseSuccess("Product Category updated successfully", null);
    }

    @PostMapping("/delete")
    public ResponseEntity<Object> delete(@RequestParam(name = "productCategoryId", required = true) UUID id) {
        int count = productCategoryService.deleteById(id);
        if (count == 0) {
            return ResponseHandler.generateResponseError("Product category not found", HttpStatus.NOT_FOUND);
        }
        return ResponseHandler.generateResponseSuccess("Product category deleted successfully", null);
    }
}
