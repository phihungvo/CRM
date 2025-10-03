package com.base.admin.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse {
    private Integer statuscode;
    private String message;

    public ApiResponse(Integer statuscode, String message) {
        this.statuscode = statuscode;
        this.message = message;
    }
}
