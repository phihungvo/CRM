package com.base.admin.quartz.job;

import com.base.admin.entity.Emails;
import com.base.admin.quartz.email.service.MailService;
import com.base.admin.quartz.email.service.ScheduledEmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.AddressException;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.io.IOException;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@DisallowConcurrentExecution
public class MailCronJob extends QuartzJobBean implements InterruptableJob {

    @Autowired
    MailService mailService;
    private volatile boolean toStopFlag = true;
    @Autowired
    private ScheduledEmailService scheduledEmailService;
    //    @Value("${spring.mail.username}")
    @Value("${support.email.from}")
    private String from;

    private final long sleepPeriodInMs = 3 * 60 * 1000L;

    //https://stackoverflow.com/questions/19091923/exceptions-while-sending-email-java
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        List<Emails> emailsList = null;
        JobKey key = jobExecutionContext.getJobDetail().getKey();
//        System.out.println("MailCronJob started with key :" + key.getName() + ", Group :"+key.getGroup() + " , Thread Name :"+Thread.currentThread().getName());
        do {
            emailsList = scheduledEmailService.getPageScheduled(0, 10);
            if (emailsList.size() > 0) {
                for (Emails email : emailsList) {
                    try {
                        String subject = email.getSubject();
                        String message = email.getMessage();
                        String toMail = email.getToemail();

                        mailService.sendMail(from, toMail, subject, message);

                        email.setStatus(MailStatus.SENT.getValue());
                        Date input = new Date();
                        email.setSentdate(input.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
                    } catch (AddressException e) {
                        email.setErrordescription(e.getMessage());
                        email.setStatus(MailStatus.FAILED.getValue());
                    } catch (MessagingException e) {
                        email.setErrordescription(e.getMessage());
                        email.setStatus(MailStatus.FAILED.getValue());
                    } catch (IOException e) {
                        email.setErrordescription(e.getMessage());
                        email.setStatus(MailStatus.FAILED.getValue());
                    } catch (Exception e) {
                        email.setErrordescription(e.getMessage());
                        email.setStatus(MailStatus.FAILED.getValue());
                    } finally {
                        scheduledEmailService.update(email);
                    }
                }
            }
        } while (emailsList.size() > 0 && toStopFlag);
//        JobDataMap jobDataMap = jobExecutionContext.getMergedJobDataMap();
//        String subject = jobDataMap.getString(Constants.MailScheduleJob.SUBJECT);
//        String message = jobDataMap.getString(Constants.MailScheduleJob.MESSAGE);
//        String toMail = jobDataMap.getString(Constants.MailScheduleJob.TO_MAIL);
//        Integer scheduleId = jobDataMap.getInt(Constants.MailScheduleJob.SCHEDULE_ID);
//
//        mailService.sendMail(from, toMail, subject, message);
//        mailScheduleDao.deleteMailSchedule(scheduleId);


//        try {
//            Thread.sleep(sleepPeriodInMs);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println("MailCronJob End");
    }

    @Override
    public void interrupt() throws UnableToInterruptJobException {
        System.out.println("Stopping thread... ");
        toStopFlag = false;
    }
}
