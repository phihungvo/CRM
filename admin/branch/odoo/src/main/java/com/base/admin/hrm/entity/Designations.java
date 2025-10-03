package com.base.admin.hrm.entity;

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
public class Designations {
    private UUID designateid;

    private UUID employeeid;

    private UUID unitid;

    private UUID designateunitid;

    //    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date effectivedate;

    private String designatenumber;

    private Integer jobtitleid;

    private Integer designatestatusid;
}
