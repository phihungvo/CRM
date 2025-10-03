package com.base.admin.masterdata.dto;

import com.base.admin.dto.Pagination;
import com.base.admin.masterdata.entity.DmNganhnghe;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DmNganhngheSearchDTO {
    DmNganhnghe dto;
    Pagination pagination;
}
