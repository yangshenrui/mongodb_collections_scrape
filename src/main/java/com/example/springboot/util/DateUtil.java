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
}
