package com.base.admin.entity;

import java.util.UUID;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
public class Actions {
    private UUID actionid;

    private UUID resourceid;

    private String actionname;

    private String resourcename;
}
