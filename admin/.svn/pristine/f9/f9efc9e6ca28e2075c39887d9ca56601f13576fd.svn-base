package com.base.admin.quartz.email.service;

import com.base.admin.entity.Emails;
import com.base.admin.mapper.EmailsMapper;
import com.base.admin.quartz.job.MailStatus;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduledEmailServiceImpl implements ScheduledEmailService {

    private final EmailsMapper emailsMapper;

    public ScheduledEmailServiceImpl(EmailsMapper emailsMapper) {
        this.emailsMapper = emailsMapper;
    }


    @Override
    public List<Emails> getPageScheduled(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return emailsMapper.findAllByStatus(MailStatus.SCHEDULED.getValue(), pageable);
    }

    @Override
    public Boolean insert(Emails emails) {
        try {
            emailsMapper.insert(emails);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean update(Emails emails) {
        try {
            emailsMapper.update(emails);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
