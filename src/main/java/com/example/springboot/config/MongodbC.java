package com.example.springboot.config;

import com.example.springboot.util.DateUtil;

/**
 * 根据日期生成集合名.
 */
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
