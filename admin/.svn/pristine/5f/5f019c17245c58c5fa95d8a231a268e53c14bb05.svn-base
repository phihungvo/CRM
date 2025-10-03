package com.base.admin.quartz.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.quartz.SchedulerException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public interface JobService {
    void initializeCronJob(
            String groupName, String jobName, Class<? extends QuartzJobBean> jobClass, Date date, String cronExpression)
            throws SchedulerException;

    boolean scheduleOneTimeJob(String groupName, String jobName, Class<? extends QuartzJobBean> jobClass, Date date);

    boolean scheduleCronJob(
            String groupName,
            String jobName,
            Class<? extends QuartzJobBean> jobClass,
            Date date,
            String cronExpression);

    boolean updateOneTimeJob(String jobName, Date date);

    boolean updateCronJob(String jobName, Date date, String cronExpression);

    boolean unScheduleJob(String jobName);

    boolean deleteJob(String groupName, String jobName);

    boolean pauseJob(String groupName, String jobName);

    boolean resumeJob(String groupName, String jobName);

    boolean startJobNow(String groupName, String jobName);

    boolean isJobRunning(String groupName, String jobName);

    List<Map<String, Object>> getAllJobs();

    boolean isJobWithNamePresent(String groupName, String jobName);

    String getJobState(String groupName, String jobName);

    boolean stopJob(String groupName, String jobName);
}
