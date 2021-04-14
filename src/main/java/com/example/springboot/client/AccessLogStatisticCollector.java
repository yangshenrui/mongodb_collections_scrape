package com.example.springboot.client;

import com.example.springboot.annotation.MongoQuery;
import com.example.springboot.dal.RepositoryEnum;
import com.example.springboot.data.MongoData;
import io.prometheus.client.Collector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class AccessLogStatisticCollector extends Collector implements Kong{

    @MongoQuery(name = "ACCESS_LOG_STATISTIC")
    @Override
    public List<MetricFamilySamples> collect() {
        System.out.println("ddf");
        List<MetricFamilySamples> mfs = new ArrayList<MetricFamilySamples>();
        mfs.add(metricsOfCount());
        return mfs;
    }

    /**
     * 生成指标 access_log_statistic_count.
     * <pre>
     * 标签:
     *      name, host, statusCode
     * </pre>
     */
    private MetricFamilySamples metricsOfCount() {
        String metricName = "access_log_statistic_count";
        ArrayList<MetricFamilySamples.Sample> metricList = new ArrayList<>();
//        MongoData.accessLogStatistics.forEach(accessLogStatic -> {
//            metricList.add(new MetricFamilySamples.Sample(metricName,
//                    Arrays.asList("name", "host"),
//                    Arrays.asList(accessLogStatic.getName(), accessLogStatic.getHost()),
//                    accessLogStatic.getCount()));
//        });
        return new MetricFamilySamples(metricName, Type.GAUGE, "asdf", metricList);
    }
}
