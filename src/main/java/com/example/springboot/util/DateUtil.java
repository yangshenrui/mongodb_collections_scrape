package com.example.springboot.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateUtil {
    /**
     * 据今天 num 天前的日期.
     */
    public static String todayMinus(int num) {
        DateTimeFormatter dateFomatter = DateTimeFormatter.ofPattern("yyyyMMddss");
        return LocalDateTime.now().minus(num, ChronoUnit.DAYS).format(dateFomatter);
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
