package com.base.admin.inventory.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.base.admin.constant.APIConstant;
import com.base.admin.handler.ResponseHandler;
import com.base.admin.inventory.dto.request.StockPickingDTO;
import com.base.admin.inventory.service.StockPickingService;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@RestController
@RequestMapping(APIConstant.INVENTORY + "/stock-picking")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StockPickingController {

    StockPickingService stockPickingService;

    public StockPickingController(StockPickingService stockPickingService) {
        this.stockPickingService = stockPickingService;
    }

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody StockPickingDTO request) {
        var count = stockPickingService.create(request);
        if (count == 0) {
            return ResponseHandler.generateResponseError("Failed to create stock picking", HttpStatus.BAD_REQUEST);
        }
        return ResponseHandler.generateResponseSuccess("Create stock picking successfully!", null);
    }
}
