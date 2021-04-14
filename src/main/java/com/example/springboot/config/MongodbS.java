package com.example.springboot.config;

public class MongodbS {
    private static String name;

    public static String getName() {
        return "log_20210301";
    }

    public static void setName(String name) {
        MongodbS.name = name;
    }
}
