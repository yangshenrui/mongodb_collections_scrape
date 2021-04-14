package com.example.springboot.config;

import com.example.springboot.util.DateUtil;

public class MongodbC {
    private static String name;

    public static String getName() {
        name = "log_" + DateUtil.todayMinus(0);
        return name;
    }

    public static void setName(String name) {
        MongodbC.name = name;
    }
}
