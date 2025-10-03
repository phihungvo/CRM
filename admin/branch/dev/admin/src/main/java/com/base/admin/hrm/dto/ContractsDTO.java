package com.base.admin.hrm.dto;

import com.base.admin.hrm.entity.Contracts;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ContractsDTO {
    private UUID contractid;

    private UUID organizationid;

    private UUID employeeid;

    private String employeename;

    private String employeecode;

    private String contractno;

    private String contractsubject;

    private Integer contracttypeid;

    private String contracttypename;

    private Date signeddate;

    private Date startdate;

    private Date enddate;

    private String jobpositioncode;

    private String jobpositionname;

    private UUID organizationunitid;

    private String organizationunitname;

    private String organizationunitcode;

    private Integer employeestatusid;

    private String employeestatusname;

    private Float salarybasic;

    private Float salaryrate;

    private Float salaryforinsurance;

    private Integer contractperiodid;

    private String contractperiodname;

    private UUID onbehalfofemployerid;

    private String onbehalfofemployername;

    private Integer jobtitleid;

    private String jobtitlename;

    private String summary;

    private Integer worktypeid;

    private String worktypename;

    private UUID attachmentid;

    private String attachmentname;

    private String description;

    private String workingplace;

    private Integer contractstatusid;

    private String contractstatusname;

    private Integer contractstatussignid;

    private String contractstatussignname;

    private Integer lastcontracttypeid;

    private String lastcontracttypename;

    private Date laststartdate;

    private Date lastenddate;

    private Integer lastcontractperiodid;

    private String lastcontractperiodname;

    private String lastjobpositioncode;

    private String lastjobpositionname;

    private UUID lastorganizationunitid;

    private String lastorganizationunitname;

    private Integer lastworktypeid;

    private String lastworktypename;

    private String lastsalaryforinsurance;

    private Float lastsalarybasic;

    private Float lastsalaryrate;

    private String officeemail;

    private Date hiredate;

    private Date receivedate;

    private UUID employeeorganizationid;

    private Integer convertid;

    private String isdeleted;

    private Integer tenantid;

    public Contracts newEntity() {
        Contracts contracts = new Contracts();
        contracts.setContractid(UUID.randomUUID());
        contracts.setOrganizationid(getOrganizationid());
        contracts.setEmployeeid(getEmployeeid());
        contracts.setEmployeename(getEmployeename());
        contracts.setEmployeecode(getEmployeecode());
        contracts.setContractno(getContractno());
        contracts.setContractsubject(getContractsubject());
        contracts.setContracttypeid(getContracttypeid());
        contracts.setContracttypename(getContracttypename());
        contracts.setSigneddate(getSigneddate());
        contracts.setStartdate(getStartdate());
        contracts.setEnddate(getEnddate());
        contracts.setJobpositioncode(getJobpositioncode());
        contracts.setJobpositionname(getJobpositionname());
        contracts.setOrganizationunitid(getOrganizationunitid());
        contracts.setOrganizationunitname(getOrganizationunitname());
        contracts.setOrganizationunitcode(getOrganizationunitcode());
        contracts.setEmployeestatusid(getEmployeestatusid());
        contracts.setEmployeestatusname(getEmployeestatusname());
        contracts.setSalarybasic(getSalarybasic());
        contracts.setSalaryrate(getSalaryrate());
        contracts.setSalaryforinsurance(getSalaryforinsurance());
        contracts.setContractperiodid(getContractperiodid());
        contracts.setContractperiodname(getContractperiodname());
        contracts.setOnbehalfofemployerid(getOnbehalfofemployerid());
        contracts.setOnbehalfofemployername(getOnbehalfofemployername());
        contracts.setJobtitleid(getJobtitleid());
        contracts.setJobtitlename(getJobtitlename());
        contracts.setSummary(getSummary());
        contracts.setWorktypeid(getWorktypeid());
        contracts.setWorktypename(getWorktypename());
        contracts.setAttachmentid(getAttachmentid());
        contracts.setAttachmentname(getAttachmentname());
        contracts.setDescription(getDescription());
        contracts.setWorkingplace(getWorkingplace());
        contracts.setContractstatusid(getContractstatusid());
        contracts.setContractstatusname(getContractstatusname());
        contracts.setContractstatussignid(getContractstatussignid());
        contracts.setContractstatussignname(getContractstatussignname());
        contracts.setLastcontracttypeid(getLastcontracttypeid());
        contracts.setLastcontracttypename(getLastcontracttypename());
        contracts.setLaststartdate(getLaststartdate());
        contracts.setLastenddate(getLastenddate());
        contracts.setLastcontractperiodid(getLastcontractperiodid());
        contracts.setLastcontractperiodname(getLastcontractperiodname());
        contracts.setLastjobpositioncode(getLastjobpositioncode());
        contracts.setLastjobpositionname(getLastjobpositionname());
        contracts.setLastorganizationunitid(getLastorganizationunitid());
        contracts.setLastorganizationunitname(getLastorganizationunitname());
        contracts.setLastworktypeid(getLastworktypeid());
        contracts.setLastworktypename(getLastworktypename());
        contracts.setLastsalaryforinsurance(getLastsalaryforinsurance());
        contracts.setLastsalarybasic(getLastsalarybasic());
        contracts.setLastsalaryrate(getLastsalaryrate());
        contracts.setOfficeemail(getOfficeemail());
        contracts.setHiredate(getHiredate());
        contracts.setReceivedate(getReceivedate());
        contracts.setEmployeeorganizationid(getEmployeeorganizationid());
        contracts.setConvertid(getConvertid());
        contracts.setIsdeleted(getIsdeleted());
        contracts.setTenantid(getTenantid());
        contracts.setCreatedate(new Date());
        contracts.setModifieddate(null);
        contracts.setUserupdate(null);
        contracts.setActive(true);
        return contracts;
    }
}