package com.base.admin.inventory.dto.response;

import com.base.admin.inventory.dto.DeliveryDTO;
import com.base.admin.inventory.dto.DeliveryDetailDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DeliveryResponse {
    DeliveryDTO delivery;
    List<DeliveryDetailDTO> deliveryDetail;

    public DeliveryResponse(DeliveryDTO deliveryDTO, List<DeliveryDetailDTO> deliveryDetailDTOs) {
        this.delivery = deliveryDTO;
        this.deliveryDetail = deliveryDetailDTOs;
    }
}
