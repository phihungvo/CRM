package com.base.admin.constant;

public enum UserType {
    SUPER_ADMIN(0),
    ADMIN(1),
    USER(2);

    private final Integer value;

    UserType(final Integer newValue) {
        value = newValue;
    }

    public static boolean isAdmin(Integer value) {
        return value == ADMIN.value;
    }

    public static boolean isSuperAdmin(Integer value) {
        return value == SUPER_ADMIN.value;
    }

    public static boolean isUser(Integer value) {
        return value == USER.value;
    }

    public Integer getValue() {
        return value;
    }
}
