package com.example.springboot.config;

public class MongodbP {
    private static String name;

    public static String getName() {
        return "log_20210125";
    }

    public static void setName(String name) {
        MongodbP.name = name;
    }
}
