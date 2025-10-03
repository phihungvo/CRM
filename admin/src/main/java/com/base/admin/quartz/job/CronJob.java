package com.base.admin.quartz.job;

import com.base.admin.quartz.service.JobService;
import org.quartz.*;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;
import java.util.List;
import java.util.Map;

@DisallowConcurrentExecution
public class CronJob extends QuartzJobBean implements InterruptableJob {

    private final JobService jobService;
    private volatile boolean toStopFlag = true;

    public CronJob(JobService jobService) {
        this.jobService = jobService;
    }

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobKey key = jobExecutionContext.getJobDetail().getKey();
        System.out.println("Cron Job started with key :" + key.getName() + ", Group :" + key.getGroup() + " , Thread Name :" + Thread.currentThread().getName() + " ,Time now :" + new Date());

        System.out.println("======================================");
        System.out.println("Accessing annotation example: " + jobService.getAllJobs());
        List<Map<String, Object>> list = jobService.getAllJobs();
        System.out.println("Job list :" + list);
        System.out.println("======================================");

        //*********** For retrieving stored key-value pairs ***********/
        JobDataMap dataMap = jobExecutionContext.getMergedJobDataMap();
        String myValue = dataMap.getString("myKey");
        System.out.println("Value:" + myValue);

        System.out.println("Thread: " + Thread.currentThread().getName() + " stopped.");
    }

    @Override
    public void interrupt() throws UnableToInterruptJobException {
        System.out.println("Stopping thread... ");
        toStopFlag = false;
    }

}