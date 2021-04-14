package com.example.springboot.client;

import com.example.springboot.dal.AccessLogStaticRepository;
import com.example.springboot.model.AccessLogStatic;
import io.prometheus.client.Collector;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * access_log_statistic 数据采集器.
 */
public class AccessLogStaticCollector extends Collector {
    @Autowired
    private AccessLogStaticRepository accessLogStaticRepository;

    public List<MetricFamilySamples> collect() {
        List<MetricFamilySamples> mfs = new ArrayList<MetricFamilySamples>();
        cc(mfs);
        return mfs;
    }

    private void cc(List<MetricFamilySamples> mfs) {
        List<AccessLogStatic> byMonitorTime = accessLogStaticRepository.findByMonitorTime(202101250012l);
        String countMetricName = "access_log_statistic_count";
        ArrayList<MetricFamilySamples.Sample> aSamples = new ArrayList<>();
        byMonitorTime.forEach(accessLogStatic -> {
            aSamples.add(new MetricFamilySamples.Sample(countMetricName,
                    Arrays.asList("name", "host"),
                    Arrays.asList(accessLogStatic.getName(), accessLogStatic.getHost()),
                    accessLogStatic.getCount()));
        });
        MetricFamilySamples samples = new MetricFamilySamples(countMetricName, Type.GAUGE, "help", aSamples);
        mfs.add(samples);
    }
}