package com.example.springboot.data;

import com.example.springboot.data.primary.model.AccessLogStatistic;
import com.example.springboot.data.secondary.model.LogStatistic;

import java.util.List;

/**
 * 作为指标的源数据集。已废弃，改用 RepositoryEnum 存储数据.
 */
public class MongoData {
    public static List<AccessLogStatistic> accessLogStatistics;
    public static List<LogStatistic> logStatistics;
}
