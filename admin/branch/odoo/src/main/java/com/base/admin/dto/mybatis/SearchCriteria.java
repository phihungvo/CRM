package com.base.admin.dto.mybatis;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchCriteria {
    private List<ConditionDTO> conditions;
    private boolean exact;
}
