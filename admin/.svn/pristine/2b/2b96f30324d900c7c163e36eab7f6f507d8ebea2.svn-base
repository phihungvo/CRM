package com.base.admin;

import com.base.admin.quartz.constants.SheduleConstant;
import com.base.admin.quartz.job.MailCronJob;
import com.base.admin.quartz.service.JobService;
import org.mybatis.spring.annotation.MapperScan;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.Date;

@SpringBootApplication
@EnableAsync
@MapperScan("com.base.admin.inventory.mapper")
public class AdminApplication {
    @Autowired
    JobService jobService;

    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void startTheScheduledJobFromDatabase() throws SchedulerException {
        startAllSchedulers();
    }

    public void startAllSchedulers() throws SchedulerException {

        jobService.initializeCronJob(SheduleConstant.EMAIL_SCHEDULE_GROUP, SheduleConstant.EMAIL_SCHEDULE_JOBS, MailCronJob.class, new Date(), SheduleConstant.EMAIL_SCHEDULE_CRON_EXPRESSIONS);
    }
}
    