package com.base.admin.inventory.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.base.admin.constant.APIConstant;
import com.base.admin.handler.ResponseHandler;
import com.base.admin.inventory.dto.request.StockInventoryDTO;
import com.base.admin.inventory.dto.request.StockInventoryUpdateDTO;
import com.base.admin.inventory.entity.StockInventory;
import com.base.admin.inventory.service.StockInventoryService;

@RestController
@RequestMapping(APIConstant.INVENTORY + "/stock-inventory")
public class StockInventoryController {

    StockInventoryService stockInventoryService;

    public StockInventoryController(StockInventoryService stockInventoryService) {
        this.stockInventoryService = stockInventoryService;
    }

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody StockInventoryDTO stockInventory) {
        int count = stockInventoryService.create(stockInventory);
        if (count == 0) {
            return ResponseHandler.generateResponseError("Create stock inventory failed", HttpStatus.BAD_REQUEST);
        }
        return ResponseHandler.generateResponseError("Create stock inventory success", null);
    }

    @PostMapping("/findById")
    public ResponseEntity<Object> findById(@RequestParam(name = "stockInventoryId") UUID id) {
        StockInventory stockInventory = stockInventoryService.findById(id);
        if (stockInventory == null) {
            return ResponseHandler.generateResponseError("Find stock inventory failed", HttpStatus.BAD_REQUEST);
        }
        return ResponseHandler.generateResponseSuccess("", stockInventory);
    }

    @PostMapping("/update")
    public ResponseEntity<Object> update(@RequestBody StockInventoryUpdateDTO stockInventory) {
        int count = stockInventoryService.update(stockInventory);
        if (count == 0) {
            return ResponseHandler.generateResponseError("Update stock inventory failed", HttpStatus.BAD_REQUEST);
        }
        return ResponseHandler.generateResponseError("Update stock inventory success", null);
    }

    @PostMapping("/delete")
    public ResponseEntity<Object> delete(@RequestParam(name = "stockInventoryId") UUID id) {
        int count = stockInventoryService.deleteById(id);
        if (count == 0) {
            return ResponseHandler.generateResponseError("Delete stock inventory failed", HttpStatus.BAD_REQUEST);
        }
        return ResponseHandler.generateResponseError("Delete stock inventory success", null);
    }
}
