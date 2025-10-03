package com.base.admin.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ModulesSearchDTO {
    Pagination pagination;
    private ModulesDTO dto;
}
