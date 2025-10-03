package com.base.admin.inventory.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.base.admin.constant.APIConstant;
import com.base.admin.handler.ResponseHandler;
import com.base.admin.inventory.dto.request.StockLocationDTO;
import com.base.admin.inventory.dto.request.StockLocationUpdateDTO;
import com.base.admin.inventory.entity.StockLocation;
import com.base.admin.inventory.service.StockLocationService;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@RestController
@RequestMapping(APIConstant.INVENTORY + "/stock-location")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StockLocationController {

    StockLocationService stockLocationService;

    public StockLocationController(StockLocationService stockLocationService) {
        this.stockLocationService = stockLocationService;
    }

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody StockLocationDTO stockLocation) {
        int count = stockLocationService.create(stockLocation);
        if (count == 0) {
            return ResponseHandler.generateResponseError("Create stock location failed", HttpStatus.BAD_REQUEST);
        }
        return ResponseHandler.generateResponseSuccess("Create stock location success", null);
    }

    @PostMapping("/findById")
    public ResponseEntity<Object> findById(@RequestParam(name = "id") UUID id) {
        StockLocation stockLocation = stockLocationService.findById(id);
        if (stockLocation == null) {
            return ResponseHandler.generateResponseError("Find stock location failed", HttpStatus.BAD_REQUEST);
        }
        return ResponseHandler.generateResponseSuccess("Find stock location success", stockLocation);
    }

    @PostMapping("/update")
    public ResponseEntity<Object> update(@RequestBody StockLocationUpdateDTO stockLocation) {
        int count = stockLocationService.update(stockLocation);
        if (count == 0) {
            return ResponseHandler.generateResponseError("Update stock location failed", HttpStatus.BAD_REQUEST);
        }
        return ResponseHandler.generateResponseSuccess("Update stock location success", null);
    }

    @PostMapping("/delete")
    public ResponseEntity<Object> delete(@RequestParam(name = "id") UUID id) {
        int count = stockLocationService.deleteById(id);
        if (count == 0) {
            return ResponseHandler.generateResponseError("Delete stock location failed", HttpStatus.BAD_REQUEST);
        }
        return ResponseHandler.generateResponseSuccess("Delete stock location success", null);
    }
}
