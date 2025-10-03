/*
PostgreSQL Backup
Database: hrm/public
Backup Time: 2024-12-13 16:23:10
*/

DROP TABLE IF EXISTS "public"."accomplishment_objectdetail";
DROP TABLE IF EXISTS "public"."accomplishments";
DROP TABLE IF EXISTS "public"."contract_status";
DROP TABLE IF EXISTS "public"."contract_time";
DROP TABLE IF EXISTS "public"."contract_type";
DROP TABLE IF EXISTS "public"."contract_worktype";
DROP TABLE IF EXISTS "public"."contracts";
DROP TABLE IF EXISTS "public"."designations";
DROP TABLE IF EXISTS "public"."dismissions";
DROP TABLE IF EXISTS "public"."displacements";
DROP TABLE IF EXISTS "public"."employees";
DROP TABLE IF EXISTS "public"."job_group";
DROP TABLE IF EXISTS "public"."job_level";
DROP TABLE IF EXISTS "public"."job_position";
DROP TABLE IF EXISTS "public"."job_title";
DROP TABLE IF EXISTS "public"."termination_reason";
DROP TABLE IF EXISTS "public"."terminations";
DROP TABLE IF EXISTS "public"."unit_level";
DROP TABLE IF EXISTS "public"."units";
CREATE TABLE "accomplishment_objectdetail" (
  "accomplishmentobjectdetailid" int4 NOT NULL,
  "accomplishmentobjectdetailname" varchar COLLATE "pg_catalog"."default",
  "position" int4,
  "is_favorite" bool,
  "is_system" bool
)
;
ALTER TABLE "accomplishment_objectdetail" OWNER TO "postgres";
CREATE TABLE "accomplishments" (
  "accomplishmentid" uuid NOT NULL,
  "accomplishmentname" varchar(255) COLLATE "pg_catalog"."default",
  "accomplishmentdate" date,
  "accomplishmentnumber" varchar(20) COLLATE "pg_catalog"."default",
  "accomplishmentapproverid" uuid,
  "accomplishmentformid" int4,
  "accomplishmentobjectid" int4,
  "unitlevelid" uuid,
  "reason" varchar(255) COLLATE "pg_catalog"."default",
  "unitid" uuid,
  "accomplishmenttypeid" int4,
  "
decisiondate" date,
  "totalvalue" float4,
  "accomplishmentobjectdetailid" int4,
  "accomplishmentstatusid" int4
)
;
ALTER TABLE "accomplishments" OWNER TO "postgres";
COMMENT ON COLUMN "accomplishments"."accomplishmentid" IS 'khen thưởng';
CREATE TABLE "contract_status" (
  "contractstatusid" int4 NOT NULL,
  "contractstatusname" varchar(50) COLLATE "pg_catalog"."default",
  "position" int4,
  "is_favorite" bool,
  "is_system" bool
)
;
ALTER TABLE "contract_status" OWNER TO "postgres";
CREATE TABLE "contract_time" (
  "contracttimeid" int4 NOT NULL,
  "contractimename" varchar(50) COLLATE "pg_catalog"."default",
  "position" int4,
  "is_favorite" bool,
  "is_system" bool
)
;
ALTER TABLE "contract_time" OWNER TO "postgres";
CREATE TABLE "contract_type" (
  "contracttypeid" int4 NOT NULL,
  "contracttypename" varchar(50) COLLATE "pg_catalog"."default",
  "position" int4,
  "is_favorite" bool,
  "is_system" bool
)
;
ALTER TABLE "contract_type" OWNER TO "postgres";
CREATE TABLE "contract_worktype" (
  "contractworktypeid" int4 NOT NULL,
  "contractworktypename" varchar(50) COLLATE "pg_catalog"."default",
  "position" int4,
  "is_favorite" bool,
  "is_system" bool
)
;
ALTER TABLE "contract_worktype" OWNER TO "postgres";
CREATE TABLE "contracts" (
  "organizationid" uuid NOT NULL,
  "contractid" uuid NOT NULL,
  "employeeid" uuid,
  "employeename" varchar(255) COLLATE "pg_catalog"."default",
  "employeecode" varchar(255) COLLATE "pg_catalog"."default",
  "contractno" varchar(255) COLLATE "pg_catalog"."default",
  "contractsubject" varchar(255) COLLATE "pg_catalog"."default",
  "contracttypeid" int4,
  "contracttypename" varchar(255) COLLATE "pg_catalog"."default",
  "signeddate" date,
  "startdate" date,
  "enddate" date,
  "jobpositioncode" varchar COLLATE "pg_catalog"."default",
  "jobpositionname" varchar(255) COLLATE "pg_catalog"."default",
  "organizationunitid" uuid,
  "organizationunitname" varchar(255) COLLATE "pg_catalog"."default",
  "organizationunitcode" varchar(255) COLLATE "pg_catalog"."default",
  "employeestatusid" int4,
  "employeestatusname" varchar(255) COLLATE "pg_catalog"."default",
  "salarybasic" float4,
  "salaryrate" float4,
  "salaryforinsurance" float4,
  "contractperiodid" int4,
  "contractperiodname" varchar(255) COLLATE "pg_catalog"."default",
  "onbehalfofemployerid" uuid,
  "onbehalfofemployername" varchar(255) COLLATE "pg_catalog"."default",
  "jobtitleid" int4,
  "jobtitlename" varchar(255) COLLATE "pg_catalog"."default",
  "summary" varchar(255) COLLATE "pg_catalog"."default",
  "worktypeid" int4,
  "worktypename" varchar(255) COLLATE "pg_catalog"."default",
  "attachmentid" uuid,
  "attachmentname" varchar(255) COLLATE "pg_catalog"."default",
  "description" varchar(255) COLLATE "pg_catalog"."default",
  "workingplace" varchar(255) COLLATE "pg_catalog"."default",
  "contractstatusid" int4,
  "contractstatusname" varchar(255) COLLATE "pg_catalog"."default",
  "contractstatussignid" int4,
  "contractstatussignname" varchar(255) COLLATE "pg_catalog"."default",
  "lastcontracttypeid" int4,
  "lastcontracttypename" varchar(255) COLLATE "pg_catalog"."default",
  "laststartdate" date,
  "lastenddate" date,
  "lastcontractperiodid" int4,
  "lastcontractperiodname" varchar(255) COLLATE "pg_catalog"."default",
  "lastjobpositioncode" varchar COLLATE "pg_catalog"."default",
  "lastjobpositionname" varchar(255) COLLATE "pg_catalog"."default",
  "lastorganizationunitid" uuid,
  "lastorganizationunitname" varchar(255) COLLATE "pg_catalog"."default",
  "lastworktypeid" int4,
  "lastworktypename" varchar(255) COLLATE "pg_catalog"."default",
  "lastsalaryforinsurance" varchar(255) COLLATE "pg_catalog"."default",
  "lastsalarybasic" float4,
  "lastsalaryrate" float4,
  "officeemail" varchar(255) COLLATE "pg_catalog"."default",
  "hiredate" date,
  "receivedate" date,
  "employeeorganizationid" uuid,
  "convertid" int4,
  "isdeleted" varchar(255) COLLATE "pg_catalog"."default",
  "tenantid" int4,
  "createdate" date,
  "modifieddate" date,
  "userupdate" varchar(255) COLLATE "pg_catalog"."default",
  "active" bool
)
;
ALTER TABLE "contracts" OWNER TO "postgres";
CREATE TABLE "designations" (
  "designateid" uuid NOT NULL,
  "employeeid" uuid,
  "unitid" uuid,
  "designateunitid" uuid,
  "effectivedate" date,
  "designatenumber" varchar(20) COLLATE "pg_catalog"."default",
  "jobtitleid" int4,
  "designatestatusid" int4
)
;
ALTER TABLE "designations" OWNER TO "postgres";
COMMENT ON COLUMN "designations"."designateid" IS 'Bổ nhiệm';
CREATE TABLE "dismissions" (
  "dismissionid" uuid NOT NULL,
  "employeeid" uuid,
  "unitid" uuid,
  "dismissionunitid" uuid,
  "effectivedate" date,
  "dismissionnumber" varchar(20) COLLATE "pg_catalog"."default",
  "jobtitleid" int4,
  "dismissionstatusid" int4
)
;
ALTER TABLE "dismissions" OWNER TO "postgres";
COMMENT ON COLUMN "dismissions"."dismissionid" IS 'miễn nhiệm';
CREATE TABLE "displacements" (
  "displacementid" uuid NOT NULL,
  "employeeid" uuid,
  "unitid" uuid,
  "displacementunitid" uuid,
  "effectivedate" date,
  "displacementnumber" varchar(20) COLLATE "pg_catalog"."default",
  "jobtitleid" int4,
  "displacementstatusid" int4
)
;
ALTER TABLE "displacements" OWNER TO "postgres";
COMMENT ON COLUMN "displacements"."displacementid" IS 'Thuyên chuyển';
CREATE TABLE "employees" (
  "employeeid" uuid NOT NULL,
  "employeecode" varchar(20) COLLATE "pg_catalog"."default",
  "firstname" varchar(50) COLLATE "pg_catalog"."default",
  "lastname" varchar(50) COLLATE "pg_catalog"."default",
  "fullname" varchar(100) COLLATE "pg_catalog"."default",
  "genderid" int4,
  "gendername" varchar(20) COLLATE "pg_catalog"."default",
  "birthday" date,
  "personaltaxcode" varchar(50) COLLATE "pg_catalog"."default",
  "maritalstatusid" int4,
  "maritalstatusname" varchar(50) COLLATE "pg_catalog"."default",
  "familyclassbackgroundid" int4,
  "familyclassbackgroundname" varchar(50) COLLATE "pg_catalog"."default",
  "ethnicid" int4,
  "ethnicname" varchar(50) COLLATE "pg_catalog"."default",
  "nationalityid" int4,
  "nationalityname" varchar(100) COLLATE "pg_catalog"."default",
  "personalclassbackgroundid" int4,
  "personalclassbackgroundname" varchar(50) COLLATE "pg_catalog"."default",
  "religionid" int4,
  "religionname" varchar(50) COLLATE "pg_catalog"."default",
  "birthplace" varchar(255) COLLATE "pg_catalog"."default",
  "homeland" varchar(255) COLLATE "pg_catalog"."default",
  "identifynumber" varchar(50) COLLATE "pg_catalog"."default",
  "identifynumberissuedplaceid" int4,
  "identifynumberissuedplace" varchar(100) COLLATE "pg_catalog"."default",
  "identifynumberissueddate" date,
  "identifynumberexpireddate" date,
  "passportnumber" varchar(50) COLLATE "pg_catalog"."default",
  "passportissueddate" date,
  "passportissuedplaceid" int4,
  "passportissuedplacename" varchar(100) COLLATE "pg_catalog"."default",
  "passporteffectfromdate" date,
  "passporteffecttodate" date,
  "educationlevel" varchar(50) COLLATE "pg_catalog"."default",
  "educationplaceid" int4,
  "educationplacename" varchar(100) COLLATE "pg_catalog"."default",
  "educationmajorid" int4,
  "educationmajorname" varchar(100) COLLATE "pg_catalog"."default",
  "educationfacultyid" int4,
  "educationfacultyname" varchar(100) COLLATE "pg_catalog"."default",
  "levelid" int4,
  "levelname" varchar(50) COLLATE "pg_catalog"."default",
  "educationdegreeid" int4,
  "educationdegreename" varchar(50) COLLATE "pg_catalog"."default",
  "awardedyear" int4,
  "hometel" varchar(50) COLLATE "pg_catalog"."default",
  "officetel" varchar(50) COLLATE "pg_catalog"."default",
  "mobile" varchar(50) COLLATE "pg_catalog"."default",
  "othermobile" varchar(50) COLLATE "pg_catalog"."default",
  "email" varchar(50) COLLATE "pg_catalog"."default",
  "officeemail" varchar(50) COLLATE "pg_catalog"."default",
  "otheremail" varchar(50) COLLATE "pg_catalog"."default",
  "facebookid" varchar(50) COLLATE "pg_catalog"."default",
  "skypeid" varchar(50) COLLATE "pg_catalog"."default",
  "msnid" varchar(50) COLLATE "pg_catalog"."default",
  "nativecountryid" int4,
  "nativecountryname" varchar(50) COLLATE "pg_catalog"."default",
  "nativeprovinceid" varchar(20) COLLATE "pg_catalog"."default",
  "nativeprovincename" varchar(100) COLLATE "pg_catalog"."default",
  "nativedistrictid" varchar(20) COLLATE "pg_catalog"."default",
  "nativedistrictname" varchar(50) COLLATE "pg_catalog"."default",
  "nativewardid" varchar(20) COLLATE "pg_catalog"."default",
  "nativewardname" varchar(50) COLLATE "pg_catalog"."default",
  "nativestreethousenumber" varchar(100) COLLATE "pg_catalog"."default",
  "nativeaddress" varchar(255) COLLATE "pg_catalog"."default",
  "isheadhousehold" bool,
  "registrationbooknumber" varchar(50) COLLATE "pg_catalog"."default",
  "registrationbookcode" varchar(20) COLLATE "pg_catalog"."default",
  "samenativeaddress" bool,
  "currentcountryid" int4,
  "currentcountryname" varchar(50) COLLATE "pg_catalog"."default",
  "currentprovinceid" varchar(20) COLLATE "pg_catalog"."default",
  "currentprovincename" varchar(50) COLLATE "pg_catalog"."default",
  "currentdistrictid" varchar(20) COLLATE "pg_catalog"."default",
  "currentdistrictname" varchar(50) COLLATE "pg_catalog"."default",
  "currentwardid" varchar(20) COLLATE "pg_catalog"."default",
  "currentwardname" varchar(50) COLLATE "pg_catalog"."default",
  "currentstreethousenumber" varchar(100) COLLATE "pg_catalog"."default",
  "currentaddress" varchar(255) COLLATE "pg_catalog"."default",
  "employeecodets" varchar(20) COLLATE "pg_catalog"."default",
  "organizationunitid" uuid,
  "organizationunitname" varchar(50) COLLATE "pg_catalog"."default",
  "jobcode" varchar(20) COLLATE "pg_catalog"."default",
  "jobpositionname" varchar(255) COLLATE "pg_catalog"."default",
  "jobtitleid" int4,
  "jobtitlename" varchar(50) COLLATE "pg_catalog"."default",
  "jobtitleconvertid" int4,
  "joblevelid" int4,
  "joblevelname" varchar(50) COLLATE "pg_catalog"."default",
  "employeegradeid" int4,
  "employeegradename" varchar(50) COLLATE "pg_catalog"."default",
  "employeestatusid" int4,
  "employeestatusname" varchar(50) COLLATE "pg_catalog"."default",
  "inactive" bool,
  "workingplace" varchar(50) COLLATE "pg_catalog"."default",
  "laborbooknumber" varchar(50) COLLATE "pg_catalog"."default",
  "contracttypeid" int4,
  "contracttypename" varchar(50) COLLATE "pg_catalog"."default",
  "shiftcode" varchar(50) COLLATE "pg_catalog"."default",
  "probationdate" date,
  "hiredate" date,
  "receivedate" date,
  "reporttoid" uuid,
  "reporttoname" varchar(50) COLLATE "pg_catalog"."default",
  "supervisorid" uuid,
  "supervisorname" varchar(50) COLLATE "pg_catalog"."default",
  "numberofleaveday" int4,
  "autoincrementseniority" varchar(255) COLLATE "pg_catalog"."default",
  "terminationdate" date,
  "terminationapproverid" uuid,
  "terminationapprover" varchar(50) COLLATE "pg_catalog"."default",
  "terminationreasonid" int4,
  "terminationreasonname" varchar(50) COLLATE "pg_catalog"."default",
  "terminationreasontypeid" int4,
  "terminationreasontypename" varchar(50) COLLATE "pg_catalog"."default",
  "terminationfeedback" varchar(255) COLLATE "pg_catalog"."default",
  "salarybasic" int4,
  "salarysocialinsurance" float8,
  "bankaccountno" varchar(50) COLLATE "pg_catalog"."default",
  "bankid" int4,
  "bankname" varchar(255) COLLATE "pg_catalog"."default",
  "bankbranchid" int4,
  "bankbranchname" varchar(255) COLLATE "pg_catalog"."default",
  "istradeunion" bool,
  "isinsurance" bool,
  "istemplate" bool,
  "socialinsurancesupplementingdate" date,
  "insurancerate" float8,
  "socialinsurancenumber" varchar(20) COLLATE "pg_catalog"."default",
  "socialinsurancecode" varchar(20) COLLATE "pg_catalog"."default",
  "identifynumberissuedprovinceid" varchar(20) COLLATE "pg_catalog"."default",
  "identifynumberissuedprovincename" varchar(50) COLLATE "pg_catalog"."default",
  "identifynumberissuedprovincecode" varchar(20) COLLATE "pg_catalog"."default",
  "healthinsurancenumber" varchar(20) COLLATE "pg_catalog"."default",
  "healthinsuranceissueplace" varchar(50) COLLATE "pg_catalog"."default",
  "healthinsuranceexpireddate" date,
  "healthcareid" varchar(20) COLLATE "pg_catalog"."default",
  "healthcarename" varchar(50) COLLATE "pg_catalog"."default",
  "username" varchar(50) COLLATE "pg_catalog"."default",
  "statusname" varchar(50) COLLATE "pg_catalog"."default",
  "contactname" varchar(50) COLLATE "pg_catalog"."default",
  "relationshipid" int4,
  "relationshipname" varchar(50) COLLATE "pg_catalog"."default",
  "contactmobile" varchar(20) COLLATE "pg_catalog"."default",
  "contacttel" varchar(20) COLLATE "pg_catalog"."default",
  "contactemail" varchar(50) COLLATE "pg_catalog"."default",
  "contactaddress" varchar(255) COLLATE "pg_catalog"."default",
  "vocativeob" varchar(50) COLLATE "pg_catalog"."default",
  "vocativeac" varchar(50) COLLATE "pg_catalog"."default",
  "employeenatureid" int4,
  "employeenaturename" varchar(50) COLLATE "pg_catalog"."default",
  "convertid" int4,
  "exportnewsfeed" varchar(50) COLLATE "pg_catalog"."default",
  "kindofpaperid" int4,
  "kindofpapername" varchar(50) COLLATE "pg_catalog"."default",
  "salarygradeid" int4,
  "salarygradename" varchar(50) COLLATE "pg_catalog"."default",
  "proceduretypeid" int4,
  "proceduretypename" varchar(50) COLLATE "pg_catalog"."default",
  "participateinsuranceid" int4,
  "participateinsurancename" varchar(50) COLLATE "pg_catalog"."default",
  "totalincome" int8,
  "expectedretirementdate" date,
  "isblacklist" bool,
  "isdeleted" bool,
  "userid" uuid,
  "avatarid" uuid,
  "statusid" int4,
  "tenantid" uuid,
  "createdate" timestamp(6),
  "modifieddate" timestamp(6),
  "userupdate" varchar(100) COLLATE "pg_catalog"."default",
  "active" bool
)
;
ALTER TABLE "employees" OWNER TO "postgres";
CREATE TABLE "job_group" (
  "jobgroupid" int4 NOT NULL,
  "jobgroupname" varchar(50) COLLATE "pg_catalog"."default",
  "position" int4,
  "is_favorite" bool,
  "is_system" bool
)
;
ALTER TABLE "job_group" OWNER TO "postgres";
CREATE TABLE "job_level" (
  "joblevelid" int4 NOT NULL,
  "joblevelname" varchar(50) COLLATE "pg_catalog"."default",
  "position" int4,
  "is_favorite" bool,
  "is_system" bool
)
;
ALTER TABLE "job_level" OWNER TO "postgres";
CREATE TABLE "job_position" (
  "jobcode" varchar(20) COLLATE "pg_catalog"."default" NOT NULL,
  "jobname" varchar(100) COLLATE "pg_catalog"."default",
  "jobgroup" varchar(100) COLLATE "pg_catalog"."default",
  "joblevel" varchar(100) COLLATE "pg_catalog"."default",
  "jobtitle" varchar(100) COLLATE "pg_catalog"."default",
  "unitid" uuid,
  "unitname" varchar(200) COLLATE "pg_catalog"."default",
  "socialinsurancesalary" numeric(10,2),
  "status" int4
)
;
ALTER TABLE "job_position" OWNER TO "postgres";
CREATE TABLE "job_title" (
  "jobtitleid" int4 NOT NULL,
  "jobtitlename" varchar(50) COLLATE "pg_catalog"."default",
  "position" int4,
  "is_favorite" bool,
  "is_system" bool
)
;
ALTER TABLE "job_title" OWNER TO "postgres";
CREATE TABLE "termination_reason" (
  "terminationreasonid" int4 NOT NULL,
  "terminationreasonname" varchar(255) COLLATE "pg_catalog"."default",
  "position" int4,
  "is_favorite" bool,
  "is_system" bool
)
;
ALTER TABLE "termination_reason" OWNER TO "postgres";
CREATE TABLE "terminations" (
  "terminationid" uuid NOT NULL,
  "employeeid" uuid,
  "contractid" uuid,
  "terminationreasonid" int4,
  "terminationdate" date,
  "terminationapproverid" uuid,
  "terminationfeedback" varchar(255) COLLATE "pg_catalog"."default",
  "terminationnumber" varchar(20) COLLATE "pg_catalog"."default",
  "terminationstatusid" int4
)
;
ALTER TABLE "terminations" OWNER TO "postgres";
COMMENT ON COLUMN "terminations"."terminationid" IS 'nghỉ việc';
CREATE TABLE "unit_level" (
  "unitlevelid" int4 NOT NULL,
  "level" int4,
  "unitlevelname" varchar(255) COLLATE "pg_catalog"."default",
  "position" int4,
  "is_favorite" bool,
  "is_system" bool
)
;
ALTER TABLE "unit_level" OWNER TO "postgres";
CREATE TABLE "units" (
  "organizationid" uuid NOT NULL,
  "parentunitid" uuid,
  "unitid" uuid NOT NULL,
  "unitcode" varchar(20) COLLATE "pg_catalog"."default",
  "unitlevelid" int4,
  "registrationnumber" varchar(50) COLLATE "pg_catalog"."default",
  "address" varchar(255) COLLATE "pg_catalog"."default",
  "unitname" varchar(255) COLLATE "pg_catalog"."default",
  "symbol" varchar(20) COLLATE "pg_catalog"."default",
  "leaderids" varchar(255) COLLATE "pg_catalog"."default",
  "responsibility" varchar(255) COLLATE "pg_catalog"."default",
  "status" int4
)
;
ALTER TABLE "units" OWNER TO "postgres";
BEGIN;
LOCK TABLE "public"."accomplishment_objectdetail" IN SHARE MODE;
DELETE FROM "public"."accomplishment_objectdetail";
INSERT INTO "public"."accomplishment_objectdetail" ("accomplishmentobjectdetailid","accomplishmentobjectdetailname","position","is_favorite","is_system") VALUES (2, 'Phòng ban', 2, 'f', 't'),(1, 'Nhân viên', 1, 'f', 't')
;
COMMIT;
BEGIN;
LOCK TABLE "public"."accomplishments" IN SHARE MODE;
DELETE FROM "public"."accomplishments";
COMMIT;
BEGIN;
LOCK TABLE "public"."contract_status" IN SHARE MODE;
DELETE FROM "public"."contract_status";
INSERT INTO "public"."contract_status" ("contractstatusid","contractstatusname","position","is_favorite","is_system") VALUES (1, 'Đã ký', NULL, NULL, NULL),(2, 'Chưa ký', NULL, NULL, NULL)
;
COMMIT;
BEGIN;
LOCK TABLE "public"."contract_time" IN SHARE MODE;
DELETE FROM "public"."contract_time";
INSERT INTO "public"."contract_time" ("contracttimeid","contractimename","position","is_favorite","is_system") VALUES (1, '1 tháng', 1, 'f', 't'),(2, '2 tháng', 2, 'f', 't'),(3, '3 tháng', 3, 'f', 't'),(4, '6 tháng', 4, 'f', 't'),(5, '1 năm', 5, 'f', 't'),(6, '2 năm', 6, 'f', 't'),(7, '3 năm', 7, 'f', 't'),(8, 'Không thời hạn', 8, 'f', 't')
;
COMMIT;
BEGIN;
LOCK TABLE "public"."contract_type" IN SHARE MODE;
DELETE FROM "public"."contract_type";
INSERT INTO "public"."contract_type" ("contracttypeid","contracttypename","position","is_favorite","is_system") VALUES (1, 'Thử việc', 1, 'f', 't'),(2, 'Hợp đồng xác định thời hạn', 2, 'f', 't'),(3, 'Hợp đồng không xác định thời hạn', 3, 'f', 't'),(4, 'Học việc', 4, 'f', 't'),(5, 'Hợp đồng mùa vụ', 5, 'f', 't'),(6, 'Hợp đồng dịch vụ', 6, 'f', 't'),(7, 'Hợp đồng thực tập', 7, 'f', 't')
;
COMMIT;
BEGIN;
LOCK TABLE "public"."contract_worktype" IN SHARE MODE;
DELETE FROM "public"."contract_worktype";
INSERT INTO "public"."contract_worktype" ("contractworktypeid","contractworktypename","position","is_favorite","is_system") VALUES (1, 'Toàn thời gian', 1, 'f', 't'),(2, 'Bán thời gian', 2, 'f', 't'),(3, 'Cộng tác viên', 3, 'f', 't')
;
COMMIT;
BEGIN;
LOCK TABLE "public"."contracts" IN SHARE MODE;
DELETE FROM "public"."contracts";
COMMIT;
BEGIN;
LOCK TABLE "public"."designations" IN SHARE MODE;
DELETE FROM "public"."designations";
INSERT INTO "public"."designations" ("designateid","employeeid","unitid","designateunitid","effectivedate","designatenumber","jobtitleid","designatestatusid") VALUES ('bbdf4e33-ec9d-448b-afd1-52a2ea3ca010', '199aadbe-bf86-4b7c-93bb-e58e02ad4fa3', '3fa85f64-5717-4562-b3fc-2c963f66afa6', '2906a529-d86d-490d-a95e-d15d1535401c', '2024-05-02', '32165', 2, 1),('27ca80e4-4976-4469-8816-cde9c2a668fd', '9a3a726f-e166-48b6-8477-ccacdbd7e56a', NULL, 'c7b81e8c-4fbd-4f86-bc8b-028da53c5b72', '2024-05-02', '465', 1, 0),('366cd758-1162-4713-aaca-62f74320e8c5', '199aadbe-bf86-4b7c-93bb-e58e02ad4fa3', '3fa85f64-5717-4562-b3fc-2c963f66afa6', 'c7b81e8c-4fbd-4f86-bc8b-028da53c5b72', '2024-05-02', 'đâs13', 2, 0),('2f5d682a-2204-4931-9162-f809dec4bb18', '9a3a726f-e166-48b6-8477-ccacdbd7e56a', NULL, 'c7b81e8c-4fbd-4f86-bc8b-028da53c5b72', '2024-05-02', '945464', 2, 0),('b329b622-be9b-45a0-bc08-47bedc0dd28e', '199aadbe-bf86-4b7c-93bb-e58e02ad4fa3', NULL, 'c7b81e8c-4fbd-4f86-bc8b-028da53c5b72', '2024-05-01', '132465', 6, 0)
;
COMMIT;
BEGIN;
LOCK TABLE "public"."dismissions" IN SHARE MODE;
DELETE FROM "public"."dismissions";
INSERT INTO "public"."dismissions" ("dismissionid","employeeid","unitid","dismissionunitid","effectivedate","dismissionnumber","jobtitleid","dismissionstatusid") VALUES ('83159fb9-d532-495b-865f-a1de6a1f97ab', '199aadbe-bf86-4b7c-93bb-e58e02ad4fa3', '3fa85f64-5717-4562-b3fc-2c963f66afa6', '2906a529-d86d-490d-a95e-d15d1535401c', '2024-05-03', '132465', 2, 1)
;
COMMIT;
BEGIN;
LOCK TABLE "public"."displacements" IN SHARE MODE;
DELETE FROM "public"."displacements";
INSERT INTO "public"."displacements" ("displacementid","employeeid","unitid","displacementunitid","effectivedate","displacementnumber","jobtitleid","displacementstatusid") VALUES ('1a1bc630-0fab-4b86-8211-ebe1f9ed395c', '199aadbe-bf86-4b7c-93bb-e58e02ad4fa3', '3fa85f64-5717-4562-b3fc-2c963f66afa6', '2906a529-d86d-490d-a95e-d15d1535401c', '2024-05-02', '132465', 2, 0),('e38e1568-e01f-41a3-969c-11790aa6c141', '9a3a726f-e166-48b6-8477-ccacdbd7e56a', NULL, 'c7b81e8c-4fbd-4f86-bc8b-028da53c5b72', '2024-05-02', '132165', 3, 1)
;
COMMIT;
BEGIN;
LOCK TABLE "public"."employees" IN SHARE MODE;
DELETE FROM "public"."employees";
INSERT INTO "public"."employees" ("employeeid","employeecode","firstname","lastname","fullname","genderid","gendername","birthday","personaltaxcode","maritalstatusid","maritalstatusname","familyclassbackgroundid","familyclassbackgroundname","ethnicid","ethnicname","nationalityid","nationalityname","personalclassbackgroundid","personalclassbackgroundname","religionid","religionname","birthplace","homeland","identifynumber","identifynumberissuedplaceid","identifynumberissuedplace","identifynumberissueddate","identifynumberexpireddate","passportnumber","passportissueddate","passportissuedplaceid","passportissuedplacename","passporteffectfromdate","passporteffecttodate","educationlevel","educationplaceid","educationplacename","educationmajorid","educationmajorname","educationfacultyid","educationfacultyname","levelid","levelname","educationdegreeid","educationdegreename","awardedyear","hometel","officetel","mobile","othermobile","email","officeemail","otheremail","facebookid","skypeid","msnid","nativecountryid","nativecountryname","nativeprovinceid","nativeprovincename","nativedistrictid","nativedistrictname","nativewardid","nativewardname","nativestreethousenumber","nativeaddress","isheadhousehold","registrationbooknumber","registrationbookcode","samenativeaddress","currentcountryid","currentcountryname","currentprovinceid","currentprovincename","currentdistrictid","currentdistrictname","currentwardid","currentwardname","currentstreethousenumber","currentaddress","employeecodets","organizationunitid","organizationunitname","jobcode","jobpositionname","jobtitleid","jobtitlename","jobtitleconvertid","joblevelid","joblevelname","employeegradeid","employeegradename","employeestatusid","employeestatusname","inactive","workingplace","laborbooknumber","contracttypeid","contracttypename","shiftcode","probationdate","hiredate","receivedate","reporttoid","reporttoname","supervisorid","supervisorname","numberofleaveday","autoincrementseniority","terminationdate","terminationapproverid","terminationapprover","terminationreasonid","terminationreasonname","terminationreasontypeid","terminationreasontypename","terminationfeedback","salarybasic","salarysocialinsurance","bankaccountno","bankid","bankname","bankbranchid","bankbranchname","istradeunion","isinsurance","istemplate","socialinsurancesupplementingdate","insurancerate","socialinsurancenumber","socialinsurancecode","identifynumberissuedprovinceid","identifynumberissuedprovincename","identifynumberissuedprovincecode","healthinsurancenumber","healthinsuranceissueplace","healthinsuranceexpireddate","healthcareid","healthcarename","username","statusname","contactname","relationshipid","relationshipname","contactmobile","contacttel","contactemail","contactaddress","vocativeob","vocativeac","employeenatureid","employeenaturename","convertid","exportnewsfeed","kindofpaperid","kindofpapername","salarygradeid","salarygradename","proceduretypeid","proceduretypename","participateinsuranceid","participateinsurancename","totalincome","expectedretirementdate","isblacklist","isdeleted","userid","avatarid","statusid","tenantid","createdate","modifieddate","userupdate","active") VALUES ('e2993b5a-8978-4463-a202-78238af62d34', 'xx001', 'A', 'Nguyen Van', 'Nguyen Van A', NULL, NULL, '2024-05-03', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '', '', '', NULL, NULL, '2024-05-03', '2024-05-03', '', '2024-05-03', NULL, NULL, NULL, '2024-05-03', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '', '', '', '', '', '', '', '', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '', '', 'f', '', '', 'f', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '', '', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '', '', NULL, NULL, NULL, '2024-05-03', '2024-05-03', '2024-05-03', NULL, NULL, NULL, NULL, NULL, NULL, '2024-05-03', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '', NULL, NULL, NULL, NULL, 'f', 'f', NULL, '2024-05-03', NULL, '', '', NULL, NULL, '', '', '', NULL, NULL, NULL, NULL, NULL, '', NULL, NULL, '', '', '', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '', NULL, NULL, NULL, NULL, NULL, '2024-05-03', 'f', NULL, NULL, NULL, NULL, NULL, '2024-05-03 16:16:14.505', NULL, NULL, 't')
;
COMMIT;
BEGIN;
LOCK TABLE "public"."job_group" IN SHARE MODE;
DELETE FROM "public"."job_group";
INSERT INTO "public"."job_group" ("jobgroupid","jobgroupname","position","is_favorite","is_system") VALUES (1, 'Marketing', 1, 't', 't'),(2, 'Hành chính', 2, 't', 't'),(3, 'Nhân sự', 3, 't', 't'),(4, 'Kế toán', 4, 't', 't'),(5, 'Kinh doanh', 5, 't', 't'),(6, 'Kỹ thuật', 6, 't', 't'),(7, 'Công nhân', 7, 't', 't'),(8, 'Quản lý', 8, 't', 't'),(9, 'Lãnh đạo', 9, 't', 't')
;
COMMIT;
BEGIN;
LOCK TABLE "public"."job_level" IN SHARE MODE;
DELETE FROM "public"."job_level";
INSERT INTO "public"."job_level" ("joblevelid","joblevelname","position","is_favorite","is_system") VALUES (1, 'Nhân viên', 1, 't', 't'),(2, 'Quản lý', 2, 't', 't')
;
COMMIT;
BEGIN;
LOCK TABLE "public"."job_position" IN SHARE MODE;
DELETE FROM "public"."job_position";
INSERT INTO "public"."job_position" ("jobcode","jobname","jobgroup","joblevel","jobtitle","unitid","unitname","socialinsurancesalary","status") VALUES ('job2', 'Job 2', '2', '1', '2', '2906a529-d86d-490d-a95e-d15d1535401c', 'Công ty con', 0.00, 1),('job1', 'Job 1', '2', '1', '8', 'c7b81e8c-4fbd-4f86-bc8b-028da53c5b72', 'Tên Công ty', 1000.00, 1),('111', '222', '2', '1', '1', 'c7b81e8c-4fbd-4f86-bc8b-028da53c5b72', 'Tên Công ty', 0.00, 1),('1231', '23123', '1', '2', '2', 'c7b81e8c-4fbd-4f86-bc8b-028da53c5b72', 'Tên Công ty', 232.00, 1),('11112312', '1233123', '1', '1', '1', 'c7b81e8c-4fbd-4f86-bc8b-028da53c5b72', 'Tên Công ty', 232.00, 1),('232312', '3123', '2', '1', '1', 'c7b81e8c-4fbd-4f86-bc8b-028da53c5b72', 'Tên Công ty', 0.00, 1)
;
COMMIT;
BEGIN;
LOCK TABLE "public"."job_title" IN SHARE MODE;
DELETE FROM "public"."job_title";
INSERT INTO "public"."job_title" ("jobtitleid","jobtitlename","position","is_favorite","is_system") VALUES (1, 'Nhân viên', 1, 't', 't'),(2, 'Quản lý', 2, 't', 't'),(3, 'Nhóm trưởng', 3, 't', 't'),(4, 'Phó phòng', 4, 't', 't'),(5, 'Trưởng phòng', 5, 't', 't'),(6, 'Phó giám đốc', 6, 't', 't'),(7, 'Giám đốc', 7, 't', 't'),(8, 'Phó tổng giám đốc', 8, 't', 't'),(9, 'Tổng giám đốc', 9, 't', 't'),(10, 'Chủ tịch HĐQT', 10, 't', 't'),(11, 'Thực tập sinh', 11, 't', 't')
;
COMMIT;
BEGIN;
LOCK TABLE "public"."termination_reason" IN SHARE MODE;
DELETE FROM "public"."termination_reason";
INSERT INTO "public"."termination_reason" ("terminationreasonid","terminationreasonname","position","is_favorite","is_system") VALUES (1, 'Có kế hoạch sinh con trong thời gian tới', 1, 'f', 't'),(2, 'Do chuyển chổ ở mới quá xa công ty', 2, 'f', 't'),(3, 'Do hoàn cảnh gia đình', 3, 'f', 't'),(4, 'Do vấn đề cá nhân', 4, 'f', 't'),(5, 'Đủ tuổi nghỉ hưu', 5, 'f', 't'),(6, 'Muốn thay đổi môi trường làm việc', 6, 'f', 't')
;
COMMIT;
BEGIN;
LOCK TABLE "public"."terminations" IN SHARE MODE;
DELETE FROM "public"."terminations";
INSERT INTO "public"."terminations" ("terminationid","employeeid","contractid","terminationreasonid","terminationdate","terminationapproverid","terminationfeedback","terminationnumber","terminationstatusid") VALUES ('388ffeb5-7a7e-4032-ae4b-3075eae4154b', '9a3a726f-e166-48b6-8477-ccacdbd7e56a', NULL, 1, '2024-05-02', NULL, '', '132', 1)
;
COMMIT;
BEGIN;
LOCK TABLE "public"."unit_level" IN SHARE MODE;
DELETE FROM "public"."unit_level";
INSERT INTO "public"."unit_level" ("unitlevelid","level","unitlevelname","position","is_favorite","is_system") VALUES (1, 1, 'Công ty con', 1, 't', 't'),(2, 1, 'Chi nhánh', 2, 't', 't'),(3, 1, 'Văn phòng đại diện', 3, 't', 't'),(4, 2, 'Văn phòng', 4, 't', 't'),(5, 2, 'Trung tâm', 5, 't', 't'),(6, 3, 'Phòng ban', 6, 't', 't'),(7, 3, 'Nhóm/Tổ/Đội', 7, 't', 't'),(8, 3, 'Phân xưởng', 8, 't', 't')
;
COMMIT;
BEGIN;
LOCK TABLE "public"."units" IN SHARE MODE;
DELETE FROM "public"."units";
INSERT INTO "public"."units" ("organizationid","parentunitid","unitid","unitcode","unitlevelid","registrationnumber","address","unitname","symbol","leaderids","responsibility","status") VALUES ('379614f2-03bd-4f71-81e6-43c8fea93849', NULL, 'c7b81e8c-4fbd-4f86-bc8b-028da53c5b72', 'CTY', NULL, '1', 'Công ty dia chi', 'Tên Công ty', 'TVT Công ty', '9a3a726f-e166-48b6-8477-ccacdbd7e56a', 'Chuc nang 1', 1),('379614f2-03bd-4f71-81e6-43c8fea93849', 'c7b81e8c-4fbd-4f86-bc8b-028da53c5b72', '2906a529-d86d-490d-a95e-d15d1535401c', 'ctc', 1, '2', 'dia chi 2', 'Công ty con', 'tvt-ctc', '199aadbe-bf86-4b7c-93bb-e58e02ad4fa3', 'chuc nang 2', 0),('379614f2-03bd-4f71-81e6-43c8fea93849', '2906a529-d86d-490d-a95e-d15d1535401c', '9b895d7d-bc22-47aa-a0c9-c7f4f3f668c5', 'vp-1', 4, '111', 'Địa chỉ vp-1', 'Văn Phòng 1', 'vpppp-1', 'e2993b5a-8978-4463-a202-78238af62d34', 'Nv vp-1', 1),('379614f2-03bd-4f71-81e6-43c8fea93849', 'c7b81e8c-4fbd-4f86-bc8b-028da53c5b72', '199a8e37-634b-45f4-9331-3f7eb1ef02a4', 'cn-1', 2, '123123', 'Địa chỉ cn 1', 'Chi nhánh 1', 'chinhanh1', 'e2993b5a-8978-4463-a202-78238af62d34', 'Chức năng cn1', 1)
;
COMMIT;
ALTER TABLE "accomplishment_objectdetail" ADD CONSTRAINT "accomplishment_objectdetail_pkey" PRIMARY KEY ("accomplishmentobjectdetailid");
ALTER TABLE "accomplishments" ADD CONSTRAINT "accomplishments_pkey" PRIMARY KEY ("accomplishmentid");
ALTER TABLE "contract_status" ADD CONSTRAINT "job_level_copy1_pkey2" PRIMARY KEY ("contractstatusid");
ALTER TABLE "contract_time" ADD CONSTRAINT "job_level_copy1_pkey1" PRIMARY KEY ("contracttimeid");
ALTER TABLE "contract_type" ADD CONSTRAINT "contract_status_copy1_pkey" PRIMARY KEY ("contracttypeid");
ALTER TABLE "contract_worktype" ADD CONSTRAINT "contract_type_copy1_pkey" PRIMARY KEY ("contractworktypeid");
ALTER TABLE "contracts" ADD CONSTRAINT "contracts_pkey" PRIMARY KEY ("contractid");
ALTER TABLE "designations" ADD CONSTRAINT "designations_pkey" PRIMARY KEY ("designateid");
ALTER TABLE "dismissions" ADD CONSTRAINT "designations_copy1_pkey" PRIMARY KEY ("dismissionid");
ALTER TABLE "displacements" ADD CONSTRAINT "dismissions_copy1_pkey" PRIMARY KEY ("displacementid");
ALTER TABLE "employees" ADD CONSTRAINT "employees_pkey" PRIMARY KEY ("employeeid");
ALTER TABLE "job_group" ADD CONSTRAINT "job_group_pkey" PRIMARY KEY ("jobgroupid");
ALTER TABLE "job_level" ADD CONSTRAINT "job_group_copy1_pkey" PRIMARY KEY ("joblevelid");
ALTER TABLE "job_title" ADD CONSTRAINT "job_level_copy1_pkey" PRIMARY KEY ("jobtitleid");
ALTER TABLE "termination_reason" ADD CONSTRAINT "termination_reason_pkey" PRIMARY KEY ("terminationreasonid");
ALTER TABLE "terminations" ADD CONSTRAINT "terminations_pkey" PRIMARY KEY ("terminationid");
ALTER TABLE "unit_level" ADD CONSTRAINT "unit_level_pkey" PRIMARY KEY ("unitlevelid");
ALTER TABLE "units" ADD CONSTRAINT "units_pkey" PRIMARY KEY ("unitid");
