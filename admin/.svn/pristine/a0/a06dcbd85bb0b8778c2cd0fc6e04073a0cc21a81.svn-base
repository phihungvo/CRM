package com.base.admin.inventory.dto.response;


import com.base.admin.inventory.dto.OrderDTO;
import com.base.admin.inventory.dto.OrderDetailDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class OrderResponse {
    OrderDTO order;
    List<OrderDetailDTO> orderDetail;

    public OrderResponse(OrderDTO orderDTO, List<OrderDetailDTO> orderDetailDTOS) {
        this.order = orderDTO;
        this.orderDetail = orderDetailDTOS;
    }
}
