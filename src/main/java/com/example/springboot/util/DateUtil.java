package com.example.springboot.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateUtil {
    /**
     * 生成指定格式的据今天 num 天前的时间.
     */
    public static String todayMinus(int num, String format) {
        DateTimeFormatter dateFomatter = DateTimeFormatter.ofPattern(format);
        return LocalDateTime.now().minus(num, ChronoUnit.DAYS).format(dateFomatter);
    }

    /**
     * 生成指定格式的据现在 minutes 分钟前的时间.
     */
    public static String nowMinus(int minutes, String format) {
        DateTimeFormatter dateFomatter = DateTimeFormatter.ofPattern(format);
        return LocalDateTime.now().minus(minutes, ChronoUnit.MINUTES).format(dateFomatter);
    }

    /**
     * 当前分钟数模12.
     */
    public static String minMod12() {
        DateTimeFormatter dateFomatter = DateTimeFormatter.ofPattern("mm");
        String format = LocalDateTime.now().format(dateFomatter);
        int i = Integer.parseInt(format);
        int i1 = i % 12;
        if(i1 >= 10)
        return "" + i1;
        else
            return "0" + i1;
    }
}
