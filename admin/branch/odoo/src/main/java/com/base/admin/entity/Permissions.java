package com.base.admin.entity;

import java.util.UUID;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
public class Permissions {
    private UUID roleid;

    private UUID moduleid;

    private UUID pageid;

    private UUID actionid;

    private boolean isselected;
}
