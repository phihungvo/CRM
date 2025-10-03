package com.base.admin.inventory.dto.request;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DeliveryRequest {
    DeliveryReq delivery;
    List<DeliveryDetailReq> deliveryDetails;
}