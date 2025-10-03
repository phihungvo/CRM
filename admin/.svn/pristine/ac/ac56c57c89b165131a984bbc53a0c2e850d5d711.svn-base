package com.base.admin.inventory.controller;

import com.base.admin.dto.PagedResponse;
import com.base.admin.handler.ResponseHandler;
import com.base.admin.inventory.constant.version.Module;
import com.base.admin.inventory.constant.version.VersionUrl;
import com.base.admin.inventory.dto.DeliveryDetailDTO;
import com.base.admin.inventory.dto.DeliveryDetailFullDTO;
import com.base.admin.inventory.dto.request.PagedRequest;
import com.base.admin.inventory.entity.DeliveryDetail;
import com.base.admin.inventory.entity.DeliveryDetailFull;
import com.base.admin.inventory.service.DeliveryDetailService;
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
import java.util.Optional;
import java.util.UUID;

@RequestMapping(VersionUrl.VERSION_URL + Module.MODULE + "/deliverydetail")
@RestController
@RequiredArgsConstructor
public class DeliveryDetailController {
    private final DeliveryDetailService deliveryDetailService;
    private final ModelMapper modelMapper;
    @PostMapping("/findById")
    public ResponseEntity<Object> findById(@RequestParam(name = "id", required = true) UUID id) {
        Optional<DeliveryDetail> deliveryDetail = deliveryDetailService.findById(id);
        if (deliveryDetail.isPresent()) {
            DeliveryDetailDTO deliveryDetailDTO = modelMapper.map(deliveryDetail.get(), new TypeToken<DeliveryDetailDTO>() {
            }.getType());
            return ResponseHandler.generateResponseSuccess("", deliveryDetailDTO);
        }
        return ResponseHandler.generateResponseError("Delivery Detail not found", HttpStatus.NOT_FOUND);
    }

//    @PostMapping("/findByIdDeliveryId")
//    public ResponseEntity<Object> findByIdDeliveryId(@RequestParam(name = "deliveryid", required = true) UUID deliveryid) {
//        List<DeliveryDetail> deliveryDetail = deliveryDetailService.findByDeliveryId(deliveryid);
//        if (deliveryDetail.size() > 0) {
//            List<DeliveryDetailDTO>  deliveryDetailDTOS = modelMapper.map(deliveryDetail, new TypeToken<List<DeliveryDetailDTO>>() {
//            }.getType());
//            return ResponseHandler.generateResponseSuccess("", deliveryDetailDTOS);
//        }
//        return ResponseHandler.generateResponseError("Delivery Detail not found", HttpStatus.NOT_FOUND);
//    }

