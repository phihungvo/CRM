package com.base.admin.dto.mybatis;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SearchCriteria {
    private List<ConditionDTO> conditions;
    private boolean exact;
}
