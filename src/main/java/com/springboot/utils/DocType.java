package com.springboot.utils;

public enum DocType {

    REIMBURSE("reimburse"),

    OTHER("other");

    private final String type;

    private DocType(String protocol) {
        this.type = protocol;
    }

    @Override
    public String toString() {
        return type;
    }
}
