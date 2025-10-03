package com.base.admin.entity;

import java.util.Date;
import java.util.UUID;

import lombok.*;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Resetpasswordtoken {
    private UUID userid;

    private String token;

    private Date expirydate;
}
