package com.base.admin.masterdata.dto;

import com.base.admin.dto.Pagination;
import com.base.admin.masterdata.entity.DmQuanhe;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DmQuanheSearchDTO {
    DmQuanhe dto;
    Pagination pagination;
}
