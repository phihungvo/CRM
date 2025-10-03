package com.base.admin.inventory.controller;

import com.base.admin.dto.PagedResponse;
import com.base.admin.handler.ResponseHandler;
import com.base.admin.inventory.constant.version.Module;
import com.base.admin.inventory.constant.version.VersionUrl;
import com.base.admin.inventory.dto.AdjustmentDTO;
import com.base.admin.inventory.dto.AdjustmentDetailDTO;
import com.base.admin.inventory.dto.response.AdjustmentResponse;
import com.base.admin.inventory.dto.request.AdjustmentRequest;
import com.base.admin.inventory.dto.request.PagedRequest;
import com.base.admin.inventory.entity.Adjustment;
import com.base.admin.inventory.entity.AdjustmentDetail;
import com.base.admin.inventory.service.AdjustmentDetailService;
import com.base.admin.inventory.service.AdjustmentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping(VersionUrl.VERSION_URL + Module.MODULE + "/adjustment")
@RestController
@RequiredArgsConstructor
public class AdjustmentController {

    private final AdjustmentService adjustmentService;
    private final AdjustmentDetailService adjustmentDetailService;
    private final ModelMapper modelMapper;

    @PostMapping("/findById")
    public ResponseEntity<Object> findById(@RequestParam(name = "id", required = true) UUID id) {
        Optional<Adjustment> adjustment = adjustmentService.findById(id);
        if (adjustment.isPresent()) {
            AdjustmentDTO adjustmentDTO = modelMapper.map(adjustment.get(), new TypeToken<AdjustmentDTO>() {
            }.getType());

            List<AdjustmentDetail> adjustmentDetail = adjustmentDetailService.findByAdjustmentId(id);
            List<AdjustmentDetailDTO> adjustmentDetailDTOS = modelMapper.map(adjustmentDetail, new TypeToken<List<AdjustmentDetailDTO>>() {
            }.getType());

            AdjustmentResponse response = new AdjustmentResponse(adjustmentDTO, adjustmentDetailDTOS);
            return ResponseHandler.generateResponseSuccess("", adjustmentDTO);
        }
        return ResponseHandler.generateResponseError("Provider not found", HttpStatus.NOT_FOUND);
    }

    @PostMapping("/findPage")
    public ResponseEntity<Object> findPage(@RequestBody @Validated PagedRequest pagedRequest) {
        Page<Adjustment> pageAdjustment = adjustmentService.findPage(pagedRequest);
        if (pageAdjustment.getNumberOfElements() == 0) {
            return ResponseHandler.generateResponseSuccess("", new PagedResponse<AdjustmentDTO>(Collections.emptyList(), pageAdjustment.getNumber(),
                    pageAdjustment.getSize(), pageAdjustment.getTotalElements(), pageAdjustment.getTotalPages(), pageAdjustment.isLast()));
        }
        List<AdjustmentDTO> adjustmentDTOs = modelMapper.map(pageAdjustment.getContent(), new TypeToken<List<AdjustmentDTO>>() {
        }.getType());

        return ResponseHandler.generateResponseSuccess("", (new PagedResponse<>(adjustmentDTOs, pageAdjustment.getNumber(),
                pageAdjustment.getSize(), pageAdjustment.getTotalElements(), pageAdjustment.getTotalPages(), pageAdjustment.isLast())));

    }

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody @Validated AdjustmentRequest adjustmentRequest) {
        if (adjustmentService.existsByAdjustmentnumber(adjustmentRequest.getAdjustment().getAdjustmentnumber())) {
            return ResponseHandler.generateResponseError("Adjustment number already exists", HttpStatus.BAD_REQUEST);
        }

        AdjustmentResponse adjustmentResponse = adjustmentService.saveAdjustment(adjustmentRequest);
        if (adjustmentResponse == null) {
            return ResponseHandler.generateResponseError("Save adjustment fail", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseHandler.generateResponseSuccess("Adjustment created", adjustmentResponse);
    }
}
