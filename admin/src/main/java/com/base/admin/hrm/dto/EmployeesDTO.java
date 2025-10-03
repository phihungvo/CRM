package com.base.admin.hrm.dto;

import com.base.admin.hrm.entity.Employees;
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
public class EmployeesDTO {
    private UUID employeeid;

    private String employeecode;

    private String firstname;

    private String lastname;

    private String fullname;

    private Integer genderid;

    private String gendername;

    private Date birthday;

    private String personaltaxcode;

    private Integer maritalstatusid;

    private String maritalstatusname;

    private Integer familyclassbackgroundid;

    private String familyclassbackgroundname;

    private Integer ethnicid;

    private String ethnicname;

    private Integer nationalityid;

    private String nationalityname;

    private Integer personalclassbackgroundid;

    private String personalclassbackgroundname;

    private Integer religionid;

    private String religionname;

    private String birthplace;

    private String homeland;

    private String identifynumber;

    private Integer identifynumberissuedplaceid;

    private String identifynumberissuedplace;

    private Date identifynumberissueddate;

    private Date identifynumberexpireddate;

    private String passportnumber;

    private Date passportissueddate;

    private Integer passportissuedplaceid;

    private String passportissuedplacename;

    private Date passporteffectfromdate;

    private Date passporteffecttodate;

    private String educationlevel;

    private Integer educationplaceid;

    private String educationplacename;

    private Integer educationmajorid;

    private String educationmajorname;

    private Integer educationfacultyid;

    private String educationfacultyname;

    private Integer levelid;

    private String levelname;

    private Integer educationdegreeid;

    private String educationdegreename;

    private Integer awardedyear;

    private String hometel;

    private String officetel;

    private String mobile;

    private String othermobile;

    private String email;

    private String officeemail;

    private String otheremail;

    private String facebookid;

    private String skypeid;

    private String msnid;

    private Integer nativecountryid;

    private String nativecountryname;

    private String nativeprovinceid;

    private String nativeprovincename;

    private String nativedistrictid;

    private String nativedistrictname;

    private String nativewardid;

    private String nativewardname;

    private String nativestreethousenumber;

    private String nativeaddress;

    private Boolean isheadhousehold;

    private String registrationbooknumber;

    private String registrationbookcode;

    private Boolean samenativeaddress;

    private Integer currentcountryid;

    private String currentcountryname;

    private String currentprovinceid;

    private String currentprovincename;

    private String currentdistrictid;

    private String currentdistrictname;

    private String currentwardid;

    private String currentwardname;

    private String currentstreethousenumber;

    private String currentaddress;

    private String employeecodets;

    private UUID organizationunitid;

    private String organizationunitname;

    private String jobcode;

    private String jobpositionname;

    private Integer jobtitleid;

    private String jobtitlename;

    private Integer jobtitleconvertid;

    private Integer joblevelid;

    private String joblevelname;

    private Integer employeegradeid;

    private String employeegradename;

    private Integer employeestatusid;

    private String employeestatusname;

    private Boolean inactive;

    private String workingplace;

    private String laborbooknumber;

    private Integer contracttypeid;

    private String contracttypename;

    private String shiftcode;

    private Date probationdate;

    private Date hiredate;

    private Date receivedate;

    private UUID reporttoid;

    private String reporttoname;

    private UUID supervisorid;

    private String supervisorname;

    private Integer numberofleaveday;

    private String autoincrementseniority;

    private Date terminationdate;

    private UUID terminationapproverid;

    private String terminationapprover;

    private Integer terminationreasonid;

    private String terminationreasonname;

    private Integer terminationreasontypeid;

    private String terminationreasontypename;

    private String terminationfeedback;

    private Integer salarybasic;

    private Double salarysocialinsurance;

    private String bankaccountno;

    private Integer bankid;

    private String bankname;

    private Integer bankbranchid;

    private String bankbranchname;

    private Boolean istradeunion;

    private Boolean isinsurance;

    private Boolean istemplate;

    private Date socialinsurancesupplementingdate;

    private Double insurancerate;

    private String socialinsurancenumber;

    private String socialinsurancecode;

    private String identifynumberissuedprovinceid;

    private String identifynumberissuedprovincename;

    private String identifynumberissuedprovincecode;

    private String healthinsurancenumber;

    private String healthinsuranceissueplace;

    private Date healthinsuranceexpireddate;

    private String healthcareid;

    private String healthcarename;

    private String username;

    private String statusname;

    private String contactname;

    private Integer relationshipid;

