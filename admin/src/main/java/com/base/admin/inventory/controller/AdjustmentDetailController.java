package com.base.admin.inventory.controller;

import com.base.admin.dto.PagedResponse;
import com.base.admin.handler.ResponseHandler;
import com.base.admin.inventory.constant.version.Module;
import com.base.admin.inventory.constant.version.VersionUrl;
import com.base.admin.inventory.dto.AdjustmentDetailDTO;
import com.base.admin.inventory.dto.request.PagedRequest;
import com.base.admin.inventory.entity.AdjustmentDetail;
import com.base.admin.inventory.service.AdjustmentDetailService;
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

@RequestMapping(VersionUrl.VERSION_URL + Module.MODULE + "/adjustmentdetail")
@RestController
@RequiredArgsConstructor
public class AdjustmentDetailController {

    private final AdjustmentDetailService adjustmentDetailService;
    private final ModelMapper modelMapper;

    @PostMapping("/findById")
    public ResponseEntity<Object> findById(@RequestParam(name = "id", required = true) UUID id) {
        Optional<AdjustmentDetail> adjustmentDetail = adjustmentDetailService.findById(id);
        if (adjustmentDetail.isPresent()) {
            AdjustmentDetailDTO adjustmentDetailDTO = modelMapper.map(adjustmentDetail.get(), new TypeToken<AdjustmentDetailDTO>() {
            }.getType());
            return ResponseHandler.generateResponseSuccess("", adjustmentDetailDTO);
        }
        return ResponseHandler.generateResponseError("Adjustment Detail not found", HttpStatus.NOT_FOUND);
    }

    @PostMapping("/findPageByAdjustmentId")
    public ResponseEntity<Object> findPageByAdjustmentId(@RequestParam(name = "adjustmentid", required = true) UUID adjustmentid, @RequestBody @Validated PagedRequest pagedRequest) {
        Page<AdjustmentDetail> pageAdjustmentDetail = adjustmentDetailService.findPageByAdjustmentId(pagedRequest, adjustmentid);
        if (pageAdjustmentDetail.getNumberOfElements() == 0) {
            return ResponseHandler.generateResponseSuccess("", new PagedResponse<AdjustmentDetailDTO>(Collections.emptyList(), pageAdjustmentDetail.getNumber(), pageAdjustmentDetail.getSize(), pageAdjustmentDetail.getTotalElements(), pageAdjustmentDetail.getTotalPages(), pageAdjustmentDetail.isLast()));
        }
        List<AdjustmentDetail> adjustmentDetailDTOs = modelMapper.map(pageAdjustmentDetail.getContent(), new TypeToken<List<AdjustmentDetail>>() {
        }.getType());

        return ResponseHandler.generateResponseSuccess("", (new PagedResponse<>(adjustmentDetailDTOs, pageAdjustmentDetail.getNumber(), pageAdjustmentDetail.getSize(), pageAdjustmentDetail.getTotalElements(), pageAdjustmentDetail.getTotalPages(), pageAdjustmentDetail.isLast())));

    }

}
