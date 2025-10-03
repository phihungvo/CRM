package com.base.admin.quartz.util;

import com.base.admin.dto.UsersDTO;
import jakarta.servlet.http.HttpServletRequest;

public class EmailTemplate {

    private final HttpServletRequest request;
    private final UsersDTO user;
    private final String token;

    public EmailTemplate(HttpServletRequest request, UsersDTO user, String token) {
        this.request = request;
        this.user = user;
        this.token = token;
    }


    public String createMessagePasswordResetTokenForUser() {
        final String url = getAppUrl(request) + "/auth/reset-password?token=" + token;
        String message = "Hi " + user.getUsername() + ",\r\n" +
                "\r\n" +
                "You are receiving this email because you (or someone else) have requested the reset of the password for your account.\r\n" +
                "\r\n" +
                "Please click on the following link, or paste this into your browser to complete the process:\r\n" +
                "\r\n" +
                url + "\r\n" +
                "\r\n" +
                "If you did not request this, please ignore this email and your password will remain unchanged.\r\n" +
                "\r\n";

        return message;
    }

    private String getAppUrl(HttpServletRequest request) {
        return "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    }


}
