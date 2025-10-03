package com.base.admin.dto.mybatis;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConditionDTO {
    private String column;
    private String value;
    private String datatype;
    private String compare; // < > <= >=
    private String operator; // AND OR operator

    public void Normalize() {

    }

    public enum DataType { //For Operator type
        UUID,
        STRING,
        NUMERIC,
        TIMESTAMP
    }
}

//https://mybatis.org/mybatis-dynamic-sql/docs/conditions.html
//Column Comparison Conditions

//Equals	where(foo, isEqualTo(bar))	where foo = bar
//Greater Than	where(foo, isGreaterThan(bar))	where foo > bar
//Greater Than or Equals	where(foo, isGreaterThanOrEqualTo(bar))	where foo >= bar
//Less Than	where(foo, isLessThan(bar))	where foo < bar
//Less Than or Equals	where(foo, isLessThanOrEqualTo(bar))	where foo <= bar
//Not Equals	where(foo, isNotEqualTo(bar))	where foo <> bar