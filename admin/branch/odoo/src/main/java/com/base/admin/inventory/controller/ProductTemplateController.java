package com.base.admin.inventory.controller;

import com.base.admin.constant.APIConstant;
import com.base.admin.handler.ResponseHandler;
import com.base.admin.inventory.dto.request.AttributeDTO;
import com.base.admin.inventory.dto.request.ProductTemplateDTO;
import com.base.admin.inventory.entity.ProductTemplate;
import com.base.admin.inventory.service.ProductTemplateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(APIConstant.INVENTORY + "/product-template")
public class ProductTemplateController {
    private final ProductTemplateService productTemplateService;

    public ProductTemplateController(ProductTemplateService productTemplateService) {
        this.productTemplateService = productTemplateService;
    }

    @PostMapping("/findById")
    public ResponseEntity<Object> findById(@RequestParam(name = "productTemplateId") UUID id) {
        ProductTemplate productTemplate = productTemplateService.findById(id);
        if (productTemplate == null) {
            ResponseHandler.generateResponseError("Product template not found", HttpStatus.NOT_FOUND);
        }
        return ResponseHandler.generateResponseSuccess("", productTemplate);
    }

    /**
     * Tạo 1 product mới với các giá trị thuộc tính cơ bản
     * Đồng thời tạo 1 product_product tương ứng với product vừa tạo.
     */
    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody ProductTemplateDTO request) {
        int count = productTemplateService.create(request);
        if (count == 0) {
            return ResponseHandler.generateResponseError(
                    "Failed to add Product template", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseHandler.generateResponseSuccess("Create Product template successfully", null);
    }

    @PostMapping("/{template_id}/attributes/create")
    public ResponseEntity<Object> createAttributes(
            @PathVariable(name = "template_id") UUID templateId, @RequestBody List<AttributeDTO> attributeRequestList) {
        int count = productTemplateService.createAttributes(templateId, attributeRequestList);
        if (count == 0) {
            return ResponseHandler.generateResponseError(
                    "Failed to add Product template attributes", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseHandler.generateResponseSuccess("Create Product template attributes successfully", null);
    }

    //    @PostMapping("/search")

    @PostMapping("/deleteById")
    public ResponseEntity<Object> deleteById(@RequestParam(name = "productTemplateId") UUID id) {
        int count = productTemplateService.deleteById(id);
        if (count == 0) {
            return ResponseHandler.generateResponseError("Product template not found", HttpStatus.NOT_FOUND);
        }
        return ResponseHandler.generateResponseSuccess("Product template deleted successfully", null);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable UUID id) {
        int count = productTemplateService.unActive(id);
        if (count == 0) {
            return ResponseHandler.generateResponseError(
                    "Un active product template sucessfully", HttpStatus.NOT_FOUND);
        }
        return ResponseHandler.generateResponseSuccess("Active product template sucessfully", null);
    }

    @PostMapping("/active/{id}")
    public ResponseEntity<Object> active(@PathVariable UUID id) {
        int count = productTemplateService.unActive(id);
        if (count == 0) {
            return ResponseHandler.generateResponseError("Product template found", HttpStatus.NOT_FOUND);
        }
        return ResponseHandler.generateResponseSuccess("Active product template successfull", null);
    }

    @PostMapping("/update")
    public ResponseEntity<Object> update(@RequestBody ProductTemplate request) {
        if (request.getId() == null) {
            return ResponseHandler.generateResponseError(
                    "Invalid parameters. Product template ID not null", HttpStatus.BAD_REQUEST);
        }
        int count = productTemplateService.update(request);
        if (count == 0) {
            return ResponseHandler.generateResponseError(
                    "Failed to update Product template", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseHandler.generateResponseSuccess("Product template updated successfully", null);
    }
}
