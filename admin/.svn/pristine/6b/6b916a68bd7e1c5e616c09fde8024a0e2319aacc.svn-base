package com.base.admin.inventory.controller;

import com.base.admin.dto.PagedResponse;
import com.base.admin.handler.ResponseHandler;
import com.base.admin.inventory.constant.version.Module;
import com.base.admin.inventory.constant.version.VersionUrl;
import com.base.admin.inventory.dto.OrderDTO;
import com.base.admin.inventory.dto.OrderDetailDTO;
import com.base.admin.inventory.dto.request.OrderRequest;
import com.base.admin.inventory.dto.request.PagedRequest;
import com.base.admin.inventory.dto.response.OrderResponse;
import com.base.admin.inventory.entity.Order;
import com.base.admin.inventory.entity.OrderDetail;
import com.base.admin.inventory.service.OrderDetailService;
import com.base.admin.inventory.service.OrderService;
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

@RequestMapping(VersionUrl.VERSION_URL + Module.MODULE + "/order")
@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final OrderDetailService orderDetailService;
    private final ModelMapper modelMapper;

    @PostMapping("/findById")
    public ResponseEntity<Object> findById(@RequestParam(name = "id", required = true) UUID id) {
        Optional<Order> order = orderService.findById(id);
        if (order.isPresent()) {
            OrderDTO orderDTO = modelMapper.map(order.get(), new TypeToken<OrderDTO>() {
            }.getType());
            List<OrderDetail> orderDetail = orderDetailService.findByOrderId(id);
            List<OrderDetailDTO> orderDetailDTOS = modelMapper.map(orderDetail, new TypeToken<List<OrderDetailDTO>>() {
            }.getType());

            OrderResponse response = new OrderResponse(orderDTO, orderDetailDTOS);
            return ResponseHandler.generateResponseSuccess("", response);
        }
        return ResponseHandler.generateResponseError("Provider not found", HttpStatus.NOT_FOUND);
    }

    @PostMapping("/findPage")
    public ResponseEntity<Object> findPage(@RequestBody @Validated PagedRequest pagedRequest) {
        Page<Order> pageOrder = orderService.findPage(pagedRequest);
        if (pageOrder.getNumberOfElements() == 0) {
            return ResponseHandler.generateResponseSuccess("", new PagedResponse<OrderDTO>(Collections.emptyList(), pageOrder.getNumber(),
                    pageOrder.getSize(), pageOrder.getTotalElements(), pageOrder.getTotalPages(), pageOrder.isLast()));
        }
        List<OrderDTO> orderDTOs = modelMapper.map(pageOrder.getContent(), new TypeToken<List<OrderDTO>>() {
        }.getType());

        return ResponseHandler.generateResponseSuccess("", (new PagedResponse<>(orderDTOs, pageOrder.getNumber(),
                pageOrder.getSize(), pageOrder.getTotalElements(), pageOrder.getTotalPages(), pageOrder.isLast())));

    }


    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody @Validated OrderRequest orderRequest) {

        Optional<Order> orderopt = orderService.findByOrdernumber(orderRequest.getOrder().getOrdernumber());
        if (orderopt.isPresent()) {
            return ResponseHandler.generateResponseError("Order number already exist", HttpStatus.NOT_FOUND);
        }

        OrderResponse orderResponse = orderService.saveOrder(orderRequest);
        if (orderResponse == null) {
            return ResponseHandler.generateResponseError("Save Order fail", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseHandler.generateResponseSuccess("Order created", orderResponse);
    }

    @PostMapping("/update")
    public ResponseEntity<Object> update(@RequestBody @Validated OrderDTO orderDTO) {

        Optional<Order> orderopt = orderService.findById(orderDTO.getId());
        if (!orderopt.isPresent()) {
            return ResponseHandler.generateResponseError("Order id not found", HttpStatus.NOT_FOUND);
        }

        Order order = orderopt.get();
        order.setOrderdate(orderDTO.getOrderdate());
        order.setOrdernumber(orderDTO.getOrdernumber());
        order.setProviderid(orderDTO.getProviderid());
        order.setOrdernumber(orderDTO.getOrdernumber());
        order.setSubtotal(orderDTO.getSubtotal());
        order.setDiscount(orderDTO.getDiscount());
        order.setTaxtypeid(orderDTO.getTaxtypeid());
        order.setOrdertaxvalue(orderDTO.getOrdertaxvalue());
        order.setShippingfee(orderDTO.getShippingfee());
        order.setStatus(orderDTO.getStatus());
        order.setGrandtotal(orderDTO.getGrandtotal());
        order.setPaid(orderDTO.getPaid());
        order.setPaidduedate(orderDTO.getPaidduedate());
        order.setPaymentstatus(orderDTO.getPaymentstatus());
        order.setNote(orderDTO.getNote());

        UUID orderid = orderService.save(order);
        if (orderid == null) {
            return ResponseHandler.generateResponseError("Save Order fail", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseHandler.generateResponseSuccess("Order created", orderid);
    }

    @PostMapping("/updateOrderDetail")
    public ResponseEntity<Object> updateOrderDetail(@RequestBody @Validated OrderDetail orderDetailDTO) {

        Optional<OrderDetail> orderdetailopt = orderDetailService.findById(orderDetailDTO.getId());
        if (!orderdetailopt.isPresent()) {
            return ResponseHandler.generateResponseError("Order Detail id not found", HttpStatus.NOT_FOUND);
        }
        OrderDetail order = orderdetailopt.get();
        order.setOrderid(orderDetailDTO.getOrderid());
        order.setWarehouseid(orderDetailDTO.getWarehouseid());
        order.setProductid(orderDetailDTO.getProductid());
        order.setOrderquantity(orderDetailDTO.getOrderquantity());
        order.setExpecteddate(orderDetailDTO.getExpecteddate());
        order.setActualdate(orderDetailDTO.getActualdate());
        order.setProductcost(orderDetailDTO.getProductcost());
        order.setDiscount(orderDetailDTO.getDiscount());
        order.setTaxtypeid(orderDetailDTO.getTaxtypeid());
        order.setOrdertaxvalue(orderDetailDTO.getOrdertaxvalue());
        order.setSubtotal(orderDetailDTO.getSubtotal());
        order.setStatus(orderDetailDTO.getStatus());
        order.setNote(orderDetailDTO.getNote());

        UUID orderId = orderDetailService.save(order);
        if (orderId == null) {
            return ResponseHandler.generateResponseError("Save Order Detail fail", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseHandler.generateResponseSuccess("Order Detail updated", orderId);
    }

    @PostMapping("/deleteOrder")
    public ResponseEntity<Object> deleteOrder(@RequestParam(name = "orderid", required = true) UUID orderid) {

        if (!orderService.existById(orderid)) {
            return ResponseHandler.generateResponseError("Order not found", HttpStatus.NOT_FOUND);
        }

        if (!orderService.deleteOrder(orderid)) {
            return ResponseHandler.generateResponseError("Delete Order fail", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseHandler.generateResponseSuccess("Order deleted", null);
    }

    @PostMapping("/deleteOrderDetail")
    public ResponseEntity<Object> deleteOrderDetail(@RequestParam(name = "orderdetailid", required = true) UUID orderdetailid) {

        if (!orderDetailService.existById(orderdetailid)) {
            return ResponseHandler.generateResponseError("Order not found", HttpStatus.NOT_FOUND);
        }

        if (!orderDetailService.delete(orderdetailid)) {
            return ResponseHandler.generateResponseError("Delete Order fail", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseHandler.generateResponseSuccess("Order deleted", null);
    }

}
