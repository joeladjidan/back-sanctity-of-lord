package com.joeladjidan.sanctityoflord.utils;

public enum Topic {

    AMES("Ames", 001);

    private final String name;

    private final int code;

    private Topic(String name, int code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public int getCode() {
        return code;
    }

}
