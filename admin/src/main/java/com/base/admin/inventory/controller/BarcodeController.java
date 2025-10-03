package com.base.admin.inventory.controller;

import com.base.admin.handler.ResponseHandler;
import com.base.admin.inventory.constant.version.Module;
import com.base.admin.inventory.constant.version.VersionUrl;
import com.base.admin.inventory.dto.BarcodeDTO;
import com.base.admin.inventory.dto.request.PagedRequest;
import com.base.admin.inventory.entity.Barcode;
import com.base.admin.inventory.service.BarcodeService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.modelmapper.TypeToken;
import com.base.admin.dto.PagedResponse;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping(VersionUrl.VERSION_URL + Module.MODULE + "/barcode")
@RestController
@RequiredArgsConstructor
public class BarcodeController {

    private final BarcodeService barcodeService;
    private final ModelMapper modelMapper;

    @PostMapping("/findById")
    public ResponseEntity<Object> findById(@RequestParam(name = "id", required = true) UUID id) {
        Optional<Barcode> barcode = barcodeService.findById(id);
        if (barcode.isPresent()) {
            BarcodeDTO barcodeDTO = modelMapper.map(barcode.get(), new TypeToken<BarcodeDTO>() {
            }.getType());
            return ResponseHandler.generateResponseSuccess("", barcodeDTO);
        }
        return ResponseHandler.generateResponseError("Barcode not found", HttpStatus.NOT_FOUND);
    }

    @PostMapping("/findAll")
    public ResponseEntity<Object> findAll() {
        List<Barcode> barcode = barcodeService.findAll();
        if (barcode != null ) {
            List<BarcodeDTO> barcodeDTOs = modelMapper.map(barcode, new TypeToken<List<BarcodeDTO>>() {
            }.getType());
            return ResponseHandler.generateResponseSuccess("", barcodeDTOs);
        }
        return ResponseHandler.generateResponseError("Barcode not found", HttpStatus.NOT_FOUND);
    }

    @PostMapping("/findPage")
    public ResponseEntity<Object> findPage(@RequestBody @Validated PagedRequest pagedRequest) {
        Page<Barcode> pageBarcode = barcodeService.findPage(pagedRequest);
        if (pageBarcode.getNumberOfElements() == 0) {
            return ResponseHandler.generateResponseSuccess("", new PagedResponse<BarcodeDTO>(Collections.emptyList(), pageBarcode.getNumber(),
                    pageBarcode.getSize(), pageBarcode.getTotalElements(), pageBarcode.getTotalPages(), pageBarcode.isLast()));
        }
        List<BarcodeDTO> barcodeDTOs = modelMapper.map(pageBarcode.getContent(), new TypeToken<List<BarcodeDTO>>() {
        }.getType());

        return ResponseHandler.generateResponseSuccess("", (new PagedResponse<>(barcodeDTOs, pageBarcode.getNumber(),
                pageBarcode.getSize(), pageBarcode.getTotalElements(), pageBarcode.getTotalPages(), pageBarcode.isLast())));

    }

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody @Validated BarcodeDTO barcodeDTO) {
        if (barcodeService.existsByBarcodename(barcodeDTO.getBarcodename())) {
            return ResponseHandler.generateResponseError("Barcode name already exists", HttpStatus.BAD_REQUEST);
        }

        Barcode barcode = new Barcode();
        barcode.setBarcodename(barcodeDTO.getBarcodename());

        UUID barcodeId = barcodeService.save(barcode);
        if (barcodeId == null) {
            return ResponseHandler.generateResponseError("Save barcode fail", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseHandler.generateResponseSuccess("Barcode created", barcodeId);
    }

    @PostMapping("/update")
    public ResponseEntity<Object> update(@RequestBody @Validated BarcodeDTO barcodeDTO) {

        Optional<Barcode> barcodeopt = barcodeService.findById(barcodeDTO.getId());
        if (!barcodeopt.isPresent()) {
            return ResponseHandler.generateResponseError("Barcode id not found", HttpStatus.NOT_FOUND);
        }
        Barcode barcode = barcodeopt.get();
        barcode.setBarcodename(barcodeDTO.getBarcodename());

        UUID barcodeId = barcodeService.save(barcode);
        if (barcodeId == null) {
            return ResponseHandler.generateResponseError("Save barcode fail", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseHandler.generateResponseSuccess("barcode updated", barcodeId);
    }

    @PostMapping("/delete")
    public ResponseEntity<Object> delete(@RequestParam(name = "barcodeid", required = true) UUID barcodeid) {

        if (!barcodeService.existById(barcodeid)) {
            return ResponseHandler.generateResponseError("Barcode not found", HttpStatus.NOT_FOUND);
        }

        if (!barcodeService.delete(barcodeid)) {
            return ResponseHandler.generateResponseError("Delete Barcode fail", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseHandler.generateResponseSuccess("Barcode deleted", null);
    }

}
