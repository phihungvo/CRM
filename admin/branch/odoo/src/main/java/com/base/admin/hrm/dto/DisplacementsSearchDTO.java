package com.base.admin.hrm.dto;

import com.base.admin.dto.Pagination;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DisplacementsSearchDTO {
    DisplacementsDTO dto;
    Pagination pagination;
}