    private String relationshipname;

    private String contactmobile;

    private String contacttel;

    private String contactemail;

    private String contactaddress;

    private String vocativeob;

    private String vocativeac;

    private Integer employeenatureid;

    private String employeenaturename;

    private Integer convertid;

    private String exportnewsfeed;

    private Integer kindofpaperid;

    private String kindofpapername;

    private Integer salarygradeid;

    private String salarygradename;

    private Integer proceduretypeid;

    private String proceduretypename;

    private Integer participateinsuranceid;

    private String participateinsurancename;

    private Long totalincome;

    private Date expectedretirementdate;

    private Boolean isblacklist;

    private Boolean isdeleted;

    private UUID userid;

    private UUID avatarid;
    private String base64avatar;

    private Integer statusid;

    private UUID tenantid;

    public Employees newEntity() {
        return Employees.builder()
                .employeeid(UUID.randomUUID())
                .employeecode(this.employeecode)
                .firstname(this.firstname)
                .lastname(this.lastname)
                .fullname(this.fullname)
                .genderid(this.genderid)
                .gendername(this.gendername)
                .birthday(this.birthday)
                .personaltaxcode(this.personaltaxcode)
                .maritalstatusid(this.maritalstatusid)
                .maritalstatusname(this.maritalstatusname)
                .familyclassbackgroundid(this.familyclassbackgroundid)
                .familyclassbackgroundname(this.familyclassbackgroundname)
                .ethnicid(this.ethnicid)
                .ethnicname(this.ethnicname)
                .nationalityid(this.nationalityid)
                .nationalityname(this.nationalityname)
                .personalclassbackgroundid(this.personalclassbackgroundid)
                .personalclassbackgroundname(this.personalclassbackgroundname)
                .religionid(this.religionid)
                .religionname(this.religionname)
                .birthplace(this.birthplace)
                .homeland(this.homeland)
                .identifynumber(this.identifynumber)
                .identifynumberissuedplaceid(this.identifynumberissuedplaceid)
                .identifynumberissuedplace(this.identifynumberissuedplace)
                .identifynumberissueddate(this.identifynumberissueddate)
                .identifynumberexpireddate(this.identifynumberexpireddate)
                .passportnumber(this.passportnumber)
                .passportissueddate(this.passportissueddate)
                .passportissuedplaceid(this.passportissuedplaceid)
                .passportissuedplacename(this.passportissuedplacename)
                .passporteffectfromdate(this.passporteffectfromdate)
                .passporteffecttodate(this.passporteffecttodate)
                .educationlevel(this.educationlevel)
                .educationplaceid(this.educationplaceid)
                .educationplacename(this.educationplacename)
                .educationmajorid(this.educationmajorid)
                .educationmajorname(this.educationmajorname)
                .educationfacultyid(this.educationfacultyid)
                .educationfacultyname(this.educationfacultyname)
                .levelid(this.levelid)
                .levelname(this.levelname)
                .educationdegreeid(this.educationdegreeid)
                .educationdegreename(this.educationdegreename)
                .awardedyear(this.awardedyear)
                .hometel(this.hometel)
                .officetel(this.officetel)
                .mobile(this.mobile)
                .othermobile(this.othermobile)
                .email(this.email)
                .officeemail(this.officeemail)
                .otheremail(this.otheremail)
                .facebookid(this.facebookid)
                .skypeid(this.skypeid)
                .msnid(this.msnid)
                .nativecountryid(this.nativecountryid)
                .nativecountryname(this.nativecountryname)
                .nativeprovinceid(this.nativeprovinceid)
                .nativeprovincename(this.nativeprovincename)
                .nativedistrictid(this.nativedistrictid)
                .nativedistrictname(this.nativedistrictname)
                .nativewardid(this.nativewardid)
                .nativewardname(this.nativewardname)
                .nativestreethousenumber(this.nativestreethousenumber)
                .nativeaddress(this.nativeaddress)
                .isheadhousehold(this.isheadhousehold)
                .registrationbooknumber(this.registrationbooknumber)
                .registrationbookcode(this.registrationbookcode)
                .samenativeaddress(this.samenativeaddress)
                .currentcountryid(this.currentcountryid)
                .currentcountryname(this.currentcountryname)
                .currentprovinceid(this.currentprovinceid)
                .currentprovincename(this.currentprovincename)
                .currentdistrictid(this.currentdistrictid)
                .currentdistrictname(this.currentdistrictname)
                .currentwardid(this.currentwardid)
                .currentwardname(this.currentwardname)
                .currentstreethousenumber(this.currentstreethousenumber)
                .currentaddress(this.currentaddress)
                .employeecodets(this.employeecodets)
                .organizationunitid(this.organizationunitid)
                .organizationunitname(this.organizationunitname)
                .jobcode(this.jobcode)
                .jobpositionname(this.jobpositionname)
                .jobtitleid(this.jobtitleid)
                .jobtitlename(this.jobtitlename)
                .jobtitleconvertid(this.jobtitleconvertid)
                .joblevelid(this.joblevelid)
                .joblevelname(this.joblevelname)
                .employeegradeid(this.employeegradeid)
                .employeegradename(this.employeegradename)
                .employeestatusid(this.employeestatusid)
                .employeestatusname(this.employeestatusname)
                .inactive(this.inactive)
                .workingplace(this.workingplace)
                .laborbooknumber(this.laborbooknumber)
                .contracttypeid(this.contracttypeid)
                .contracttypename(this.contracttypename)
                .shiftcode(this.shiftcode)
                .probationdate(this.probationdate)
                .hiredate(this.hiredate)
                .receivedate(this.receivedate)
                .reporttoid(this.reporttoid)
                .reporttoname(this.reporttoname)
                .supervisorid(this.supervisorid)
                .supervisorname(this.supervisorname)
                .numberofleaveday(this.numberofleaveday)
                .autoincrementseniority(this.autoincrementseniority)
                .terminationdate(this.terminationdate)
                .terminationapproverid(this.terminationapproverid)
                .terminationapprover(this.terminationapprover)
                .terminationreasonid(this.terminationreasonid)
                .terminationreasonname(this.terminationreasonname)
                .terminationreasontypeid(this.terminationreasontypeid)
                .terminationreasontypename(this.terminationreasontypename)
                .terminationfeedback(this.terminationfeedback)
                .salarybasic(this.salarybasic)
                .salarysocialinsurance(this.salarysocialinsurance)
                .bankaccountno(this.bankaccountno)
                .bankid(this.bankid)
                .bankname(this.bankname)
                .bankbranchid(this.bankbranchid)
                .bankbranchname(this.bankbranchname)
                .istradeunion(this.istradeunion)
                .isinsurance(this.isinsurance)
                .istemplate(this.istemplate)
                .socialinsurancesupplementingdate(this.socialinsurancesupplementingdate)
                .insurancerate(this.insurancerate)
                .socialinsurancenumber(this.socialinsurancenumber)
                .socialinsurancecode(this.socialinsurancecode)
                .identifynumberissuedprovinceid(this.identifynumberissuedprovinceid)
                .identifynumberissuedprovincename(this.identifynumberissuedprovincename)
                .identifynumberissuedprovincecode(this.identifynumberissuedprovincecode)
                .healthinsurancenumber(this.healthinsurancenumber)
                .healthinsuranceissueplace(this.healthinsuranceissueplace)
                .healthinsuranceexpireddate(this.healthinsuranceexpireddate)
                .healthcareid(this.healthcareid)
                .healthcarename(this.healthcarename)
                .username(this.username)
                .statusname(this.statusname)
                .contactname(this.contactname)
                .relationshipid(this.relationshipid)
                .relationshipname(this.relationshipname)
                .contactmobile(this.contactmobile)
                .contacttel(this.contacttel)
                .contactemail(this.contactemail)
                .contactaddress(this.contactaddress)
                .vocativeob(this.vocativeob)
                .vocativeac(this.vocativeac)
                .employeenatureid(this.employeenatureid)
                .employeenaturename(this.employeenaturename)
                .convertid(this.convertid)
                .exportnewsfeed(this.exportnewsfeed)
                .kindofpaperid(this.kindofpaperid)
                .kindofpapername(this.kindofpapername)
                .salarygradeid(this.salarygradeid)
                .salarygradename(this.salarygradename)
                .proceduretypeid(this.proceduretypeid)
                .proceduretypename(this.proceduretypename)
                .participateinsuranceid(this.participateinsuranceid)
                .participateinsurancename(this.participateinsurancename)
                .totalincome(this.totalincome)
                .expectedretirementdate(this.expectedretirementdate)
                .isblacklist(this.isblacklist)
                .isdeleted(this.isdeleted)
                .userid(this.userid)
                .avatarid(this.avatarid)
                .statusid(this.statusid)
                .tenantid(this.tenantid) //new
                .createdate(new Date())
                .active(true)
                .build();
    }
}
