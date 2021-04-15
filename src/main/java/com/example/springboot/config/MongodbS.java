package com.example.springboot.config;

/**
 * 生成集合名，用于 log_statistic，上线前一定要改成 MongodbC.
 */
public class MongodbS {
    private static String name;

    public static String getName() {
        return "log_20210301";
    }

    public static void setName(String name) {
        MongodbS.name = name;
    }
}
