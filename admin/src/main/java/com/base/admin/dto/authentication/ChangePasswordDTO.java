package com.base.admin.dto.authentication;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ChangePasswordDTO {
    private UUID userid;
    private String oldPassword;
    private String newPassword;
    private String newConfirmPassword;
}
