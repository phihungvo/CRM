package com.base.admin.inventory.controller;

import com.base.admin.dto.PagedResponse;
import com.base.admin.handler.ResponseHandler;
import com.base.admin.inventory.constant.version.Module;
import com.base.admin.inventory.constant.version.VersionUrl;
import com.base.admin.inventory.dto.BrandDTO;
import com.base.admin.inventory.dto.request.PagedRequest;
import com.base.admin.inventory.entity.Brand;
import com.base.admin.inventory.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.modelmapper.TypeToken;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping(VersionUrl.VERSION_URL + Module.MODULE + "/brand")
@RestController
@RequiredArgsConstructor
public class BrandController {

    private final BrandService brandService;
    private final ModelMapper modelMapper;

    @PostMapping("/findById")
    public ResponseEntity<Object> findById(@RequestParam(name = "id", required = true) UUID id) {
        Optional<Brand> brand = brandService.findById(id);
        if (brand.isPresent()) {
            BrandDTO brandDTO = modelMapper.map(brand.get(), new TypeToken<BrandDTO>() {
            }.getType());
            return ResponseHandler.generateResponseSuccess("", brandDTO);
        }
        return ResponseHandler.generateResponseError("Brand not found", HttpStatus.NOT_FOUND);
    }

    @PostMapping("/findAll")
    public ResponseEntity<Object> findAll() {
        List<Brand> brand = brandService.findAll();
        if (brand != null ) {
            List<BrandDTO> brandDTOs = modelMapper.map(brand, new TypeToken<List<BrandDTO>>() {
            }.getType());
            return ResponseHandler.generateResponseSuccess("", brandDTOs);
        }
        return ResponseHandler.generateResponseError("Brand not found", HttpStatus.NOT_FOUND);
    }

    @PostMapping("/findPage")
    public ResponseEntity<Object> findPage(@RequestBody @Validated PagedRequest pagedRequest) {
        Page<Brand> pageBrand = brandService.findPage(pagedRequest);
        if (pageBrand.getNumberOfElements() == 0) {
            return ResponseHandler.generateResponseSuccess("", new PagedResponse<BrandDTO>(Collections.emptyList(), pageBrand.getNumber(),
                    pageBrand.getSize(), pageBrand.getTotalElements(), pageBrand.getTotalPages(), pageBrand.isLast()));
        }
        List<BrandDTO> brandDTOs = modelMapper.map(pageBrand.getContent(), new TypeToken<List<BrandDTO>>() {
        }.getType());

        return ResponseHandler.generateResponseSuccess("", (new PagedResponse<>(brandDTOs, pageBrand.getNumber(),
                pageBrand.getSize(), pageBrand.getTotalElements(), pageBrand.getTotalPages(), pageBrand.isLast())));

    }

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody @Validated BrandDTO brandDTO) {
        if (brandService.existsByBrandname(brandDTO.getBrandname())) {
            return ResponseHandler.generateResponseError("Brand name already exists", HttpStatus.BAD_REQUEST);
        }

        Brand brand = new Brand();
        brand.setBranddescription(brandDTO.getBranddescription());
        brand.setBrandname(brandDTO.getBrandname());

        UUID brandId = brandService.save(brand);
        if (brandId == null) {
            return ResponseHandler.generateResponseError("Save brand fail", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseHandler.generateResponseSuccess("Brand created", brandId);
    }

    @PostMapping("/update")
    public ResponseEntity<Object> update(@RequestBody @Validated BrandDTO brandDTO) {

        Optional<Brand> brandopt = brandService.findById(brandDTO.getId());
        if (!brandopt.isPresent()) {
            return ResponseHandler.generateResponseError("Brand id not found", HttpStatus.NOT_FOUND);
        }
        Brand brand = brandopt.get();
        brand.setBranddescription(brandDTO.getBranddescription());
        brand.setBrandname(brandDTO.getBrandname());

        UUID brandId = brandService.save(brand);
        if (brandId == null) {
            return ResponseHandler.generateResponseError("Save brand fail", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseHandler.generateResponseSuccess("brand updated", brandId);
    }

    @PostMapping("/delete")
    public ResponseEntity<Object> delete(@RequestParam(name = "brandid", required = true) UUID brandid) {

        if (!brandService.existById(brandid)) {
            return ResponseHandler.generateResponseError("Brand not found", HttpStatus.NOT_FOUND);
        }

        if (!brandService.delete(brandid)) {
            return ResponseHandler.generateResponseError("Delete Brand fail", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseHandler.generateResponseSuccess("Brand deleted", null);
    }
}
