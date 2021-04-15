package com.example.springboot.client;

import com.example.springboot.annotation.MongoQuery;
import com.example.springboot.dal.RepositoryEnum;
import com.example.springboot.data.secondary.model.LogStatistic;
import io.prometheus.client.Collector;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class LogStatisticCollector extends Collector {

    @MongoQuery(name = "LOG_STATISTIC")
    @Override
    public List<MetricFamilySamples> collect() {
        System.out.println("执行一次 LOG_STATISTIC collect");
        List<LogStatistic> list = (List<LogStatistic>) RepositoryEnum.valueOf("LOG_STATISTIC").getData();
        System.out.println("LOG_STATISTIC collect 有 " + list.size() + "条数据");
        List<MetricFamilySamples> mfs = new ArrayList<MetricFamilySamples>();
        mfs.add(metricsOfCount(list));
        mfs.add(metricsOfAvgTime(list));
        mfs.add(metricsOfMaxTime(list));
        return mfs;
    }

    /**
     * 生成指标 log_statistic_maxTime.
     * <pre>
     * 标签:
     *      name,module,host,resultCode
     * </pre>
     * @param list 源数据集
     * @return 指标
     */
    private MetricFamilySamples metricsOfMaxTime(List<LogStatistic> list) {
        String metricName = "log_statistic_maxTime";
        ArrayList<MetricFamilySamples.Sample> metricList = new ArrayList<>();
        list.forEach(logStatic -> {
            metricList.add(new MetricFamilySamples.Sample(metricName,
                    Arrays.asList("name", "module", "host", "resultCode"),
                    Arrays.asList(logStatic.getName(), logStatic.getModule(), logStatic.getHost(), "" + logStatic.getResultCode()),
                    logStatic.getMaxTime()));
        });
        return new MetricFamilySamples(metricName, Type.GAUGE, "maxTime", metricList);
    }

    /**
     * 生成指标 log_statistic_avgTime.
     * <pre>
     * 标签:
     *      name,module,host,resultCode
     * </pre>
     * @param list 源数据集
     * @return 指标
     */
    private MetricFamilySamples metricsOfAvgTime(List<LogStatistic> list) {
        String metricName = "log_statistic_avgTime";
        ArrayList<MetricFamilySamples.Sample> metricList = new ArrayList<>();
        list.forEach(logStatic -> {
            metricList.add(new MetricFamilySamples.Sample(metricName,
                    Arrays.asList("name", "module", "host", "resultCode"),
                    Arrays.asList(logStatic.getName(), logStatic.getModule(), logStatic.getHost(), "" + logStatic.getResultCode()),
                    logStatic.getAvgTime()));
        });
        return new MetricFamilySamples(metricName, Type.GAUGE, "avgTime", metricList);
    }

    /**
     * 生成指标 log_statistic_count.
     * <pre>
     * 标签:
     *      name,module,host,resultCode
     * </pre>
     * @param list 源数据集
     * @return 指标
     */
    private MetricFamilySamples metricsOfCount(List<LogStatistic> list) {
        String metricName = "log_statistic_count";
        ArrayList<MetricFamilySamples.Sample> metricList = new ArrayList<>();
        list.forEach(logStatic -> {
            metricList.add(new MetricFamilySamples.Sample(metricName,
                    Arrays.asList("name", "module", "host", "resultCode"),
                    Arrays.asList(logStatic.getName(), logStatic.getModule(), logStatic.getHost(), "" + logStatic.getResultCode()),
                    logStatic.getCount()));
        });
        return new MetricFamilySamples(metricName, Type.GAUGE, "count", metricList);
    }
}
