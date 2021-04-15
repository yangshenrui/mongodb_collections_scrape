package com.example.springboot.config;

/**
 * 生成集合名，用于 access_log_statistic，上线前一定要改成 MongodbC.
 */
public class MongodbP {
    private static String name;

    public static String getName() {
        return "log_20210125";
    }

    public static void setName(String name) {
        MongodbP.name = name;
    }
}
