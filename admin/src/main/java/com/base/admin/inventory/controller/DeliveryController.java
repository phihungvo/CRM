package com.base.admin.inventory.controller;

import com.base.admin.dto.PagedResponse;
import com.base.admin.handler.ResponseHandler;
import com.base.admin.inventory.constant.version.Module;
import com.base.admin.inventory.constant.version.VersionUrl;
import com.base.admin.inventory.dto.DeliveryDTO;
import com.base.admin.inventory.dto.DeliveryDetailDTO;
import com.base.admin.inventory.dto.request.DeliveryRequest;
import com.base.admin.inventory.dto.request.PagedRequest;
import com.base.admin.inventory.dto.response.DeliveryResponse;
import com.base.admin.inventory.entity.Delivery;
import com.base.admin.inventory.entity.DeliveryDetail;
import com.base.admin.inventory.service.DeliveryDetailService;
import com.base.admin.inventory.service.DeliveryService;
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

@RequestMapping(VersionUrl.VERSION_URL + Module.MODULE + "/delivery")
@RestController
@RequiredArgsConstructor
public class DeliveryController {
    private final DeliveryService deliveryService;
    private final DeliveryDetailService deliveryDetailService;
    private final ModelMapper modelMapper;
    @PostMapping("/findById")
    public ResponseEntity<Object> findById(@RequestParam(name = "id", required = true) UUID id) {
        Optional<Delivery> delivery = deliveryService.findById(id);
        if (delivery.isPresent()) {
            DeliveryDTO deliveryDTO = modelMapper.map(delivery.get(), new TypeToken<DeliveryDTO>() {
            }.getType());
            List<DeliveryDetail> deliveryDetail = deliveryDetailService.findByDeliveryId(id);
            List<DeliveryDetailDTO> deliveryDetailDTOS = modelMapper.map(deliveryDetail, new TypeToken<List<DeliveryDetailDTO>>() {
            }.getType());

            DeliveryResponse response = new DeliveryResponse(deliveryDTO, deliveryDetailDTOS);
            return ResponseHandler.generateResponseSuccess("", response);
        }
        return ResponseHandler.generateResponseError("Delivery not found", HttpStatus.NOT_FOUND);
    }

    @PostMapping("/findPage")
    public ResponseEntity<Object> findPage(@RequestBody @Validated PagedRequest pagedRequest) {
        Page<Delivery> pageDelivery = deliveryService.findPage(pagedRequest);
        if (pageDelivery.getNumberOfElements() == 0) {
            return ResponseHandler.generateResponseSuccess("", new PagedResponse<DeliveryDTO>(Collections.emptyList(), pageDelivery.getNumber(),
                    pageDelivery.getSize(), pageDelivery.getTotalElements(), pageDelivery.getTotalPages(), pageDelivery.isLast()));
        }
        List<DeliveryDTO> deliveryDTOs = modelMapper.map(pageDelivery.getContent(), new TypeToken<List<DeliveryDTO>>() {
        }.getType());

        return ResponseHandler.generateResponseSuccess("", (new PagedResponse<>(deliveryDTOs, pageDelivery.getNumber(),
                pageDelivery.getSize(), pageDelivery.getTotalElements(), pageDelivery.getTotalPages(), pageDelivery.isLast())));

    }

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody @Validated DeliveryRequest deliveryRequest) {
        Optional<Delivery> deliveryopt = deliveryService.findByDeliverynumber(deliveryRequest.getDelivery().getDeliverynumber());
        if (deliveryopt.isPresent()) {
            return ResponseHandler.generateResponseError("Delivery number id already exist", HttpStatus.NOT_FOUND);
        }

        DeliveryResponse deliveryResponse= deliveryService.saveDelivery(deliveryRequest);
        if (deliveryResponse == null) {
            return ResponseHandler.generateResponseError("Save delivery fail", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseHandler.generateResponseSuccess("Delivery created", deliveryResponse);
    }

    @PostMapping("/update")
    public ResponseEntity<Object> update(@RequestBody @Validated DeliveryDTO deliveryDTO) {

        Optional<Delivery> deliveryopt = deliveryService.findById(deliveryDTO.getId());
        if (!deliveryopt.isPresent()) {
            return ResponseHandler.generateResponseError("Delivery id not found", HttpStatus.NOT_FOUND);
        }
        Delivery delivery = deliveryopt.get();
        delivery.setSalesdate(deliveryDTO.getSalesdate());
        delivery.setCustomerid(deliveryDTO.getCustomerid());
        delivery.setDeliverynumber(deliveryDTO.getDeliverynumber());
        delivery.setSubtotal(deliveryDTO.getSubtotal());
        delivery.setDiscount(deliveryDTO.getDiscount());
        delivery.setTaxtypeid(deliveryDTO.getTaxtypeid());
        delivery.setOrdertaxvalue(deliveryDTO.getOrdertaxvalue());
        delivery.setShippingfee(deliveryDTO.getShippingfee());
        delivery.setStatus(deliveryDTO.getStatus());
        delivery.setGrandtotal(deliveryDTO.getGrandtotal());
        delivery.setPaid(deliveryDTO.getPaid());
        delivery.setPaidduedate(deliveryDTO.getPaidduedate());
        delivery.setPaymentstatus(deliveryDTO.getPaymentstatus());
        delivery.setNote(deliveryDTO.getNote());

        UUID deliveryId = deliveryService.save(delivery);
        if (deliveryId == null) {
            return ResponseHandler.generateResponseError("Save Delivery fail", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseHandler.generateResponseSuccess("Delivery updated", deliveryId);
    }

    @PostMapping("/updateDeliveryDetail")
    public ResponseEntity<Object> updateDeliveryDetail(@RequestBody @Validated DeliveryDetailDTO deliveryDetailDTO) {

        Optional<DeliveryDetail> deliverydetailopt = deliveryDetailService.findById(deliveryDetailDTO.getId());
        if (!deliverydetailopt.isPresent()) {
            return ResponseHandler.generateResponseError("Order Detail id not found", HttpStatus.NOT_FOUND);
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
            return ResponseHandler.generateResponseError("Save Delivery Detail fail", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseHandler.generateResponseSuccess("Delivery Detail updated", deliveryDetailId);
    }
    @PostMapping("/delete")
    public ResponseEntity<Object> delete(@RequestParam(name = "deliveryid", required = true) UUID deliveryid) {

        if (!deliveryService.existById(deliveryid)) {
            return ResponseHandler.generateResponseError("Delivery not found", HttpStatus.NOT_FOUND);
        }

        if (!deliveryService.delete(deliveryid)) {
            return ResponseHandler.generateResponseError("Delete Delivery fail", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseHandler.generateResponseSuccess("Delivery deleted", null);
    }

    @PostMapping("/deleteDeliveryDetail")
    public ResponseEntity<Object> deleteDeliveryDetail(@RequestParam(name = "deliverydetailid", required = true) UUID deliverydetailid) {

        if (!deliveryDetailService.existById(deliverydetailid)) {
            return ResponseHandler.generateResponseError("Order not found", HttpStatus.NOT_FOUND);
        }

        if (!deliveryDetailService.delete(deliverydetailid)) {
            return ResponseHandler.generateResponseError("Delete Delivery fail", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseHandler.generateResponseSuccess("Delivery deleted", null);
    }
}
