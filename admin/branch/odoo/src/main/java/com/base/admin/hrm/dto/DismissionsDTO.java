package com.base.admin.hrm.dto;

import java.util.Date;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DismissionsDTO {
    private UUID dismissionid;

    private UUID employeeid;

    private UUID unitid;

    private UUID dismissionunitid;

    private Date effectivedate;

    private String dismissionnumber;

    private Integer jobtitleid;

    private Integer dismissionstatusid;

    // extra fields
    private String employeecode;
    private String fullname;
    private String unitname;
    private String dismissionunitname;
    private String jobtitlename;
}
