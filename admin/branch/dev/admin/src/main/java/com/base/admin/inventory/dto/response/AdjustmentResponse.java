package com.base.admin.inventory.dto.response;

import com.base.admin.inventory.dto.AdjustmentDTO;
import com.base.admin.inventory.dto.AdjustmentDetailDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AdjustmentResponse {
    AdjustmentDTO adjustment;
    List<AdjustmentDetailDTO> adjustmentDetails;

    public AdjustmentResponse(AdjustmentDTO adjustmentDTO, List<AdjustmentDetailDTO> adjustmentDetailDTOS) {
        this.adjustment = adjustmentDTO;
        this.adjustmentDetails = adjustmentDetailDTOS;
    }
    public AdjustmentResponse()
    {}
}
