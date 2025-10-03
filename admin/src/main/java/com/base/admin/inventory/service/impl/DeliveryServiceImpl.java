package com.base.admin.inventory.service.impl;

import com.base.admin.inventory.dto.DeliveryDTO;
import com.base.admin.inventory.dto.DeliveryDetailDTO;
import com.base.admin.inventory.dto.request.DeliveryDetailReq;
import com.base.admin.inventory.dto.request.DeliveryRequest;
import com.base.admin.inventory.dto.request.PagedRequest;
import com.base.admin.inventory.dto.response.DeliveryResponse;
import com.base.admin.inventory.entity.Delivery;
import com.base.admin.inventory.entity.DeliveryDetail;
import com.base.admin.inventory.mapper.DeliveryDetailMapper;
import com.base.admin.inventory.mapper.DeliveryMapper;
import com.base.admin.inventory.service.DeliveryService;
import com.base.admin.inventory.service.InventoryService;
import com.base.admin.inventory.util.PageUtil;
import com.google.gson.reflect.TypeToken;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeliveryServiceImpl implements DeliveryService {

    private final DeliveryMapper deliveryMapper;
    private final DeliveryDetailMapper deliveryDetailMapper;
    private final ModelMapper modelMapper;
    private final InventoryService inventoryService;

    @Override
    public Optional<Delivery> findById(UUID id) {
        return deliveryMapper.findById(id);
    }

    @Override
    public Page<Delivery> findPage(PagedRequest pagedRequest) {
        PageUtil pageUtil = new PageUtil(pagedRequest);
        List<Delivery> deliveries = deliveryMapper.findPage(pageUtil.getLimit(), pageUtil.getOffset());
        long count = deliveryMapper.count();
        return new PageImpl<>(deliveries, pageUtil.getPageable(), count);
    }

    @Override
    public Optional<Delivery> findByDeliverynumber(String deliverynumber) {
        return deliveryMapper.findByDeliverynumber(deliverynumber);
    }

    @Override
    public DeliveryResponse saveDelivery(DeliveryRequest deliveryRequest) {
        Delivery delivery = new Delivery();
        delivery.setSalesdate(deliveryRequest.getDelivery().getSalesdate());
        delivery.setCustomerid(deliveryRequest.getDelivery().getCustomerid());
        delivery.setDeliverynumber(deliveryRequest.getDelivery().getDeliverynumber());
        delivery.setSubtotal(deliveryRequest.getDelivery().getSubtotal());
        delivery.setDiscount(deliveryRequest.getDelivery().getDiscount());
        delivery.setTaxtypeid(deliveryRequest.getDelivery().getTaxtypeid());
        delivery.setOrdertaxvalue(deliveryRequest.getDelivery().getOrdertaxvalue());
        delivery.setShippingfee(deliveryRequest.getDelivery().getShippingfee());
        delivery.setStatus(deliveryRequest.getDelivery().getStatus());
        delivery.setGrandtotal(deliveryRequest.getDelivery().getGrandtotal());
        delivery.setPaid(deliveryRequest.getDelivery().getPaid());
        delivery.setPaidduedate(deliveryRequest.getDelivery().getPaidduedate());
        delivery.setPaymentstatus(deliveryRequest.getDelivery().getPaymentstatus());
        delivery.setNote(deliveryRequest.getDelivery().getNote());
        delivery.setId(UUID.randomUUID());
        deliveryMapper.save(delivery);
        if (delivery != null) {
            UUID deliveryid = delivery.getId();
            List<DeliveryDetail> deliveryDetails = new ArrayList<>();
            for (DeliveryDetailReq detailreq : deliveryRequest.getDeliveryDetails()) {
                DeliveryDetail detail = new DeliveryDetail();
                detail.setDeliveryid(deliveryid);
                detail.setWarehouseid(detailreq.getWarehouseid());
                detail.setDeliveryquantity(detailreq.getDeliveryquantity());
                detail.setExpecteddate(detailreq.getExpecteddate());
                detail.setActualdate(detailreq.getActualdate());
                detail.setProductprice(detailreq.getProductprice());
                detail.setDiscount(detailreq.getDiscount());
                detail.setTaxtypeid(detailreq.getTaxtypeid());
                detail.setOrdertaxvalue(detailreq.getOrdertaxvalue());
                detail.setSubtotal(detailreq.getSubtotal());
//                detail.setShippingfee(detailreq.getShippingfee());
                detail.setStatus(detailreq.getStatus());
                detail.setPaymentstatus(detailreq.getPaymentstatus());
                detail.setNote(detailreq.getNote());

                deliveryDetails.add(detail);

                inventoryService.decreaseInventory(detailreq.getWarehouseid(), detailreq.getProductid(), detailreq.getDeliveryquantity());
            }
            deliveryDetailMapper.saveAll(deliveryDetails);

            DeliveryDTO deliveryDTO = modelMapper.map(delivery, DeliveryDTO.class);
            List<DeliveryDetailDTO> deliveryDetailDTOs = modelMapper.map(deliveryDetails, new TypeToken<List<DeliveryDetailDTO>>() {
            }.getType());
            DeliveryResponse response = new DeliveryResponse(deliveryDTO, deliveryDetailDTOs);
            return response;
        }
        return null;
    }

    @Override
    public UUID save(Delivery delivery) {
        delivery.setId(UUID.randomUUID());
        deliveryMapper.save(delivery);
        return delivery.getId();
    }

    @Override
    public boolean existById(UUID deliveryid) {
        return deliveryMapper.existById(deliveryid);
    }

    @Override
    public boolean delete(UUID deliveryid) {
        return deliveryMapper.deleteById(deliveryid);
    }
}
