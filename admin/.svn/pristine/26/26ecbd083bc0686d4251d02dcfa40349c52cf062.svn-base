package com.base.admin.config;

import java.util.TimeZone;

import jakarta.annotation.PostConstruct;

import org.springframework.context.annotation.Configuration;

@Configuration
public class LocaleTimeZoneConfig {
    @PostConstruct
    public void init() {

        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
    }
}
