package com.base.admin.hrm.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Dismissions {
    private UUID dismissionid;

    private UUID employeeid;

    private UUID unitid;

    private UUID dismissionunitid;

    private Date effectivedate;

    private String dismissionnumber;

    private Integer jobtitleid;

    private Integer dismissionstatusid;
}