package com.base.admin.constant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilterConstant {
    public static final String[] FILTER_WHITELIST = {
        //            "/swagger-resources",
        //            "/swagger-resources",
        //            "/configuration/ui",
        //            "/configuration/security",
        //            "/swagger-ui.html",
        //            "/webjars",
        "/api-docs",
        //            "/v3/api-docs",
        //            "/api/public",
        //            "/api/public/authenticate",
        //            "/actuator",
        "/swagger-ui",
        "/api/v1/auth"
    };

    public static String[] ToFilterArray() {
        List<String> whitelist = new ArrayList<>();
        Arrays.stream(FILTER_WHITELIST).parallel().forEach(i -> whitelist.add(i + "/**"));

        return whitelist.toArray(new String[whitelist.size()]);
    }
}
