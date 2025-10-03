package com.base.admin.inventory.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.base.admin.constant.APIConstant;
import com.base.admin.handler.ResponseHandler;
import com.base.admin.inventory.dto.request.ProductProductDTO;
import com.base.admin.inventory.dto.request.ProductProductUpdateDTO;
import com.base.admin.inventory.entity.ProductProduct;
import com.base.admin.inventory.service.ProductProductService;

/*
 * Tạo product template
 * Thêm thuộc tính và giá trị cho vào product_template để tạo các biến thể
 * {"product_attribute_name": "",  "product_values": ["giá trị 1", "giá trị 2", ...] }
 * */

@RestController
@RequestMapping(APIConstant.INVENTORY + "/product-product")
public class ProductProductController {
    private final ProductProductService productProductService;

    public ProductProductController(ProductProductService productProductService) {
        this.productProductService = productProductService;
    }

    /*
     * @PostMapping("/create")
     * Tạo 1 sp mới với các giá trị thuộc tính cơ bản
     */

    /*
     * @PostMapping("/{template_id}/attributes/create"
     * Thêm các thuộc tính và giá trị thuộc tính vào mẫu sản phẩm để tạo các biến thể.
     * {
    	"attribute_name": "Tên thuộc tính",
    	"attribute_values": ["Giá trị 1", "Giá trị 2", ...]
    	}
     *
     * @PostMapping("/{template_id}/variants")
     * Tạo các biến thể sản phẩm dựa trên các thuộc tính đã xác định trong mẫu sản phẩm.
     * {
    "variant_combinations": [
    			{
    			"attribute_value_ids": [1, 2],
    			"sku": "Mã SKU",
    			"price": "Giá bán"
    			},
    			...
    		]
    	}

     * */
    @PostMapping("/findById")
    public ResponseEntity<Object> findById(@RequestParam(name = "productProductId") UUID id) {
        ProductProduct productProduct = productProductService.findById(id);
        if (productProduct == null) {
            ResponseHandler.generateResponseError("Product product not found", HttpStatus.NOT_FOUND);
        }
        return ResponseHandler.generateResponseSuccess("", productProduct);
    }

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody ProductProductDTO request) {

        int count = productProductService.create(request);
        if (count == 0) {
            return ResponseHandler.generateResponseError(
                    "Failed to add Product product", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseHandler.generateResponseSuccess("Create Product product successfully", null);
    }

    //    @PostMapping("/search")

    @PostMapping("/deleteById")
    public ResponseEntity<Object> deleteById(@RequestParam(name = "productProductId") UUID id) {
        int count = productProductService.deleteById(id);
        if (count == 0) {
            return ResponseHandler.generateResponseError("Product product not found", HttpStatus.NOT_FOUND);
        }

        return ResponseHandler.generateResponseSuccess("Product product deleted successfully", null);
    }

    @PostMapping("/delete/{productId}")
    public ResponseEntity<Object> delete(@PathVariable(name = "productId") UUID productId) {
        int count = productProductService.unActiveProduct(productId);

        if (count == 0) {
            return ResponseHandler.generateResponseError("Product not found", HttpStatus.NOT_FOUND);
        }

        return ResponseHandler.generateResponseSuccess("Product deleted successfully", null);
    }

    @PostMapping("/active/{productId}")
    public ResponseEntity<Object> active(@PathVariable(name = "productId") UUID productId) {
        int count = productProductService.activeProduct(productId);
        if (count == 0) {
            return ResponseHandler.generateResponseError("Product not found", HttpStatus.NOT_FOUND);
        }
        return ResponseHandler.generateResponseSuccess("Active product successfully", null);
    }

    @PostMapping("/update")
    public ResponseEntity<Object> update(@RequestBody ProductProductUpdateDTO request) {
        if (request.getId() == null) {
            return ResponseHandler.generateResponseError("Invalid parameters. Product product ID not null", null);
        }
        int count = productProductService.update(request);
        if (count == 0) {
            return ResponseHandler.generateResponseError(
                    "Faild to update Product product", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return ResponseHandler.generateResponseSuccess("Product product updated successfully", null);
    }
}
