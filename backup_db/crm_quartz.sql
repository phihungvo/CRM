/*
PostgreSQL Backup
Database: quartz/public
Backup Time: 2024-12-13 16:19:04
*/

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
INSERT INTO "public"."qrtz_fired_triggers" ("sched_name","entry_id","trigger_name","trigger_group","instance_name","fired_time","sched_time","priority","state","job_name","job_group","is_nonconcurrent","requests_recovery") VALUES ('SchedulerCluster', 'ip-172-30-1-5017314890254671731489067458', 'EmailJobs', 'DEFAULT', 'ip-172-30-1-501731489025467', 1734081526561, 1734081540000, 0, 'ACQUIRED', NULL, NULL, 'f', 'f')
;
COMMIT;
BEGIN;
LOCK TABLE "public"."qrtz_job_details" IN SHARE MODE;
DELETE FROM "public"."qrtz_job_details";
INSERT INTO "public"."qrtz_job_details" ("sched_name","job_name","job_group","description","job_class_name","is_durable","is_nonconcurrent","is_update_data","requests_recovery","job_data") VALUES ('SchedulerCluster', 'EmailJobs', 'EmailGroup', NULL, 'com.base.admin.quartz.job.MailCronJob', 'f', 't', 'f', 'f', E'#\\015\\012#Fri Dec 13 16:01:49 ICT 2024\\015\\012myKey=myValue\\015\\012')
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
INSERT INTO "public"."qrtz_scheduler_state" ("sched_name","instance_name","last_checkin_time","checkin_interval") VALUES ('SchedulerCluster', 'ip-172-30-1-501731489025467', 1734081531777, 20000),('SchedulerCluster', 'DELL-55401734080508694', 1734081533445, 20000)
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
INSERT INTO "public"."qrtz_triggers" ("sched_name","trigger_name","trigger_group","job_name","job_group","description","next_fire_time","prev_fire_time","priority","trigger_state","trigger_type","start_time","end_time","calendar_name","misfire_instr","job_data") VALUES ('SchedulerCluster', 'EmailJobs', 'DEFAULT', 'EmailJobs', 'EmailGroup', NULL, 1734081600000, 1734081540000, 0, 'WAITING', 'CRON', 1734080509000, 0, NULL, 1, '')
;
COMMIT;
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
ALTER TABLE "qrtz_blob_triggers" ADD CONSTRAINT "qrtz_blob_triggers_sched_name_trigger_name_trigger_group_fkey" FOREIGN KEY ("sched_name", "trigger_name", "trigger_group") REFERENCES "public"."qrtz_triggers" ("sched_name", "trigger_name", "trigger_group") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "qrtz_cron_triggers" ADD CONSTRAINT "qrtz_cron_triggers_sched_name_trigger_name_trigger_group_fkey" FOREIGN KEY ("sched_name", "trigger_name", "trigger_group") REFERENCES "public"."qrtz_triggers" ("sched_name", "trigger_name", "trigger_group") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "qrtz_simple_triggers" ADD CONSTRAINT "qrtz_simple_triggers_sched_name_trigger_name_trigger_group_fkey" FOREIGN KEY ("sched_name", "trigger_name", "trigger_group") REFERENCES "public"."qrtz_triggers" ("sched_name", "trigger_name", "trigger_group") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "qrtz_simprop_triggers" ADD CONSTRAINT "qrtz_simprop_triggers_sched_name_trigger_name_trigger_grou_fkey" FOREIGN KEY ("sched_name", "trigger_name", "trigger_group") REFERENCES "public"."qrtz_triggers" ("sched_name", "trigger_name", "trigger_group") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "qrtz_triggers" ADD CONSTRAINT "qrtz_triggers_sched_name_job_name_job_group_fkey" FOREIGN KEY ("sched_name", "job_name", "job_group") REFERENCES "public"."qrtz_job_details" ("sched_name", "job_name", "job_group") ON DELETE NO ACTION ON UPDATE NO ACTION;
