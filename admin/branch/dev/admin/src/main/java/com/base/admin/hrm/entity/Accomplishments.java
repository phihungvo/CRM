package com.base.admin.hrm.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class Accomplishments {
    private UUID accomplishmentid;

    private String accomplishmentname;

    private Date accomplishmentdate;

    private String accomplishmentnumber;

    private UUID accomplishmentapproverid;

    private Integer accomplishmentformid;

    private Integer accomplishmentobjectid;

    private Integer unitlevelid;

    private String reason;

    private UUID unitid;

    private Integer accomplishmenttypeid;

    private Date decisiondate;

    private Float totalvalue;

    private Integer accomplishmentobjectdetailid;

    private Integer accomplishmentstatusid;
}