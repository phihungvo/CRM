package com.base.admin.inventory.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.base.admin.constant.APIConstant;
import com.base.admin.handler.ResponseHandler;
import com.base.admin.inventory.dto.request.ResPartnerDTO;
import com.base.admin.inventory.dto.request.ResPartnerUpdateDTO;
import com.base.admin.inventory.service.ResPartnerService;

@RestController
@RequestMapping(APIConstant.INVENTORY + "/res-partner")
public class ResPartnerController {
    private final ResPartnerService resPartnerService;

    public ResPartnerController(ResPartnerService resPartnerService) {
        this.resPartnerService = resPartnerService;
    }

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody ResPartnerDTO resPartnerDTO) {
        int count = resPartnerService.create(resPartnerDTO);
        if (count == 0) {
            return ResponseHandler.generateResponseError("Failed to add res partner", null);
        }
        return ResponseHandler.generateResponseSuccess("Res partner added successfully", null);
    }

    @PostMapping("/findAll")
    public ResponseEntity<Object> findAll() {
        var resPartners = resPartnerService.findAll();
        if (resPartners == null) {
            return ResponseHandler.generateResponseError("Res partner not found", null);
        }
        return ResponseHandler.generateResponseSuccess("", resPartners);
    }

    @PostMapping("/findById")
    public ResponseEntity<Object> findById(@RequestParam(name = "resPartnerId") UUID id) {
        var count = resPartnerService.findById(id);
        if (count == null) {
            return ResponseHandler.generateResponseError("Res partner not found", null);
        }
        return ResponseHandler.generateResponseSuccess("", count);
    }

    @PostMapping("/update")
    public ResponseEntity<Object> update(@RequestBody ResPartnerUpdateDTO resPartnerDTO) {
        var count = resPartnerService.update(resPartnerDTO);
        if (count == 0) {
            return ResponseHandler.generateResponseError("Failed to update res partner", HttpStatus.BAD_REQUEST);
        }
        return ResponseHandler.generateResponseSuccess("Res partner updated successfully", null);
    }

    @PostMapping("/deleteById")
    public ResponseEntity<Object> delete(@RequestParam(name = "resPartnerId") UUID id) {
        var count = resPartnerService.deleteById(id);
        if (count == 0) {
            return ResponseHandler.generateResponseError("Failed to delete res partner", HttpStatus.BAD_REQUEST);
        }
        return ResponseHandler.generateResponseSuccess("Res partner deleted successfully", null);
    }
}
