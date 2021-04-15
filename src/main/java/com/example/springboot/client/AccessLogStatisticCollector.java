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
        List<MetricFamilySamples> mfs = new ArrayList<MetricFamilySamples>();
        mfs.add(metricsOfCount(list));
        return mfs;
    }

    /**
     * 生成指标 access_log_statistic_count.
     * <pre>
     * 标签:
     *      name, host, statusCode
     * </pre>
     * @param list
     */
    private MetricFamilySamples metricsOfCount(List<AccessLogStatistic> list) {
        String metricName = "access_log_statistic_count";
        ArrayList<MetricFamilySamples.Sample> metricList = new ArrayList<>();
        list.forEach(accessLogStatic -> {
            metricList.add(new MetricFamilySamples.Sample(metricName,
                    Arrays.asList("name", "host"),
                    Arrays.asList(accessLogStatic.getName(), accessLogStatic.getHost()),
                    accessLogStatic.getCount()));
        });
        return new MetricFamilySamples(metricName, Type.GAUGE, "asdf", metricList);
    }
}
