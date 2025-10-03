package com.base.admin.handler;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

// https://medium.com/codestorm/custom-json-response-with-responseentity-in-spring-boot-b09e87ab1f0a
public class ResponseHandler {
    public static ResponseEntity<Object> generateResponseSuccess(String message, Object responseObj) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("statuscode", HttpStatus.OK.value());
        if (!StringUtils.isEmpty(message)) {
            map.put("message", message);
        }
        if (responseObj != null) {
            map.put("data", responseObj);
        }
        return new ResponseEntity<Object>(map, HttpStatus.OK);
    }

    public static ResponseEntity<Object> generateResponseError(String message, HttpStatus status) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("statuscode", status.value());
        map.put("message", message);
        return new ResponseEntity<Object>(map, status);
    }
}
