package com.example.usermanager.util;

public enum ResultType {
    SUCCESS(200, "Success"),
    FAILED(500, "Failed"),
    VALIDATE_FAILED(400, "Validation Failed");

    private final int code;
    private final String message;

    ResultType(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
