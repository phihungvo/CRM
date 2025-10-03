package com.base.admin.inventory.controller;

import com.base.admin.handler.ResponseHandler;
import com.base.admin.inventory.constant.message.MessageAdjustment;
import com.base.admin.inventory.constant.version.Module;
import com.base.admin.inventory.constant.version.VersionUrl;
import com.base.admin.inventory.entity.Brand;
import com.base.admin.inventory.service.BrandService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;

@RequestMapping(VersionUrl.VERSION_URL + Module.MODULE + "/brand")
@RestController
public class BrandController {

    private final BrandService brandService;
    private final ModelMapper modelMapper;

    public BrandController(BrandService brandService, ModelMapper modelMapper) {
        this.brandService = brandService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/findById")
    public ResponseEntity<Object> findById(@RequestParam(name = "id", required = true) UUID id) {
        Optional<Brand> adjustment = brandService.findById(id);
        if (adjustment.isPresent()) {

            return ResponseHandler.generateResponseSuccess("", adjustment);
        }
        return ResponseHandler.generateResponseError(MessageAdjustment.NOT_FOUND_PROVIDER, HttpStatus.NOT_FOUND);
    }
}
