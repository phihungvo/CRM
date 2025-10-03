package com.base.admin.inventory.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.base.admin.constant.APIConstant;
import com.base.admin.handler.ResponseHandler;
import com.base.admin.inventory.dto.request.StockQuantDTO;
import com.base.admin.inventory.dto.request.StockQuantUpdateDTO;
import com.base.admin.inventory.service.StockQuantService;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@RestController
@RequestMapping(APIConstant.INVENTORY + "/stock-quant")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StockQuantController {

    StockQuantService stockQuantService;

    public StockQuantController(StockQuantService stockQuantService) {
        this.stockQuantService = stockQuantService;
    }

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody StockQuantDTO stockQuant) {
        int count = stockQuantService.create(stockQuant);
        if (count == 0) {
            return ResponseHandler.generateResponseError("Create stock quant failed", HttpStatus.BAD_REQUEST);
        }
        return ResponseHandler.generateResponseError("Create stock quant success", null);
    }

    @PostMapping("/findById")
    public ResponseEntity<Object> findById(@RequestParam(name = "stockQuantId") UUID id) {
        int count = stockQuantService.findById(id);
        if (count == 0) {
            return ResponseHandler.generateResponseError("Stock quant not found", HttpStatus.NOT_FOUND);
        }
        return ResponseHandler.generateResponseError("Stock quant found", null);
    }

    @PostMapping("/update")
    public ResponseEntity<Object> update(@RequestBody StockQuantUpdateDTO stockQuant) {
        int count = stockQuantService.update(stockQuant);
        if (count == 0) {
            return ResponseHandler.generateResponseError("Update stock quant failed", HttpStatus.BAD_REQUEST);
        }
        return ResponseHandler.generateResponseError("Update stock quant success", null);
    }

    @PostMapping("/delete")
    public ResponseEntity<Object> delete(@RequestParam(name = "stockQuantId") UUID id) {
        int count = stockQuantService.deleteById(id);
        if (count == 0) {
            return ResponseHandler.generateResponseError("Delete stock quant failed", HttpStatus.BAD_REQUEST);
        }
        return ResponseHandler.generateResponseError("Delete stock quant success", null);
    }
}
