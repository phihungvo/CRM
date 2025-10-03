package com.base.admin.hrm.entity;

import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class JobPosition {
    private String jobcode;

    private String jobname;

    private String jobgroup;

    private String joblevel;

    private String jobtitle;

    private UUID unitid;

    private String unitname;

    private BigDecimal socialinsurancesalary;

    private Integer status;
}