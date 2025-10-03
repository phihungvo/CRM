package com.base.admin.quartz.email.service;

import java.util.List;

import com.base.admin.entity.Emails;

public interface ScheduledEmailService {
    List<Emails> getPageScheduled(int page, int size);

    Boolean insert(Emails emails);

    Boolean update(Emails emails);
}
