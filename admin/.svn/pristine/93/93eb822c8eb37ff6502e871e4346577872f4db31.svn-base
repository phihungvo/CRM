package com.base.admin.inventory.controller;

import com.base.admin.dto.PagedResponse;
import com.base.admin.handler.ResponseHandler;
import com.base.admin.inventory.constant.version.Module;
import com.base.admin.inventory.constant.version.VersionUrl;
import com.base.admin.inventory.dto.InventoryFullDTO;
import com.base.admin.inventory.dto.request.PagedRequest;
import com.base.admin.inventory.entity.InventoryFull;
import com.base.admin.inventory.service.InventoryInfoService;
import com.base.admin.inventory.service.InventoryService;
import com.google.gson.reflect.TypeToken;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@RequestMapping(VersionUrl.VERSION_URL + Module.MODULE + "/inventory")
@RestController
@RequiredArgsConstructor
public class InventoryController {
    private final InventoryService inventoryService;
    private final InventoryInfoService inventoryInfoService;
    private final ModelMapper modelMapper;

    @PostMapping("/findByProductId")
    public ResponseEntity<Object> findByProductId(@RequestParam(name = "productid", required = true) UUID productid) {
        List<InventoryFull> inventory = inventoryInfoService.findByProductId(productid);
        if (inventory.size() > 0) {
            List<InventoryFullDTO> inventoryDTOs = modelMapper.map(inventory, new TypeToken<List<InventoryFullDTO>>() {
            }.getType());
            return ResponseHandler.generateResponseSuccess("", inventoryDTOs);
        }
        return ResponseHandler.generateResponseError("Inventory not found", HttpStatus.NOT_FOUND);
    }


    @PostMapping("/findByWarehouseId")
    public ResponseEntity<Object> findByProductIdAndWarehouseId(@RequestParam(name = "warehouseid", required = true) UUID warehouseid) {
        List<InventoryFull> inventory = inventoryInfoService.findByWarehouseId(warehouseid);
        if (inventory.size() > 0) {
            List<InventoryFullDTO> inventoryDTOs = modelMapper.map(inventory, new TypeToken<List<InventoryFullDTO>>() {
            }.getType());
            return ResponseHandler.generateResponseSuccess("", inventoryDTOs);
        }
        return ResponseHandler.generateResponseError("Inventory not found", HttpStatus.NOT_FOUND);
    }

    @PostMapping("/findByProductIdAndWarehouseId")
    public ResponseEntity<Object> findByProductidAndWarehouseid(@RequestParam(name = "productid", required = true) UUID productid,
                                                                @RequestParam(name = "warehouseid", required = true) UUID warehouseid) {
        List<InventoryFull> inventory = inventoryInfoService.findByProductIdAndWarehouseId(productid, warehouseid);
        if (inventory.size() > 0) {
            List<InventoryFullDTO> inventoryDTOs = modelMapper.map(inventory, new TypeToken<List<InventoryFullDTO>>() {
            }.getType());
            return ResponseHandler.generateResponseSuccess("", inventoryDTOs);
        }
        return ResponseHandler.generateResponseError("Inventory not found", HttpStatus.NOT_FOUND);
    }

    @PostMapping("/findPage")
    public ResponseEntity<Object> findPage(@RequestBody @Validated PagedRequest pagedRequest) {
        Page<InventoryFull> pageInventory = inventoryInfoService.findPage(pagedRequest);
        if (pageInventory.getNumberOfElements() == 0) {
            return ResponseHandler.generateResponseSuccess("", new PagedResponse<InventoryFullDTO>(Collections.emptyList(), pageInventory.getNumber(),
                    pageInventory.getSize(), pageInventory.getTotalElements(), pageInventory.getTotalPages(), pageInventory.isLast()));
        }
        List<InventoryFullDTO> inventoryDTOs = modelMapper.map(pageInventory.getContent(), new TypeToken<List<InventoryFullDTO>>() {
        }.getType());

        return ResponseHandler.generateResponseSuccess("", (new PagedResponse<>(inventoryDTOs, pageInventory.getNumber(),
                pageInventory.getSize(), pageInventory.getTotalElements(), pageInventory.getTotalPages(), pageInventory.isLast())));

    }

    @PostMapping("/search")
    public ResponseEntity<Object> searchProductNameOrWarehouseName(@RequestBody @Validated PagedRequest pagedRequest, @RequestParam(name = "productOrWarehouse", required = true) String productOrWarehouse) {
        Page<InventoryFull> pageInventory = inventoryInfoService.searchProductNameOrWarehouseName(pagedRequest, productOrWarehouse);
        if (pageInventory.getNumberOfElements() == 0) {
            return ResponseHandler.generateResponseSuccess("", new PagedResponse<InventoryFullDTO>(Collections.emptyList(), pageInventory.getNumber(),
                    pageInventory.getSize(), pageInventory.getTotalElements(), pageInventory.getTotalPages(), pageInventory.isLast()));
        }
        List<InventoryFullDTO> inventoryDTOs = modelMapper.map(pageInventory.getContent(), new TypeToken<List<InventoryFullDTO>>() {
        }.getType());

        return ResponseHandler.generateResponseSuccess("", (new PagedResponse<>(inventoryDTOs, pageInventory.getNumber(),
                pageInventory.getSize(), pageInventory.getTotalElements(), pageInventory.getTotalPages(), pageInventory.isLast())));

    }

    @PostMapping("/delete")
    public ResponseEntity<Object> delete(@RequestParam(name = "inventoryid", required = true) UUID inventoryid) {

        if (!inventoryService.existById(inventoryid)) {
            return ResponseHandler.generateResponseError("Inventory not found", HttpStatus.NOT_FOUND);
        }

        if (!inventoryService.delete(inventoryid)) {
            return ResponseHandler.generateResponseError("Delete Inventory fail", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseHandler.generateResponseSuccess("Inventory deleted", null);
    }
}
