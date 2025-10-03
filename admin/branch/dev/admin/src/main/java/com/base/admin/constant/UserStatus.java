package com.base.admin.constant;

public enum UserStatus {
    FORCE_CHANGE_PASSWORD(0),
    STATUS_NORMAL(1),
    STATUS_LOCKED(2);

    private final Integer value;

    UserStatus(final Integer newValue) {
        value = newValue;
    }

    public Integer getValue() {
        return value;
    }
}
