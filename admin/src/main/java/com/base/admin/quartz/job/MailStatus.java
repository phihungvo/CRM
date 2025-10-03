package com.base.admin.quartz.job;

public enum MailStatus {
    SCHEDULED(0),
    SENT(1),
    FAILED(2);

    private final Integer id;

    MailStatus(Integer id) {
        this.id = id;
    }

    public int getValue() {
        return id;
    }

}