    @PostMapping("/findPageByDeliveryId")
    public ResponseEntity<Object> findPageByDeliveryId( @RequestParam(name = "deliveryid", required = true) UUID deliveryid, @RequestBody @Validated PagedRequest pagedRequest) {
        Page<DeliveryDetailFull> pageDeliveryDetail = deliveryDetailService.findPageByDeliveryId(pagedRequest, deliveryid);
        if (pageDeliveryDetail.getNumberOfElements() == 0) {
            return ResponseHandler.generateResponseSuccess("", new PagedResponse<DeliveryDetailDTO>(Collections.emptyList(), pageDeliveryDetail.getNumber(),
                    pageDeliveryDetail.getSize(), pageDeliveryDetail.getTotalElements(), pageDeliveryDetail.getTotalPages(), pageDeliveryDetail.isLast()));
        }
        List<DeliveryDetailFullDTO> deliveryDetailDTOs = modelMapper.map(pageDeliveryDetail.getContent(), new TypeToken<List<DeliveryDetailFullDTO>>() {
        }.getType());

        return ResponseHandler.generateResponseSuccess("", (new PagedResponse<>(deliveryDetailDTOs, pageDeliveryDetail.getNumber(),
                pageDeliveryDetail.getSize(), pageDeliveryDetail.getTotalElements(), pageDeliveryDetail.getTotalPages(), pageDeliveryDetail.isLast())));

    }

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody @Validated DeliveryDetailDTO deliveryDetailDTO) {
//        if (deliveryDetailService.existsByDeliveryDetailName(deliveryDetailDTO.getDeliveryDetailName())) {
//            return ResponseHandler.generateResponseError("Delivery Detail name already exists", HttpStatus.BAD_REQUEST);
//        }

        //TODO: check validation

        DeliveryDetail deliveryDetail = new DeliveryDetail();
        deliveryDetail.setDeliveryid(deliveryDetailDTO.getDeliveryid());
        deliveryDetail.setWarehouseid(deliveryDetailDTO.getWarehouseid());
        deliveryDetail.setDeliveryquantity(deliveryDetailDTO.getDeliveryquantity());
        deliveryDetail.setExpecteddate(deliveryDetailDTO.getExpecteddate());
        deliveryDetail.setActualdate(deliveryDetailDTO.getActualdate());
        deliveryDetail.setProductprice(deliveryDetailDTO.getProductprice());
        deliveryDetail.setDiscount(deliveryDetailDTO.getDiscount());
        deliveryDetail.setTaxtypeid(deliveryDetailDTO.getTaxtypeid());
        deliveryDetail.setOrdertaxvalue(deliveryDetailDTO.getOrdertaxvalue());
        deliveryDetail.setSubtotal(deliveryDetailDTO.getSubtotal());
//        deliveryDetail.setShippingfee(deliveryDetailDTO.getShippingfee());
        deliveryDetail.setStatus(deliveryDetailDTO.getStatus());
        deliveryDetail.setPaymentstatus(deliveryDetailDTO.getPaymentstatus());
        deliveryDetail.setNote(deliveryDetailDTO.getNote());


        UUID deliveryDetailId = deliveryDetailService.save(deliveryDetail);
        if (deliveryDetailId == null) {
            return ResponseHandler.generateResponseError("Save deliveryDetail fail", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseHandler.generateResponseSuccess("DeliveryDetail created", deliveryDetailId);
    }

    @PostMapping("/update")
    public ResponseEntity<Object> update(@RequestBody @Validated DeliveryDetailDTO deliveryDetailDTO) {

        Optional<DeliveryDetail> deliverydetailopt = deliveryDetailService.findById(deliveryDetailDTO.getId());
        if (!deliverydetailopt.isPresent()) {
            return ResponseHandler.generateResponseError("DeliveryDetail id not found", HttpStatus.NOT_FOUND);
        }
        DeliveryDetail deliveryDetail = deliverydetailopt.get();

        deliveryDetail.setDeliveryid(deliveryDetailDTO.getDeliveryid());
        deliveryDetail.setWarehouseid(deliveryDetailDTO.getWarehouseid());
        deliveryDetail.setDeliveryquantity(deliveryDetailDTO.getDeliveryquantity());
        deliveryDetail.setExpecteddate(deliveryDetailDTO.getExpecteddate());
        deliveryDetail.setActualdate(deliveryDetailDTO.getActualdate());
        deliveryDetail.setProductprice(deliveryDetailDTO.getProductprice());
        deliveryDetail.setDiscount(deliveryDetailDTO.getDiscount());
        deliveryDetail.setTaxtypeid(deliveryDetailDTO.getTaxtypeid());
        deliveryDetail.setOrdertaxvalue(deliveryDetailDTO.getOrdertaxvalue());
        deliveryDetail.setSubtotal(deliveryDetailDTO.getSubtotal());
//        deliveryDetail.setShippingfee(deliveryDetailDTO.getShippingfee());
        deliveryDetail.setStatus(deliveryDetailDTO.getStatus());
        deliveryDetail.setPaymentstatus(deliveryDetailDTO.getPaymentstatus());
        deliveryDetail.setNote(deliveryDetailDTO.getNote());

        UUID deliveryDetailId = deliveryDetailService.save(deliveryDetail);
        if (deliveryDetailId == null) {
            return ResponseHandler.generateResponseError("Save deliveryDetail fail", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseHandler.generateResponseSuccess("DeliveryDetail updated", deliveryDetailId);
    }

    @PostMapping("/delete")
    public ResponseEntity<Object> delete(@RequestParam(name = "deliveryDetailid", required = true) UUID deliveryDetailid) {

        if (!deliveryDetailService.existById(deliveryDetailid)) {
            return ResponseHandler.generateResponseError("Delivery Detail not found", HttpStatus.NOT_FOUND);
        }

        if (!deliveryDetailService.delete(deliveryDetailid)) {
            return ResponseHandler.generateResponseError("Delete DeliveryDetail fail", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseHandler.generateResponseSuccess("Delivery Detail deleted", null);
    }
}
