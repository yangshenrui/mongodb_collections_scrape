package com.example.springboot.client;

import com.example.springboot.annotation.MongoQuery;
import com.example.springboot.dal.RepositoryEnum;
import com.example.springboot.data.primary.model.AccessLogStatistic;
import io.prometheus.client.Collector;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class AccessLogStatisticCollector extends Collector {

    @MongoQuery(name = "ACCESS_LOG_STATISTIC")
    @Override
    public List<MetricFamilySamples> collect() {
        System.out.println("执行一次 ACCESS_LOG_STATISTIC collect");
        List<AccessLogStatistic> list = (List<AccessLogStatistic>)RepositoryEnum.valueOf("ACCESS_LOG_STATISTIC").getData();
        System.out.println("ACCESS_LOG_STATISTIC collect 有 " + list.size() + "条数据");
        List<MetricFamilySamples> mfs = new ArrayList<MetricFamilySamples>();
        mfs.add(metricsOfCount(list));
        mfs.add(metricsOfResponseAvgTime(list));
        mfs.add(metricsOfResponseMaxTime(list));
        mfs.add(metricsOfUpstreamAvgTime(list));
        mfs.add(metricsOfUpstreamMaxTime(list));
        return mfs;
    }

    /**
     * 生成指标 access_log_statistic_count.
     * <pre>
     * 标签:
     *      name, host, statusCode
     * </pre>
     * @param list 源数据集
     * @return 指标
     */
    private MetricFamilySamples metricsOfCount(List<AccessLogStatistic> list) {
        String metricName = "access_log_statistic_count";
        ArrayList<MetricFamilySamples.Sample> metricList = new ArrayList<>();
        list.forEach(accessLogStatic -> {
            metricList.add(new MetricFamilySamples.Sample(metricName,
                    Arrays.asList("name", "host", "statusCode"),
                    Arrays.asList(accessLogStatic.getName(), accessLogStatic.getHost(), "" + accessLogStatic.getStatusCode()),
                    accessLogStatic.getCount()));
        });
        return new MetricFamilySamples(metricName, Type.GAUGE, "count", metricList);
    }

    /**
     * 生成指标 access_log_statistic_responseAvgTime.
     * <pre>
     * 标签:
     *      name, host, statusCode
     * </pre>
     * @param list 源数据集
     * @return 指标
     */
    private MetricFamilySamples metricsOfResponseAvgTime(List<AccessLogStatistic> list) {
        String metricName = "access_log_statistic_responseAvgTime";
        ArrayList<MetricFamilySamples.Sample> metricList = new ArrayList<>();
        list.forEach(accessLogStatic -> {
            metricList.add(new MetricFamilySamples.Sample(metricName,
                    Arrays.asList("name", "host", "statusCode"),
                    Arrays.asList(accessLogStatic.getName(), accessLogStatic.getHost(), "" + accessLogStatic.getStatusCode()),
                    accessLogStatic.getResponseAvgTime()));
        });
        return new MetricFamilySamples(metricName, Type.GAUGE, "responseAvgTime", metricList);
    }

    /**
     * 生成指标 access_log_statistic_upstreamAvgTime.
     * <pre>
     * 标签:
     *      name, host, statusCode
     * </pre>
     * @param list 源数据集
     * @return 指标
     */
    private MetricFamilySamples metricsOfUpstreamAvgTime(List<AccessLogStatistic> list) {
        String metricName = "access_log_statistic_upstreamAvgTime";
        ArrayList<MetricFamilySamples.Sample> metricList = new ArrayList<>();
        list.forEach(accessLogStatic -> {
            metricList.add(new MetricFamilySamples.Sample(metricName,
                    Arrays.asList("name", "host", "statusCode"),
                    Arrays.asList(accessLogStatic.getName(), accessLogStatic.getHost(), "" + accessLogStatic.getStatusCode()),
                    accessLogStatic.getUpstreamAvgTime()));
        });
        return new MetricFamilySamples(metricName, Type.GAUGE, "upstreamAvgTime", metricList);
    }

    /**
     * 生成指标 access_log_statistic_responseMaxTime.
     * <pre>
     * 标签:
     *      name, host, statusCode
     * </pre>
     * @param list 源数据集
     * @return 指标
     */
    private MetricFamilySamples metricsOfResponseMaxTime(List<AccessLogStatistic> list) {
        String metricName = "access_log_statistic_responseMaxTime";
        ArrayList<MetricFamilySamples.Sample> metricList = new ArrayList<>();
        list.forEach(accessLogStatic -> {
            metricList.add(new MetricFamilySamples.Sample(metricName,
                    Arrays.asList("name", "host", "statusCode"),
                    Arrays.asList(accessLogStatic.getName(), accessLogStatic.getHost(), "" + accessLogStatic.getStatusCode()),
                    accessLogStatic.getResponseMaxTime()));
        });
        return new MetricFamilySamples(metricName, Type.GAUGE, "responseMaxTime", metricList);
    }

    /**
     * 生成指标 access_log_statistic_upstreamMaxTime.
     * <pre>
     * 标签:
     *      name, host, statusCode
     * </pre>
     * @param list 源数据集
     * @return 指标
     */
    private MetricFamilySamples metricsOfUpstreamMaxTime(List<AccessLogStatistic> list) {
        String metricName = "access_log_statistic_upstreamMaxTime";
        ArrayList<MetricFamilySamples.Sample> metricList = new ArrayList<>();
        list.forEach(accessLogStatic -> {
            metricList.add(new MetricFamilySamples.Sample(metricName,
                    Arrays.asList("name", "host", "statusCode"),
                    Arrays.asList(accessLogStatic.getName(), accessLogStatic.getHost(), "" + accessLogStatic.getStatusCode()),
                    accessLogStatic.getUpstreamMaxTime()));
        });
        return new MetricFamilySamples(metricName, Type.GAUGE, "upstreamMaxTime", metricList);
    }
}
