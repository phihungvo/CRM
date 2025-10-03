package com.base.admin.hrm.dto;

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
public class TerminationsDTO {
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