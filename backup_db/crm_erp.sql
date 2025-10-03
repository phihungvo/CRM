/*
PostgreSQL Backup
Database: erp/public
Backup Time: 2024-12-13 16:25:00
*/

DROP TABLE IF EXISTS "public"."authorities";
DROP TABLE IF EXISTS "public"."emails";
DROP TABLE IF EXISTS "public"."groups";
DROP TABLE IF EXISTS "public"."groups_roles";
DROP TABLE IF EXISTS "public"."modules";
DROP TABLE IF EXISTS "public"."organizations";
DROP TABLE IF EXISTS "public"."pages";
DROP TABLE IF EXISTS "public"."qrtz_blob_triggers";
DROP TABLE IF EXISTS "public"."qrtz_calendars";
DROP TABLE IF EXISTS "public"."qrtz_cron_triggers";
DROP TABLE IF EXISTS "public"."qrtz_fired_triggers";
DROP TABLE IF EXISTS "public"."qrtz_job_details";
DROP TABLE IF EXISTS "public"."qrtz_locks";
DROP TABLE IF EXISTS "public"."qrtz_paused_trigger_grps";
DROP TABLE IF EXISTS "public"."qrtz_scheduler_state";
DROP TABLE IF EXISTS "public"."qrtz_simple_triggers";
DROP TABLE IF EXISTS "public"."qrtz_simprop_triggers";
DROP TABLE IF EXISTS "public"."qrtz_triggers";
DROP TABLE IF EXISTS "public"."resetpasswordtoken";
DROP TABLE IF EXISTS "public"."roles";
DROP TABLE IF EXISTS "public"."roles_modules";
DROP TABLE IF EXISTS "public"."tokens";
DROP TABLE IF EXISTS "public"."user_groups";
DROP TABLE IF EXISTS "public"."users";
DROP TABLE IF EXISTS "public"."users_authorities";
DROP TABLE IF EXISTS "public"."users_orgs";
DROP TABLE IF EXISTS "public"."users_roles";
CREATE TABLE "authorities" (
  "authorityid" uuid NOT NULL,
  "name" varchar(75) COLLATE "pg_catalog"."default"
)
;
ALTER TABLE "authorities" OWNER TO "postgres";
CREATE TABLE "emails" (
  "id" int8 NOT NULL,
  "username" varchar(255) COLLATE "pg_catalog"."default",
  "toemail" varchar(255) COLLATE "pg_catalog"."default",
  "subject" varchar(255) COLLATE "pg_catalog"."default",
  "message" varchar(255) COLLATE "pg_catalog"."default",
  "scheduledtime" date,
  "zoneid" varchar COLLATE "pg_catalog"."default",
  "status" int4,
  "sentdate" date,
  "errordescription" varchar(255) COLLATE "pg_catalog"."default"
)
;
ALTER TABLE "emails" OWNER TO "postgres";
CREATE TABLE "groups" (
  "groupid" uuid NOT NULL,
  "organizationid" uuid NOT NULL,
  "parentgroupid" uuid,
  "name" varchar(100) COLLATE "pg_catalog"."default",
  "createdate" timestamp(6),
  "modifieddate" timestamp(6),
  "active" bool
)
;
ALTER TABLE "groups" OWNER TO "postgres";
CREATE TABLE "groups_roles" (
  "groupid" uuid NOT NULL,
  "roleid" uuid NOT NULL
)
;
ALTER TABLE "groups_roles" OWNER TO "postgres";
CREATE TABLE "modules" (
  "moduleid" uuid NOT NULL,
  "modulename" varchar(255) COLLATE "pg_catalog"."default",
  "description" varchar(255) COLLATE "pg_catalog"."default",
  "order_" int4,
  "type" int4,
  "active" bool
)
;
ALTER TABLE "modules" OWNER TO "postgres";
CREATE TABLE "organizations" (
  "organizationid" uuid NOT NULL,
  "parentorganizationid" uuid,
  "name" varchar(100) COLLATE "pg_catalog"."default",
  "createdate" timestamp(6),
  "modifieddate" timestamp(6),
  "active" bool
)
;
ALTER TABLE "organizations" OWNER TO "postgres";
CREATE TABLE "pages" (
  "pageid" uuid NOT NULL,
  "moduleid" uuid NOT NULL,
  "parentpageid" uuid,
  "pagename" varchar(255) COLLATE "pg_catalog"."default",
  "href" varchar(255) COLLATE "pg_catalog"."default",
  "icon" varchar(255) COLLATE "pg_catalog"."default",
  "description" varchar(255) COLLATE "pg_catalog"."default",
  "istitle " bool,
  "order_" int4,
  "active" bool
)
;
ALTER TABLE "pages" OWNER TO "postgres";
CREATE TABLE "qrtz_blob_triggers" (
  "sched_name" varchar(120) COLLATE "pg_catalog"."default" NOT NULL,
  "trigger_name" varchar(200) COLLATE "pg_catalog"."default" NOT NULL,
  "trigger_group" varchar(200) COLLATE "pg_catalog"."default" NOT NULL,
  "blob_data" bytea
)
;
ALTER TABLE "qrtz_blob_triggers" OWNER TO "postgres";
CREATE TABLE "qrtz_calendars" (
  "sched_name" varchar(120) COLLATE "pg_catalog"."default" NOT NULL,
  "calendar_name" varchar(200) COLLATE "pg_catalog"."default" NOT NULL,
  "calendar" bytea NOT NULL
)
;
ALTER TABLE "qrtz_calendars" OWNER TO "postgres";
CREATE TABLE "qrtz_cron_triggers" (
  "sched_name" varchar(120) COLLATE "pg_catalog"."default" NOT NULL,
  "trigger_name" varchar(200) COLLATE "pg_catalog"."default" NOT NULL,
  "trigger_group" varchar(200) COLLATE "pg_catalog"."default" NOT NULL,
  "cron_expression" varchar(120) COLLATE "pg_catalog"."default" NOT NULL,
  "time_zone_id" varchar(80) COLLATE "pg_catalog"."default"
)
;
ALTER TABLE "qrtz_cron_triggers" OWNER TO "postgres";
CREATE TABLE "qrtz_fired_triggers" (
  "sched_name" varchar(120) COLLATE "pg_catalog"."default" NOT NULL,
  "entry_id" varchar(95) COLLATE "pg_catalog"."default" NOT NULL,
  "trigger_name" varchar(200) COLLATE "pg_catalog"."default" NOT NULL,
  "trigger_group" varchar(200) COLLATE "pg_catalog"."default" NOT NULL,
  "instance_name" varchar(200) COLLATE "pg_catalog"."default" NOT NULL,
  "fired_time" int8 NOT NULL,
  "sched_time" int8 NOT NULL,
  "priority" int4 NOT NULL,
  "state" varchar(16) COLLATE "pg_catalog"."default" NOT NULL,
  "job_name" varchar(200) COLLATE "pg_catalog"."default",
  "job_group" varchar(200) COLLATE "pg_catalog"."default",
  "is_nonconcurrent" bool,
  "requests_recovery" bool
)
;
ALTER TABLE "qrtz_fired_triggers" OWNER TO "postgres";
CREATE TABLE "qrtz_job_details" (
  "sched_name" varchar(120) COLLATE "pg_catalog"."default" NOT NULL,
  "job_name" varchar(200) COLLATE "pg_catalog"."default" NOT NULL,
  "job_group" varchar(200) COLLATE "pg_catalog"."default" NOT NULL,
  "description" varchar(250) COLLATE "pg_catalog"."default",
  "job_class_name" varchar(250) COLLATE "pg_catalog"."default" NOT NULL,
  "is_durable" bool NOT NULL,
  "is_nonconcurrent" bool NOT NULL,
  "is_update_data" bool NOT NULL,
  "requests_recovery" bool NOT NULL,
  "job_data" bytea
)
;
ALTER TABLE "qrtz_job_details" OWNER TO "postgres";
CREATE TABLE "qrtz_locks" (
  "sched_name" varchar(120) COLLATE "pg_catalog"."default" NOT NULL,
  "lock_name" varchar(40) COLLATE "pg_catalog"."default" NOT NULL
)
;
ALTER TABLE "qrtz_locks" OWNER TO "postgres";
CREATE TABLE "qrtz_paused_trigger_grps" (
  "sched_name" varchar(120) COLLATE "pg_catalog"."default" NOT NULL,
  "trigger_group" varchar(200) COLLATE "pg_catalog"."default" NOT NULL
)
;
ALTER TABLE "qrtz_paused_trigger_grps" OWNER TO "postgres";
CREATE TABLE "qrtz_scheduler_state" (
  "sched_name" varchar(120) COLLATE "pg_catalog"."default" NOT NULL,
  "instance_name" varchar(200) COLLATE "pg_catalog"."default" NOT NULL,
  "last_checkin_time" int8 NOT NULL,
  "checkin_interval" int8 NOT NULL
)
;
ALTER TABLE "qrtz_scheduler_state" OWNER TO "postgres";
CREATE TABLE "qrtz_simple_triggers" (
  "sched_name" varchar(120) COLLATE "pg_catalog"."default" NOT NULL,
  "trigger_name" varchar(200) COLLATE "pg_catalog"."default" NOT NULL,
  "trigger_group" varchar(200) COLLATE "pg_catalog"."default" NOT NULL,
  "repeat_count" int8 NOT NULL,
  "repeat_interval" int8 NOT NULL,
  "times_triggered" int8 NOT NULL
)
;
ALTER TABLE "qrtz_simple_triggers" OWNER TO "postgres";
CREATE TABLE "qrtz_simprop_triggers" (
  "sched_name" varchar(120) COLLATE "pg_catalog"."default" NOT NULL,
  "trigger_name" varchar(200) COLLATE "pg_catalog"."default" NOT NULL,
  "trigger_group" varchar(200) COLLATE "pg_catalog"."default" NOT NULL,
  "str_prop_1" varchar(512) COLLATE "pg_catalog"."default",
  "str_prop_2" varchar(512) COLLATE "pg_catalog"."default",
  "str_prop_3" varchar(512) COLLATE "pg_catalog"."default",
  "int_prop_1" int4,
  "int_prop_2" int4,
  "long_prop_1" int8,
  "long_prop_2" int8,
  "dec_prop_1" numeric(13,4),
  "dec_prop_2" numeric(13,4),
  "bool_prop_1" bool,
  "bool_prop_2" bool
)
;
ALTER TABLE "qrtz_simprop_triggers" OWNER TO "postgres";
CREATE TABLE "qrtz_triggers" (
  "sched_name" varchar(120) COLLATE "pg_catalog"."default" NOT NULL,
  "trigger_name" varchar(200) COLLATE "pg_catalog"."default" NOT NULL,
  "trigger_group" varchar(200) COLLATE "pg_catalog"."default" NOT NULL,
  "job_name" varchar(200) COLLATE "pg_catalog"."default" NOT NULL,
  "job_group" varchar(200) COLLATE "pg_catalog"."default" NOT NULL,
  "description" varchar(250) COLLATE "pg_catalog"."default",
  "next_fire_time" int8,
  "prev_fire_time" int8,
  "priority" int4,
  "trigger_state" varchar(16) COLLATE "pg_catalog"."default" NOT NULL,
  "trigger_type" varchar(8) COLLATE "pg_catalog"."default" NOT NULL,
  "start_time" int8 NOT NULL,
  "end_time" int8,
  "calendar_name" varchar(200) COLLATE "pg_catalog"."default",
  "misfire_instr" int2,
  "job_data" bytea
)
;
ALTER TABLE "qrtz_triggers" OWNER TO "postgres";
CREATE TABLE "resetpasswordtoken" (
  "userid" uuid NOT NULL,
  "token" varchar(75) COLLATE "pg_catalog"."default" NOT NULL,
  "expirydate" timestamp(6)
)
;
ALTER TABLE "resetpasswordtoken" OWNER TO "postgres";
CREATE TABLE "roles" (
  "roleid" uuid NOT NULL,
  "organizationid" uuid,
  "rolename" varchar(75) COLLATE "pg_catalog"."default",
  "createdate" timestamp(6),
  "modifieddate" timestamp(6),
  "description" text COLLATE "pg_catalog"."default",
  "type_" int4,
  "subtype" varchar(75) COLLATE "pg_catalog"."default",
  "active" bool
)
;
ALTER TABLE "roles" OWNER TO "postgres";
CREATE TABLE "roles_modules" (
  "roleid" uuid NOT NULL,
  "moduleid" uuid NOT NULL
)
;
ALTER TABLE "roles_modules" OWNER TO "postgres";
CREATE TABLE "tokens" (
  "tokenid" uuid NOT NULL,
  "userid" uuid NOT NULL,
  "token" varchar(255) COLLATE "pg_catalog"."default",
  "revoked" bool,
  "expired" bool
)
;
ALTER TABLE "tokens" OWNER TO "postgres";
CREATE TABLE "user_groups" (
  "userid" uuid NOT NULL,
  "groupid" uuid NOT NULL
)
;
ALTER TABLE "user_groups" OWNER TO "postgres";
CREATE TABLE "users" (
  "userid" uuid NOT NULL,
  "organizationid" uuid,
  "username" varchar(75) COLLATE "pg_catalog"."default" NOT NULL,
  "fullname" varchar(75) COLLATE "pg_catalog"."default",
  "password" varchar(75) COLLATE "pg_catalog"."default",
  "emailaddress" varchar(254) COLLATE "pg_catalog"."default",
  "jobtitle" varchar(100) COLLATE "pg_catalog"."default",
  "gender" int4,
  "phone" varchar(75) COLLATE "pg_catalog"."default",
  "createdate" timestamp(6),
  "modifieddate" timestamp(6),
  "passwordencrypted" bool,
  "passwordreset" bool,
  "passwordmodifieddate" timestamp(6),
  "gracelogincount" int4,
  "languageid" varchar(75) COLLATE "pg_catalog"."default",
  "timezoneid" varchar(75) COLLATE "pg_catalog"."default",
  "logindate" timestamp(6),
  "loginip" varchar(75) COLLATE "pg_catalog"."default",
  "lastlogindate" timestamp(6),
  "lastloginip" varchar(75) COLLATE "pg_catalog"."default",
  "lastfailedlogindate" timestamp(6),
  "failedloginattempts" int4,
  "lockout" bool,
  "lockoutdate" timestamp(6),
  "type_" int4,
  "status" int4
)
;
ALTER TABLE "users" OWNER TO "postgres";
CREATE TABLE "users_authorities" (
  "userid" uuid NOT NULL,
  "authorityid" uuid NOT NULL
)
;
ALTER TABLE "users_authorities" OWNER TO "postgres";
CREATE TABLE "users_orgs" (
  "organizationid" uuid NOT NULL,
  "userid" uuid NOT NULL
)
;
ALTER TABLE "users_orgs" OWNER TO "postgres";
CREATE TABLE "users_roles" (
  "userid" uuid NOT NULL,
  "roleid" uuid NOT NULL
)
;
ALTER TABLE "users_roles" OWNER TO "postgres";
BEGIN;
LOCK TABLE "public"."authorities" IN SHARE MODE;
DELETE FROM "public"."authorities";
INSERT INTO "public"."authorities" ("authorityid","name") VALUES ('43ca07f8-f68b-4e13-a66c-2174a5555070', 'SUPER_ADMIN'),('52aefa62-aac1-48b8-a079-7c38f292ba98', 'ADMIN'),('097cb7e6-45dc-4053-b2ce-88d5986a5931', 'USER')
;
COMMIT;
BEGIN;
LOCK TABLE "public"."emails" IN SHARE MODE;
DELETE FROM "public"."emails";
COMMIT;
BEGIN;
LOCK TABLE "public"."groups" IN SHARE MODE;
DELETE FROM "public"."groups";
INSERT INTO "public"."groups" ("groupid","organizationid","parentgroupid","name","createdate","modifieddate","active") VALUES ('80fe7af2-6ed4-4aa0-8fd9-8988eab9db60', '05d5a39c-cfe1-4ed1-93c0-f2ffdf426a98', NULL, 'group 1 - org 1', '2024-01-19 09:59:09.792', '2024-01-19 09:59:09.792', NULL),('b194ed65-e1ac-4fa4-8231-6ca3c314886e', '05d5a39c-cfe1-4ed1-93c0-f2ffdf426a98', NULL, 'group 2 - org 1', '2024-01-19 09:59:28.538', '2024-01-19 09:59:28.538', NULL),('51ef9d27-93d9-4185-84f3-fa44235bfb8a', '9f67285b-a327-4ff3-bd8f-edbc84b5d806', NULL, 'group 1 - org 2', '2024-01-19 10:00:00.96', '2024-01-19 10:00:00.96', NULL),('a88b7b6d-c05d-424e-aeb9-e2e48b767096', '9f67285b-a327-4ff3-bd8f-edbc84b5d806', NULL, 'group 2 - org 2', '2024-01-19 10:00:11.831', '2024-01-19 10:00:11.831', NULL)
;
COMMIT;
BEGIN;
LOCK TABLE "public"."groups_roles" IN SHARE MODE;
DELETE FROM "public"."groups_roles";
INSERT INTO "public"."groups_roles" ("groupid","roleid") VALUES ('80fe7af2-6ed4-4aa0-8fd9-8988eab9db60', '6d60fb52-6e34-44b4-9832-4bee1bdb7860')
;
COMMIT;
BEGIN;
LOCK TABLE "public"."modules" IN SHARE MODE;
DELETE FROM "public"."modules";
INSERT INTO "public"."modules" ("moduleid","modulename","description","order_","type","active") VALUES ('77ff7528-fc80-489d-adf7-188b9919c157', 'Default', 'Default', 0, 3, 't'),('5a9591bf-e6aa-4700-9054-df630a9692a8', 'Applications', 'Applications', 1, 3, 't'),('1bbf917b-db0e-4063-8cac-8429b98e62be', 'Inventory', 'Inventory', 2, 2, 't'),('52025257-8893-4dac-9949-85abd2e1ef8f', 'Purchase', 'Purchase', 3, 2, 't'),('5998bc8d-6412-420d-89a7-b6b66df35b75', 'Admin', 'Admin', 98, 1, 't'),('016e6709-0119-4ee8-8eb8-5dae7008c209', 'SuperAdmin', 'SuperAdmin', 99, 0, 't')
;
COMMIT;
BEGIN;
LOCK TABLE "public"."organizations" IN SHARE MODE;
DELETE FROM "public"."organizations";
INSERT INTO "public"."organizations" ("organizationid","parentorganizationid","name","createdate","modifieddate","active") VALUES ('05d5a39c-cfe1-4ed1-93c0-f2ffdf426a98', NULL, 'org 1', '2024-01-19 09:57:55.312', '2024-01-21 15:09:27.207', NULL),('9f67285b-a327-4ff3-bd8f-edbc84b5d806', NULL, 'org 2', '2024-01-19 09:58:02.768', '2024-01-22 12:25:42.902', NULL)
;
COMMIT;
BEGIN;
LOCK TABLE "public"."pages" IN SHARE MODE;
DELETE FROM "public"."pages";
INSERT INTO "public"."pages" ("pageid","moduleid","parentpageid","pagename","href","icon","description","istitle ","order_","active") VALUES ('281b26b1-8144-4e84-80aa-4870ed3e0cdb', '77ff7528-fc80-489d-adf7-188b9919c157', NULL, 'Home', '/', 'ri-home-line', 'Home', 't', 0, 't'),('b77620f5-96ec-4f1f-8f51-e49f2bf3312b', '77ff7528-fc80-489d-adf7-188b9919c157', NULL, 'Dashboard', '', 'ri-dashboard-line', 'Dashboard', 'f', 1, 't'),('c366afdd-1f60-4dbe-826d-9507c461a89c', '77ff7528-fc80-489d-adf7-188b9919c157', 'b77620f5-96ec-4f1f-8f51-e49f2bf3312b', 'Sales Dashboard', '/dashboard/sales', '', 'Sales Dashboard', 'f', 0, 't'),('f2ffeaa9-0e2f-44e2-9b54-bb77bd95b5cd', '5a9591bf-e6aa-4700-9054-df630a9692a8', NULL, 'Applications', '', 'ri-apps-line', 'Applications', 't', 2, 't'),('70700bfc-85fe-442a-8268-2b0de9caf992', '1bbf917b-db0e-4063-8cac-8429b98e62be', 'f2ffeaa9-0e2f-44e2-9b54-bb77bd95b5cd', 'Inventory', '/apps/inventory', '', 'Inventory', 'f', 0, 't'),('c99e9f5d-c23d-465a-8685-c2c15d409cb1', '1bbf917b-db0e-4063-8cac-8429b98e62be', '70700bfc-85fe-442a-8268-2b0de9caf992', 'Overview', '/apps/inventory/overview', '', 'Overview', 'f', 0, 't'),('ff026931-e10a-4878-82aa-d6731abb5ee4', '1bbf917b-db0e-4063-8cac-8429b98e62be', '70700bfc-85fe-442a-8268-2b0de9caf992', 'Purchase', '/apps/inventory/purchases', '', 'Purchase', 'f', 1, 't'),('5937381d-0bf4-4586-8586-bebb196ef7e5', '1bbf917b-db0e-4063-8cac-8429b98e62be', 'ff026931-e10a-4878-82aa-d6731abb5ee4', 'All Purchases', '/apps/inventory/purchases', '', 'All Purchases', 'f', 0, 't'),('085c7b6d-7a0d-43fe-82be-7ca0f465429a', '1bbf917b-db0e-4063-8cac-8429b98e62be', 'ff026931-e10a-4878-82aa-d6731abb5ee4', 'Create Purchase', '/apps/inventory/purchases/add', '', 'Create Purchase', 'f', 1, 't'),('3e48b167-2599-4d9f-9151-4af0c481f2c4', '1bbf917b-db0e-4063-8cac-8429b98e62be', '70700bfc-85fe-442a-8268-2b0de9caf992', 'Sales', '/apps/inventory/sales', '', 'Sales', 'f', 2, 't'),('0ba53369-6ff2-464b-b936-653371460bf4', '1bbf917b-db0e-4063-8cac-8429b98e62be', '3e48b167-2599-4d9f-9151-4af0c481f2c4', 'All Sales', '/apps/inventory/sales', '', 'All Sales', 'f', 0, 't'),('d1e7b24f-2b46-4922-a241-ff1f1516d03f', '1bbf917b-db0e-4063-8cac-8429b98e62be', '3e48b167-2599-4d9f-9151-4af0c481f2c4', 'Create Sale', '/apps/inventory/sales/add', '', 'Create Sale', 'f', 1, 't'),('fb474433-1628-44af-812c-91c10045a9ca', '1bbf917b-db0e-4063-8cac-8429b98e62be', '3e48b167-2599-4d9f-9151-4af0c481f2c4', 'Shipments', '/apps/inventory/sales/shipments', '', 'Shipments', 'f', 2, 't'),('a17f7847-df13-4262-8e0d-f7ccd0ec4d51', '1bbf917b-db0e-4063-8cac-8429b98e62be', '70700bfc-85fe-442a-8268-2b0de9caf992', 'Quotations', '/apps/inventory/quotations', '', 'Quotations', 'f', 3, 't'),('955d53cc-c1a4-4edf-bce4-6fbc91b5d5c5', '1bbf917b-db0e-4063-8cac-8429b98e62be', 'a17f7847-df13-4262-8e0d-f7ccd0ec4d51', 'All Quotations', '/apps/inventory/quotations', '', 'All Quotations', 'f', 0, 't'),('15ca8745-4165-48a1-9b9b-ce8a70e46736', '1bbf917b-db0e-4063-8cac-8429b98e62be', 'a17f7847-df13-4262-8e0d-f7ccd0ec4d51', 'Create Quotation', '/apps/inventory/quotations/add', '', 'Create Quotation', 'f', 1, 't'),('d55b1f6f-4534-43e0-99f7-824a0ca8afcf', '1bbf917b-db0e-4063-8cac-8429b98e62be', '70700bfc-85fe-442a-8268-2b0de9caf992', 'Adjustments', '/apps/inventory/adjustments', '', 'Adjustments', 'f', 4, 't'),('871eddbb-d21d-46a5-899c-0e0484a56a45', '1bbf917b-db0e-4063-8cac-8429b98e62be', 'd55b1f6f-4534-43e0-99f7-824a0ca8afcf', 'All Adjustments', '/apps/inventory/adjustments', '', 'All Adjustments', 'f', 0, 't'),('2861cb2f-166a-439e-bbbc-a7fb4a8bb62f', '1bbf917b-db0e-4063-8cac-8429b98e62be', 'd55b1f6f-4534-43e0-99f7-824a0ca8afcf', 'Create Adjustment', '/apps/inventory/adjustments/add', '', 'Create Adjustment', 'f', 1, 't'),('d5a68f60-71ce-4595-9bae-2cdb01f201d5', '1bbf917b-db0e-4063-8cac-8429b98e62be', '70700bfc-85fe-442a-8268-2b0de9caf992', 'Transfers', '/apps/inventory/transfers', '', 'Transfers', 'f', 5, 't'),('b5761d3c-d4af-468d-8f9e-d0a99d4ba158', '1bbf917b-db0e-4063-8cac-8429b98e62be', 'd5a68f60-71ce-4595-9bae-2cdb01f201d5', 'All Transfers', '/apps/inventory/transfers', '', 'All Transfers', 'f', 0, 't'),('c157de7b-3744-4ed6-b389-a5a6835b5f75', '1bbf917b-db0e-4063-8cac-8429b98e62be', 'd5a68f60-71ce-4595-9bae-2cdb01f201d5', 'Create Transfers', '/apps/inventory/transfers/add', '', 'Create Transfers', 'f', 1, 't'),('33c37a17-76cd-4de0-ba41-1243d05f09ac', '1bbf917b-db0e-4063-8cac-8429b98e62be', '70700bfc-85fe-442a-8268-2b0de9caf992', 'Purchases Return', '/apps/inventory/purchases/returns', '', 'Purchases Return', 'f', 6, 't'),('de40b7c5-fff9-46ab-9013-755925678737', '1bbf917b-db0e-4063-8cac-8429b98e62be', '70700bfc-85fe-442a-8268-2b0de9caf992', 'Sales Return', '/apps/inventory/sales/returns', '', 'Sales Return', 'f', 7, 't'),('7e17f0ca-30e2-4568-bf91-5638f5bfe29a', '1bbf917b-db0e-4063-8cac-8429b98e62be', '70700bfc-85fe-442a-8268-2b0de9caf992', 'Configuration', '/apps/inventory/configuration', '', 'Configuration', 'f', 8, 't'),('945b45b3-853c-489d-9dfd-31d6394bdf91', '1bbf917b-db0e-4063-8cac-8429b98e62be', '7e17f0ca-30e2-4568-bf91-5638f5bfe29a', 'Warehouses', '/apps/inventory/configuration/warehouses', '', 'Warehouses', 'f', 0, 't'),('901684e4-5b42-46f9-b7fc-6b829079b307', '1bbf917b-db0e-4063-8cac-8429b98e62be', '7e17f0ca-30e2-4568-bf91-5638f5bfe29a', 'Products', '/apps/inventory/configuration/products', '', 'Products', 'f', 1, 't'),('6e75cc3d-387f-405f-9ea0-53026c6408db', '1bbf917b-db0e-4063-8cac-8429b98e62be', '7e17f0ca-30e2-4568-bf91-5638f5bfe29a', 'Types', '/apps/inventory/configuration/products/types', '', 'Types', 'f', 2, 't'),('575ada1b-4708-4e03-831b-f53cabf74864', '1bbf917b-db0e-4063-8cac-8429b98e62be', '7e17f0ca-30e2-4568-bf91-5638f5bfe29a', 'Categories', '/apps/inventory/configuration/products/categories', '', 'Categories', 'f', 3, 't'),('66b0911d-dc31-4f63-b509-c61f3cbf60cf', '1bbf917b-db0e-4063-8cac-8429b98e62be', '7e17f0ca-30e2-4568-bf91-5638f5bfe29a', 'Brands', '/apps/inventory/configuration/products/brands', '', 'Brands', 'f', 4, 't'),('f8feb1db-9975-4d65-8197-2967992ed317', '1bbf917b-db0e-4063-8cac-8429b98e62be', '7e17f0ca-30e2-4568-bf91-5638f5bfe29a', 'Units of Measures', '/apps/inventory/configuration/products/units', '', 'Units of Measures', 'f', 5, 't'),('19f36f1b-9f2b-44ff-975b-031c7b0fb490', '1bbf917b-db0e-4063-8cac-8429b98e62be', '70700bfc-85fe-442a-8268-2b0de9caf992', 'Reporting', '', '', 'Reporting', 'f', 9, 't'),('a912ad6f-3d41-44a1-9cf4-2ebb7bcf2bfb', '1bbf917b-db0e-4063-8cac-8429b98e62be', '19f36f1b-9f2b-44ff-975b-031c7b0fb490', 'Payments', '/apps/inventory/reporting/payments', '', 'Payments', 'f', 0, 't'),('deff8d2a-3ebd-4897-a007-d992cb3f8412', '1bbf917b-db0e-4063-8cac-8429b98e62be', 'a912ad6f-3d41-44a1-9cf4-2ebb7bcf2bfb', 'Purchase', '/apps/inventory/reporting/payments/purchases', '', 'Purchase', 'f', 0, 't'),('6e066e64-49c2-40bf-9ac5-50c5ba630502', '1bbf917b-db0e-4063-8cac-8429b98e62be', 'a912ad6f-3d41-44a1-9cf4-2ebb7bcf2bfb', 'Sales', '/apps/inventory/reporting/payments/sales', '', 'Sales', 'f', 1, 't'),('de15a994-d339-4f57-b989-4aded9b8563c', '1bbf917b-db0e-4063-8cac-8429b98e62be', 'a912ad6f-3d41-44a1-9cf4-2ebb7bcf2bfb', 'Sales Return', '/apps/inventory/reporting/payments/salesreturn', '', 'Sales Return', 'f', 2, 't'),('f99b1c5a-1c51-4ffd-b60a-9fd5bbc6aff4', '1bbf917b-db0e-4063-8cac-8429b98e62be', 'a912ad6f-3d41-44a1-9cf4-2ebb7bcf2bfb', 'Purchase Return', '/apps/inventory/reporting/payments/purchasereturn', '', 'Purchase Return', 'f', 3, 't'),('92918e0a-0918-4359-b7e9-77759d0c129c', '1bbf917b-db0e-4063-8cac-8429b98e62be', '19f36f1b-9f2b-44ff-975b-031c7b0fb490', 'Profit and Lost', '/apps/inventory/reporting/profitandlost', '', 'Profit and Lost', 'f', 1, 't'),('23ecf1b8-334b-418b-870f-a400e60aada5', '1bbf917b-db0e-4063-8cac-8429b98e62be', '19f36f1b-9f2b-44ff-975b-031c7b0fb490', 'Warehouse', '/apps/inventory/reporting/warehouse', '', 'Warehouse', 'f', 2, 't'),('393028a4-32ca-4d9c-9a31-a523fd3cd213', '1bbf917b-db0e-4063-8cac-8429b98e62be', '19f36f1b-9f2b-44ff-975b-031c7b0fb490', 'Stock', '/apps/inventory/reporting/stock', '', 'Stock', 'f', 3, 't'),('ed11f923-f054-49fc-913c-ac81b9f1d3de', '1bbf917b-db0e-4063-8cac-8429b98e62be', '19f36f1b-9f2b-44ff-975b-031c7b0fb490', 'Product', '/apps/inventory/reporting/product', '', 'Product', 'f', 4, 't'),('b6b6df13-93b5-4f6a-875b-c8ab1abed855', '1bbf917b-db0e-4063-8cac-8429b98e62be', '19f36f1b-9f2b-44ff-975b-031c7b0fb490', 'Moves History', '/apps/inventory/reporting/moves-history', '', 'Moves History', 'f', 5, 't'),('afdea010-2490-489d-ba80-e486e92b4431', '1bbf917b-db0e-4063-8cac-8429b98e62be', '19f36f1b-9f2b-44ff-975b-031c7b0fb490', 'Stock Moves', '/apps/inventory/reporting/stock-move', '', 'Stock Moves', 'f', 6, 't'),('a0c2fe87-a984-422f-a68b-a42ca8763fbd', '1bbf917b-db0e-4063-8cac-8429b98e62be', '19f36f1b-9f2b-44ff-975b-031c7b0fb490', 'Locations', '/apps/inventory/reporting/locations', '', 'Locations', 'f', 7, 't'),('4a1c0376-7d1d-4b8b-8010-3e816586b705', '1bbf917b-db0e-4063-8cac-8429b98e62be', '19f36f1b-9f2b-44ff-975b-031c7b0fb490', 'Valuation', '/apps/inventory/reporting/valuation', '', 'Valuation', 'f', 8, 't'),('9ebd99ab-36d7-403f-a0e6-91485678dfca', '1bbf917b-db0e-4063-8cac-8429b98e62be', '70700bfc-85fe-442a-8268-2b0de9caf992', 'Customers', '/apps/customers', '', 'Customers', 'f', 10, 't'),('c2c2c972-c5e5-48fd-8b06-5474559d87cc', '1bbf917b-db0e-4063-8cac-8429b98e62be', '70700bfc-85fe-442a-8268-2b0de9caf992', 'Providers', '/apps/providers', '', 'Providers', 'f', 11, 't'),('d60a9ac9-44be-43ef-86b6-acc3d9eec7b2', '52025257-8893-4dac-9949-85abd2e1ef8f', 'f2ffeaa9-0e2f-44e2-9b54-bb77bd95b5cd', 'Purchase', '', '', 'Purchase', 'f', 1, 't'),('dbfafb8e-8d08-4a39-9571-e1d9a1df7ba6', '52025257-8893-4dac-9949-85abd2e1ef8f', 'd60a9ac9-44be-43ef-86b6-acc3d9eec7b2', 'Orders', '', '', 'Orders', 'f', 0, 't'),('dd7a5e3f-c28b-4876-bfcd-8b9b1f27a2bb', '52025257-8893-4dac-9949-85abd2e1ef8f', 'd60a9ac9-44be-43ef-86b6-acc3d9eec7b2', 'Configuration', '', '', 'Configuration', 'f', 1, 't'),('ce675c7d-155c-4298-96e5-6896e950fe96', '52025257-8893-4dac-9949-85abd2e1ef8f', 'dd7a5e3f-c28b-4876-bfcd-8b9b1f27a2bb', 'Vendor Pricelists', '', '', 'Vendor Pricelists', 'f', 0, 't'),('704c4f31-f699-4b75-bfcb-7d4078953714', '52025257-8893-4dac-9949-85abd2e1ef8f', 'dd7a5e3f-c28b-4876-bfcd-8b9b1f27a2bb', 'Products', '', '', 'Products', 'f', 1, 't'),('fe1c6de8-95fd-4286-a6ee-f56c42c13c70', '52025257-8893-4dac-9949-85abd2e1ef8f', 'dd7a5e3f-c28b-4876-bfcd-8b9b1f27a2bb', 'Units of Measures', '', '', 'Units of Measures', 'f', 2, 't'),('8b87e788-d417-4b6e-88a4-231fbbc47921', '52025257-8893-4dac-9949-85abd2e1ef8f', 'fe1c6de8-95fd-4286-a6ee-f56c42c13c70', 'Units of Measure', '', '', 'Units of Measure', 'f', 0, 't'),('d790728f-f598-4d5a-9a36-169bd66a2575', '52025257-8893-4dac-9949-85abd2e1ef8f', 'fe1c6de8-95fd-4286-a6ee-f56c42c13c70', 'Units of Measure Categories', '', '', 'Units of Measure Categories', 'f', 1, 't'),('792c7132-4da3-497b-b980-f2bd1964bc3d', '52025257-8893-4dac-9949-85abd2e1ef8f', 'd60a9ac9-44be-43ef-86b6-acc3d9eec7b2', 'Products', '', '', 'Products', 'f', 2, 't'),('422e9aac-8d17-4fca-96b5-1b17e8368640', '52025257-8893-4dac-9949-85abd2e1ef8f', '792c7132-4da3-497b-b980-f2bd1964bc3d', 'Products', '', '', 'Products', 'f', 0, 't'),('67ca1138-5f9c-426a-8c91-4de4f717300d', '52025257-8893-4dac-9949-85abd2e1ef8f', '792c7132-4da3-497b-b980-f2bd1964bc3d', 'Product Variants', '', '', 'Product Variants', 'f', 1, 't'),('fc0a4012-54e2-4920-a21a-257e27b14746', '52025257-8893-4dac-9949-85abd2e1ef8f', 'd60a9ac9-44be-43ef-86b6-acc3d9eec7b2', 'Reporting', '', '', 'Reporting', 'f', 3, 't'),('7c76c935-a3e2-4206-a6ec-e315288e5e53', '52025257-8893-4dac-9949-85abd2e1ef8f', 'fc0a4012-54e2-4920-a21a-257e27b14746', 'Purchase', '', '', 'Purchase', 'f', 0, 't'),('d6fd4f2f-e76b-4248-a780-9d4cba90292a', '5998bc8d-6412-420d-89a7-b6b66df35b75', NULL, 'General Settings', '/settings', 'ri-user-settings-line', 'General Settings', 't', 3, 't'),('f294e9df-01b3-4144-8298-7d4bc1157bf4', '5998bc8d-6412-420d-89a7-b6b66df35b75', 'd6fd4f2f-e76b-4248-a780-9d4cba90292a', 'Users & Companies', '', '', 'Users & Companies', 'f', 0, 't'),('9133141d-e95f-4a7b-8a2b-eaff67f6c5da', '5998bc8d-6412-420d-89a7-b6b66df35b75', 'f294e9df-01b3-4144-8298-7d4bc1157bf4', 'Companies', '/settings/organizations', '', 'Companies', 'f', 0, 't'),('eebf9de8-6aaf-45fc-96af-e8b3fa31d912', '5998bc8d-6412-420d-89a7-b6b66df35b75', 'f294e9df-01b3-4144-8298-7d4bc1157bf4', 'Groups', '/settings/groups', '', 'Groups', 'f', 1, 't'),('294b4c47-24d5-4da1-ae60-0015f20d5de4', '5998bc8d-6412-420d-89a7-b6b66df35b75', 'f294e9df-01b3-4144-8298-7d4bc1157bf4', 'Users', '/settings/users', '', 'Users', 'f', 2, 't'),('d418f7b2-53cb-4f6e-9c84-59ce3aacaadc', '5998bc8d-6412-420d-89a7-b6b66df35b75', 'f294e9df-01b3-4144-8298-7d4bc1157bf4', 'Roles', '/settings/roles', '', 'Roles', 'f', 3, 't'),('bd8e7cb7-3bc6-4ac2-88e1-35be9a82cade', '5998bc8d-6412-420d-89a7-b6b66df35b75', 'f294e9df-01b3-4144-8298-7d4bc1157bf4', 'Modules', '/settings/modules', '', 'Modules', 'f', 4, 't'),('42a38b91-7e83-44c7-afd2-1f08114d4e60', '016e6709-0119-4ee8-8eb8-5dae7008c209', NULL, 'System Configuration', '/configuration', 'ri-list-settings-line', 'System Configuration', 't', 4, 't'),('a8d2274d-95f8-415c-b9dc-d729212f36fc', '016e6709-0119-4ee8-8eb8-5dae7008c209', '42a38b91-7e83-44c7-afd2-1f08114d4e60', 'Resource', '/configuration/resource', '', 'Resource', 'f', 0, 't'),('2dbf9ece-cf72-4afb-bbd0-2aa4cb2a2b7e', '016e6709-0119-4ee8-8eb8-5dae7008c209', 'a8d2274d-95f8-415c-b9dc-d729212f36fc', 'Working Times', '/configuration/resource/workingTimes', '', 'Working Times', 'f', 0, 't'),('ab2a5a78-8fb0-4377-be95-6d9c8b296821', '016e6709-0119-4ee8-8eb8-5dae7008c209', 'a8d2274d-95f8-415c-b9dc-d729212f36fc', 'Resource Time Off', '/configuration/resource/resourceTimeOff', '', 'Resource Time Off', 'f', 1, 't'),('f4a776c1-8574-4056-861e-807eefc0a8cb', '016e6709-0119-4ee8-8eb8-5dae7008c209', 'a8d2274d-95f8-415c-b9dc-d729212f36fc', 'Resources', '/configuration/resource/resources', '', 'Resources', 'f', 2, 't'),('9182e747-9d9b-4d4d-8bf9-bebe15c62979', '016e6709-0119-4ee8-8eb8-5dae7008c209', '42a38b91-7e83-44c7-afd2-1f08114d4e60', 'Parameters', '/configuration/parameters', '', 'Parameters', 'f', 1, 't'),('ce40caa1-1665-4945-9511-979b4cec5319', '016e6709-0119-4ee8-8eb8-5dae7008c209', '9182e747-9d9b-4d4d-8bf9-bebe15c62979', 'System Parameters', '/configuration/parameters/systemparameters', '', 'System Parameters', 'f', 0, 't'),('8cd33c9e-a4df-4fcc-bec3-3e575af0c987', '016e6709-0119-4ee8-8eb8-5dae7008c209', '9182e747-9d9b-4d4d-8bf9-bebe15c62979', 'Company Properties', '', '', 'Company Properties', 'f', 1, 't'),('f4a39a48-c7a9-4bf4-9c58-6452254c8de6', '016e6709-0119-4ee8-8eb8-5dae7008c209', '42a38b91-7e83-44c7-afd2-1f08114d4e60', 'Email', '/configuration/email', '', 'Email', 'f', 2, 't'),('b1574ca3-9738-4941-873c-5815b75bec23', '016e6709-0119-4ee8-8eb8-5dae7008c209', 'f4a39a48-c7a9-4bf4-9c58-6452254c8de6', 'Emails', '/configuration/email/emmails', '', 'Emails', 'f', 0, 't'),('9ee769a2-0488-4b18-8166-04cedb1f93a9', '016e6709-0119-4ee8-8eb8-5dae7008c209', 'f4a39a48-c7a9-4bf4-9c58-6452254c8de6', 'Incoming Mail Servers ', '/configuration/email/incoming', '', 'Incoming Mail Servers ', 'f', 1, 't'),('fcb8b40c-f236-4526-9a70-3aaed0fc981a', '016e6709-0119-4ee8-8eb8-5dae7008c209', 'f4a39a48-c7a9-4bf4-9c58-6452254c8de6', 'Email Templates', '/configuration/email/template', '', 'Email Templates', 'f', 2, 't'),('ec81450e-dda5-46d6-97d3-b60792cca7bf', '016e6709-0119-4ee8-8eb8-5dae7008c209', 'f4a39a48-c7a9-4bf4-9c58-6452254c8de6', 'Outgoing Mail Servers ', '', '', 'Outgoing Mail Servers ', 'f', 3, 't'),('5c5ac5f3-0162-4826-b661-55d4c1111ddc', '016e6709-0119-4ee8-8eb8-5dae7008c209', 'f4a39a48-c7a9-4bf4-9c58-6452254c8de6', 'Snailmail Letters', '', '', 'Snailmail Letters', 'f', 4, 't')
;
COMMIT;
BEGIN;
LOCK TABLE "public"."qrtz_blob_triggers" IN SHARE MODE;
DELETE FROM "public"."qrtz_blob_triggers";
COMMIT;
BEGIN;
LOCK TABLE "public"."qrtz_calendars" IN SHARE MODE;
DELETE FROM "public"."qrtz_calendars";
COMMIT;
BEGIN;
LOCK TABLE "public"."qrtz_cron_triggers" IN SHARE MODE;
DELETE FROM "public"."qrtz_cron_triggers";
INSERT INTO "public"."qrtz_cron_triggers" ("sched_name","trigger_name","trigger_group","cron_expression","time_zone_id") VALUES ('SchedulerCluster', 'EmailJobs', 'DEFAULT', '0 * * ? * *', 'Asia/Ho_Chi_Minh')
;
COMMIT;
BEGIN;
LOCK TABLE "public"."qrtz_fired_triggers" IN SHARE MODE;
DELETE FROM "public"."qrtz_fired_triggers";
COMMIT;
BEGIN;
LOCK TABLE "public"."qrtz_job_details" IN SHARE MODE;
DELETE FROM "public"."qrtz_job_details";
INSERT INTO "public"."qrtz_job_details" ("sched_name","job_name","job_group","description","job_class_name","is_durable","is_nonconcurrent","is_update_data","requests_recovery","job_data") VALUES ('SchedulerCluster', 'EmailJobs', 'EmailGroup', NULL, 'com.base.portalservice.quartz.job.MailCronJob', 'f', 't', 'f', 'f', E'#\\012#Tue Mar 12 09:02:17 ICT 2024\\012myKey=myValue\\012')
;
COMMIT;
BEGIN;
LOCK TABLE "public"."qrtz_locks" IN SHARE MODE;
DELETE FROM "public"."qrtz_locks";
INSERT INTO "public"."qrtz_locks" ("sched_name","lock_name") VALUES ('SchedulerCluster', 'STATE_ACCESS'),('SchedulerCluster', 'TRIGGER_ACCESS')
;
COMMIT;
BEGIN;
LOCK TABLE "public"."qrtz_paused_trigger_grps" IN SHARE MODE;
DELETE FROM "public"."qrtz_paused_trigger_grps";
COMMIT;
BEGIN;
LOCK TABLE "public"."qrtz_scheduler_state" IN SHARE MODE;
DELETE FROM "public"."qrtz_scheduler_state";
INSERT INTO "public"."qrtz_scheduler_state" ("sched_name","instance_name","last_checkin_time","checkin_interval") VALUES ('SchedulerCluster', 'ip-172-30-1-321710208894979', 1710208977286, 20000)
;
COMMIT;
BEGIN;
LOCK TABLE "public"."qrtz_simple_triggers" IN SHARE MODE;
DELETE FROM "public"."qrtz_simple_triggers";
COMMIT;
BEGIN;
LOCK TABLE "public"."qrtz_simprop_triggers" IN SHARE MODE;
DELETE FROM "public"."qrtz_simprop_triggers";
COMMIT;
BEGIN;
LOCK TABLE "public"."qrtz_triggers" IN SHARE MODE;
DELETE FROM "public"."qrtz_triggers";
INSERT INTO "public"."qrtz_triggers" ("sched_name","trigger_name","trigger_group","job_name","job_group","description","next_fire_time","prev_fire_time","priority","trigger_state","trigger_type","start_time","end_time","calendar_name","misfire_instr","job_data") VALUES ('SchedulerCluster', 'EmailJobs', 'DEFAULT', 'EmailJobs', 'EmailGroup', NULL, 1710209040000, 1710208980000, 0, 'WAITING', 'CRON', 1710208937000, 0, NULL, 1, '')
;
COMMIT;
BEGIN;
LOCK TABLE "public"."resetpasswordtoken" IN SHARE MODE;
DELETE FROM "public"."resetpasswordtoken";
COMMIT;
BEGIN;
LOCK TABLE "public"."roles" IN SHARE MODE;
DELETE FROM "public"."roles";
INSERT INTO "public"."roles" ("roleid","organizationid","rolename","createdate","modifieddate","description","type_","subtype","active") VALUES ('97d25f60-c75d-48b8-8e8f-725a1c3d827b', NULL, 'SUPER_ADMIN', NULL, NULL, NULL, 0, NULL, 't'),('f95f8979-d2d0-456c-a294-7ed8cf4574fe', NULL, 'ADMIN', NULL, NULL, NULL, 1, NULL, 't'),('af21aa2d-c74c-4648-90ee-de20fb8b7d3f', NULL, 'USER', NULL, NULL, NULL, 2, NULL, 't')
;
COMMIT;
BEGIN;
LOCK TABLE "public"."roles_modules" IN SHARE MODE;
DELETE FROM "public"."roles_modules";
INSERT INTO "public"."roles_modules" ("roleid","moduleid") VALUES ('97d25f60-c75d-48b8-8e8f-725a1c3d827b', '77ff7528-fc80-489d-adf7-188b9919c157'),('af21aa2d-c74c-4648-90ee-de20fb8b7d3f', '77ff7528-fc80-489d-adf7-188b9919c157'),('f95f8979-d2d0-456c-a294-7ed8cf4574fe', '77ff7528-fc80-489d-adf7-188b9919c157'),('af21aa2d-c74c-4648-90ee-de20fb8b7d3f', '5a9591bf-e6aa-4700-9054-df630a9692a8'),('af21aa2d-c74c-4648-90ee-de20fb8b7d3f', '1bbf917b-db0e-4063-8cac-8429b98e62be'),('af21aa2d-c74c-4648-90ee-de20fb8b7d3f', '52025257-8893-4dac-9949-85abd2e1ef8f'),('97d25f60-c75d-48b8-8e8f-725a1c3d827b', '5998bc8d-6412-420d-89a7-b6b66df35b75'),('f95f8979-d2d0-456c-a294-7ed8cf4574fe', '5998bc8d-6412-420d-89a7-b6b66df35b75'),('97d25f60-c75d-48b8-8e8f-725a1c3d827b', '016e6709-0119-4ee8-8eb8-5dae7008c209'),('97d25f60-c75d-48b8-8e8f-725a1c3d827b', '5a9591bf-e6aa-4700-9054-df630a9692a8'),('97d25f60-c75d-48b8-8e8f-725a1c3d827b', '1bbf917b-db0e-4063-8cac-8429b98e62be')
;
COMMIT;
BEGIN;
LOCK TABLE "public"."tokens" IN SHARE MODE;
DELETE FROM "public"."tokens";
COMMIT;
BEGIN;
LOCK TABLE "public"."user_groups" IN SHARE MODE;
DELETE FROM "public"."user_groups";
COMMIT;
BEGIN;
LOCK TABLE "public"."users" IN SHARE MODE;
DELETE FROM "public"."users";
INSERT INTO "public"."users" ("userid","organizationid","username","fullname","password","emailaddress","jobtitle","gender","phone","createdate","modifieddate","passwordencrypted","passwordreset","passwordmodifieddate","gracelogincount","languageid","timezoneid","logindate","loginip","lastlogindate","lastloginip","lastfailedlogindate","failedloginattempts","lockout","lockoutdate","type_","status") VALUES ('1e90b132-52fc-4750-bff9-6db3a88ad49c', NULL, 'superadmin', 'superadmin', '$2a$10$aL1qYEscWlMGZiOkM43CjeozYLqA09Sa96Rk5dMxcSrO7g0FctBB.', 'phongle@gmail.com.vn', 'Super Admin', 0, '123456', '2024-02-02 15:48:13.389', '2024-02-02 15:48:13.389', 'f', 'f', '2024-02-02 15:48:13.39', 0, 'vi', 'Asia/Ho_Chi_Minh', NULL, NULL, NULL, NULL, NULL, NULL, 'f', NULL, 0, 1),('c18d6d82-c400-49a2-915e-3f41338fdbc9', NULL, 'admin', 'admin', '$2a$10$8cr8kVPtvjhbrdlNertWeOWwZNUyeIpWGK3FgnhtIuwYLZ4mdr/my', 'tanng.vn@gmail.com.vn', 'Admin', 0, '123456', '2024-02-02 15:48:13.593', '2024-02-02 15:48:13.593', 'f', 'f', '2024-02-02 15:48:13.593', 0, 'vi', 'Asia/Ho_Chi_Minh', NULL, NULL, NULL, NULL, NULL, NULL, 'f', NULL, 1, 1),('90cf248f-d809-4b7f-b524-8d0726170855', NULL, 'user', 'user', '$2a$10$fhpe247eYl2I3sOxkaCtPufLwKdorOCOAI56BXWwD.TsatatGtUbi', 'user@gmail.com.vn', 'user', 0, '123456', '2024-02-02 15:48:13.792', '2024-02-02 15:48:13.792', 'f', 'f', '2024-02-02 15:48:13.792', 0, 'vi', 'Asia/Ho_Chi_Minh', NULL, NULL, NULL, NULL, NULL, NULL, 'f', NULL, 2, 1)
;
COMMIT;
BEGIN;
LOCK TABLE "public"."users_authorities" IN SHARE MODE;
DELETE FROM "public"."users_authorities";
INSERT INTO "public"."users_authorities" ("userid","authorityid") VALUES ('1e90b132-52fc-4750-bff9-6db3a88ad49c', '43ca07f8-f68b-4e13-a66c-2174a5555070'),('c18d6d82-c400-49a2-915e-3f41338fdbc9', '52aefa62-aac1-48b8-a079-7c38f292ba98'),('90cf248f-d809-4b7f-b524-8d0726170855', '097cb7e6-45dc-4053-b2ce-88d5986a5931')
;
COMMIT;
BEGIN;
LOCK TABLE "public"."users_orgs" IN SHARE MODE;
DELETE FROM "public"."users_orgs";
COMMIT;
BEGIN;
LOCK TABLE "public"."users_roles" IN SHARE MODE;
DELETE FROM "public"."users_roles";
INSERT INTO "public"."users_roles" ("userid","roleid") VALUES ('1e90b132-52fc-4750-bff9-6db3a88ad49c', '97d25f60-c75d-48b8-8e8f-725a1c3d827b'),('c18d6d82-c400-49a2-915e-3f41338fdbc9', 'f95f8979-d2d0-456c-a294-7ed8cf4574fe'),('90cf248f-d809-4b7f-b524-8d0726170855', 'af21aa2d-c74c-4648-90ee-de20fb8b7d3f')
;
COMMIT;
ALTER TABLE "authorities" ADD CONSTRAINT "authorities_pkey" PRIMARY KEY ("authorityid");
ALTER TABLE "emails" ADD CONSTRAINT "emails_pkey" PRIMARY KEY ("id");
ALTER TABLE "groups" ADD CONSTRAINT "groups_pkey" PRIMARY KEY ("groupid");
ALTER TABLE "groups_roles" ADD CONSTRAINT "groups_roles_pkey" PRIMARY KEY ("groupid", "roleid");
ALTER TABLE "modules" ADD CONSTRAINT "module__pkey" PRIMARY KEY ("moduleid");
ALTER TABLE "organizations" ADD CONSTRAINT "organization__pkey" PRIMARY KEY ("organizationid");
ALTER TABLE "pages" ADD CONSTRAINT "page__pkey" PRIMARY KEY ("pageid", "moduleid");
ALTER TABLE "qrtz_blob_triggers" ADD CONSTRAINT "qrtz_blob_triggers_pkey" PRIMARY KEY ("sched_name", "trigger_name", "trigger_group");
ALTER TABLE "qrtz_calendars" ADD CONSTRAINT "qrtz_calendars_pkey" PRIMARY KEY ("sched_name", "calendar_name");
ALTER TABLE "qrtz_cron_triggers" ADD CONSTRAINT "qrtz_cron_triggers_pkey" PRIMARY KEY ("sched_name", "trigger_name", "trigger_group");
ALTER TABLE "qrtz_fired_triggers" ADD CONSTRAINT "qrtz_fired_triggers_pkey" PRIMARY KEY ("sched_name", "entry_id");
CREATE INDEX "idx_qrtz_ft_inst_job_req_rcvry" ON "qrtz_fired_triggers" USING btree (
  "sched_name" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
  "instance_name" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
  "requests_recovery" "pg_catalog"."bool_ops" ASC NULLS LAST
);
CREATE INDEX "idx_qrtz_ft_j_g" ON "qrtz_fired_triggers" USING btree (
  "sched_name" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
  "job_name" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
  "job_group" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_qrtz_ft_jg" ON "qrtz_fired_triggers" USING btree (
  "sched_name" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
  "job_group" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_qrtz_ft_t_g" ON "qrtz_fired_triggers" USING btree (
  "sched_name" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
  "trigger_name" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
  "trigger_group" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_qrtz_ft_tg" ON "qrtz_fired_triggers" USING btree (
  "sched_name" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
  "trigger_group" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_qrtz_ft_trig_inst_name" ON "qrtz_fired_triggers" USING btree (
  "sched_name" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
  "instance_name" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
ALTER TABLE "qrtz_job_details" ADD CONSTRAINT "qrtz_job_details_pkey" PRIMARY KEY ("sched_name", "job_name", "job_group");
CREATE INDEX "idx_qrtz_j_grp" ON "qrtz_job_details" USING btree (
  "sched_name" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
  "job_group" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_qrtz_j_req_recovery" ON "qrtz_job_details" USING btree (
  "sched_name" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
  "requests_recovery" "pg_catalog"."bool_ops" ASC NULLS LAST
);
ALTER TABLE "qrtz_locks" ADD CONSTRAINT "qrtz_locks_pkey" PRIMARY KEY ("sched_name", "lock_name");
ALTER TABLE "qrtz_paused_trigger_grps" ADD CONSTRAINT "qrtz_paused_trigger_grps_pkey" PRIMARY KEY ("sched_name", "trigger_group");
ALTER TABLE "qrtz_scheduler_state" ADD CONSTRAINT "qrtz_scheduler_state_pkey" PRIMARY KEY ("sched_name", "instance_name");
ALTER TABLE "qrtz_simple_triggers" ADD CONSTRAINT "qrtz_simple_triggers_pkey" PRIMARY KEY ("sched_name", "trigger_name", "trigger_group");
ALTER TABLE "qrtz_simprop_triggers" ADD CONSTRAINT "qrtz_simprop_triggers_pkey" PRIMARY KEY ("sched_name", "trigger_name", "trigger_group");
ALTER TABLE "qrtz_triggers" ADD CONSTRAINT "qrtz_triggers_pkey" PRIMARY KEY ("sched_name", "trigger_name", "trigger_group");
CREATE INDEX "idx_qrtz_t_c" ON "qrtz_triggers" USING btree (
  "sched_name" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
  "calendar_name" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_qrtz_t_g" ON "qrtz_triggers" USING btree (
  "sched_name" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
  "trigger_group" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_qrtz_t_j" ON "qrtz_triggers" USING btree (
  "sched_name" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
  "job_name" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
  "job_group" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_qrtz_t_jg" ON "qrtz_triggers" USING btree (
  "sched_name" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
  "job_group" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_qrtz_t_n_g_state" ON "qrtz_triggers" USING btree (
  "sched_name" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
  "trigger_group" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
  "trigger_state" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_qrtz_t_n_state" ON "qrtz_triggers" USING btree (
  "sched_name" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
  "trigger_name" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
  "trigger_group" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
  "trigger_state" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_qrtz_t_next_fire_time" ON "qrtz_triggers" USING btree (
  "sched_name" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
  "next_fire_time" "pg_catalog"."int8_ops" ASC NULLS LAST
);
CREATE INDEX "idx_qrtz_t_nft_misfire" ON "qrtz_triggers" USING btree (
  "sched_name" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
  "misfire_instr" "pg_catalog"."int2_ops" ASC NULLS LAST,
  "next_fire_time" "pg_catalog"."int8_ops" ASC NULLS LAST
);
CREATE INDEX "idx_qrtz_t_nft_st" ON "qrtz_triggers" USING btree (
  "sched_name" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
  "trigger_state" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
  "next_fire_time" "pg_catalog"."int8_ops" ASC NULLS LAST
);
CREATE INDEX "idx_qrtz_t_nft_st_misfire" ON "qrtz_triggers" USING btree (
  "sched_name" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
  "misfire_instr" "pg_catalog"."int2_ops" ASC NULLS LAST,
  "next_fire_time" "pg_catalog"."int8_ops" ASC NULLS LAST,
  "trigger_state" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_qrtz_t_nft_st_misfire_grp" ON "qrtz_triggers" USING btree (
  "sched_name" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
  "misfire_instr" "pg_catalog"."int2_ops" ASC NULLS LAST,
  "next_fire_time" "pg_catalog"."int8_ops" ASC NULLS LAST,
  "trigger_group" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
  "trigger_state" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_qrtz_t_state" ON "qrtz_triggers" USING btree (
  "sched_name" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
  "trigger_state" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
ALTER TABLE "resetpasswordtoken" ADD CONSTRAINT "resetpasswordtoken__pkey" PRIMARY KEY ("userid");
ALTER TABLE "roles" ADD CONSTRAINT "role__pkey" PRIMARY KEY ("roleid");
ALTER TABLE "roles_modules" ADD CONSTRAINT "roles_modules_pkey" PRIMARY KEY ("roleid", "moduleid");
ALTER TABLE "tokens" ADD CONSTRAINT "tokens_pkey" PRIMARY KEY ("tokenid");
ALTER TABLE "user_groups" ADD CONSTRAINT "user_groups_pkey" PRIMARY KEY ("userid", "groupid");
ALTER TABLE "users" ADD CONSTRAINT "user__pkey" PRIMARY KEY ("userid");
ALTER TABLE "users_authorities" ADD CONSTRAINT "users_authorities_pkey" PRIMARY KEY ("userid", "authorityid");
ALTER TABLE "users_orgs" ADD CONSTRAINT "users_orgs_pkey" PRIMARY KEY ("organizationid", "userid");
ALTER TABLE "users_roles" ADD CONSTRAINT "users_roles_pkey" PRIMARY KEY ("userid", "roleid");
ALTER TABLE "qrtz_blob_triggers" ADD CONSTRAINT "qrtz_blob_triggers_sched_name_trigger_name_trigger_group_fkey" FOREIGN KEY ("sched_name", "trigger_name", "trigger_group") REFERENCES "public"."qrtz_triggers" ("sched_name", "trigger_name", "trigger_group") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "qrtz_cron_triggers" ADD CONSTRAINT "qrtz_cron_triggers_sched_name_trigger_name_trigger_group_fkey" FOREIGN KEY ("sched_name", "trigger_name", "trigger_group") REFERENCES "public"."qrtz_triggers" ("sched_name", "trigger_name", "trigger_group") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "qrtz_simple_triggers" ADD CONSTRAINT "qrtz_simple_triggers_sched_name_trigger_name_trigger_group_fkey" FOREIGN KEY ("sched_name", "trigger_name", "trigger_group") REFERENCES "public"."qrtz_triggers" ("sched_name", "trigger_name", "trigger_group") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "qrtz_simprop_triggers" ADD CONSTRAINT "qrtz_simprop_triggers_sched_name_trigger_name_trigger_grou_fkey" FOREIGN KEY ("sched_name", "trigger_name", "trigger_group") REFERENCES "public"."qrtz_triggers" ("sched_name", "trigger_name", "trigger_group") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "qrtz_triggers" ADD CONSTRAINT "qrtz_triggers_sched_name_job_name_job_group_fkey" FOREIGN KEY ("sched_name", "job_name", "job_group") REFERENCES "public"."qrtz_job_details" ("sched_name", "job_name", "job_group") ON DELETE NO ACTION ON UPDATE NO ACTION;
