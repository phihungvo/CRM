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
public class Displacements {
    private UUID displacementid;

    private UUID employeeid;

    private UUID unitid;

    private UUID displacementunitid;

    private Date effectivedate;

    private String displacementnumber;

    private Integer jobtitleid;

    private Integer displacementstatusid;
}