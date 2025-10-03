package com.base.admin.hrm.entity;

import lombok.*;

import java.util.Date;
import java.util.UUID;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Terminations {
    private UUID terminationid;

    private UUID employeeid;

    private UUID contractid;

    private Integer terminationreasonid;

    private Date terminationdate;

    private UUID terminationapproverid;

    private String terminationfeedback;

    private String terminationnumber;

    private Integer terminationstatusid;
}