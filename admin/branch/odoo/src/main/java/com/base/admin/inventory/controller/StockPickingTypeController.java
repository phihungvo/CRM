package com.base.admin.inventory.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.base.admin.constant.APIConstant;
import com.base.admin.handler.ResponseHandler;
import com.base.admin.inventory.dto.request.StockPickingTypeDTO;
import com.base.admin.inventory.dto.request.StockPickingTypeUpdateDTO;
import com.base.admin.inventory.entity.StockPickingType;
import com.base.admin.inventory.service.StockPickingTypeService;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@RestController
@RequestMapping(APIConstant.INVENTORY + "/stock-picking-type")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StockPickingTypeController {

    StockPickingTypeService stockPickingTypeService;

    public StockPickingTypeController(StockPickingTypeService stockPickingTypeService) {
        this.stockPickingTypeService = stockPickingTypeService;
    }

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody StockPickingTypeDTO stockPickingTypeDTO) {
        int count = stockPickingTypeService.create(stockPickingTypeDTO);
        if (count == 0) return ResponseHandler.generateResponseError("Create not success", HttpStatus.BAD_REQUEST);
        return ResponseHandler.generateResponseSuccess("Create success", null);
    }

    @PostMapping("/findById")
    public ResponseEntity<Object> findById(@RequestParam(name = "stock_picking_id") UUID id) {
        StockPickingType stockPickingType = stockPickingTypeService.findById(id);
        if (stockPickingType == null)
            return ResponseHandler.generateResponseError("Stock Picking Type not found", HttpStatus.NOT_FOUND);
        return ResponseHandler.generateResponseSuccess("", stockPickingType);
    }

    @PostMapping("/update")
    public ResponseEntity<Object> update(@RequestBody StockPickingTypeUpdateDTO updateDTO) {
        int count = stockPickingTypeService.update(updateDTO);
        if (count == 0) return ResponseHandler.generateResponseError("", HttpStatus.BAD_REQUEST);
        return ResponseHandler.generateResponseSuccess("", null);
    }

    @PostMapping("/delete")
    public ResponseEntity<Object> delete(@RequestParam(name = "picking_type_id") UUID id) {
        int count = stockPickingTypeService.delete(id);
        if (count == 0) return ResponseHandler.generateResponseError("Delete failed", HttpStatus.BAD_REQUEST);
        return ResponseHandler.generateResponseSuccess("", null);
    }
}
