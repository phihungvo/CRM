package com.base.admin.hrm.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConditionDTO {
    private String column;
    private String value;
    private ConditionType type;

    public enum ConditionType {
        STRING,
        NUMERIC,
        TIMESTAMP
    }
}
