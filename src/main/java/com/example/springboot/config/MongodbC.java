package com.example.springboot.config;

import com.example.springboot.util.DateUtil;

/**
 * 根据日期生成集合名.
 */
public class MongodbC {
    private static String name;

    public static String getName() {
        return "log_" + DateUtil.todayMinus(0, "yyyyMMdd");
    }

    public static void setName(String name) {
        MongodbC.name = name;
    }
}
