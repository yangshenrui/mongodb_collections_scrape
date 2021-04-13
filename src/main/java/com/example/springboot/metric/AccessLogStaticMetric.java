package com.example.springboot.metric;

import com.example.springboot.dal.AccessLogStaticRepository;
import com.example.springboot.model.AccessLogStatic;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.binder.MeterBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


public class AccessLogStaticMetric implements MeterBinder {

    private AccessLogStaticRepository accessLogStaticRepository;
    private List<AccessLogStatic> accessLogStatics;

    @Override
    public void bindTo(MeterRegistry meterRegistry) {
        accessLogStatics = accessLogStaticRepository.findAll();
        bindCount(meterRegistry, accessLogStatics);
        bindResponseAvgTime(meterRegistry, accessLogStatics);
        bindUpstreamAvgTime(meterRegistry, accessLogStatics);
        bindResponseMaxTime(meterRegistry, accessLogStatics);
        bindUpstreamMaxTime(meterRegistry, accessLogStatics);
    }
    /**
     * 采集 access_log_statistic_upstreamMaxTime
     * <pre>
     *     标签：
     *        name，host，statusCode
     * </pre>
     * @param meterRegistry
     * @param accessLogStatics
     */
    private void bindUpstreamMaxTime(MeterRegistry meterRegistry, List<AccessLogStatic> accessLogStatics) {
        accessLogStatics.forEach(c -> {
            Gauge.builder("access_log_statistic_upstreamMaxTime", c, accessLog -> accessLog.getUpstreamMaxTime())
                    .tag("name", c.getName())
                    .tag("host", c.getHost())
                    .tag("statusCode", c.getStatusCode())
                    .description("upstreamMaxTime of request")
                    .register(meterRegistry);
        });
    }

    /**
     * 采集 access_log_statistic_responseMaxTime
     * <pre>
     *     标签：
     *        name，host，statusCode
     * </pre>
     * @param meterRegistry
     * @param accessLogStatics
     */
    private void bindResponseMaxTime(MeterRegistry meterRegistry, List<AccessLogStatic> accessLogStatics) {
        accessLogStatics.forEach(c -> {
            Gauge.builder("access_log_statistic_responseMaxTime", c, accessLog -> accessLog.getResponseMaxTime())
                    .tag("name", c.getName())
                    .tag("host", c.getHost())
                    .tag("statusCode", c.getStatusCode())
                    .description("responseMaxTime of request")
                    .register(meterRegistry);
        });
    }

    /**
     * 采集 access_log_statistic_upstreamAvgTime
     * <pre>
     *     标签：
     *        name，host，statusCode
     * </pre>
     * @param meterRegistry
     * @param accessLogStatics
     */
    private void bindUpstreamAvgTime(MeterRegistry meterRegistry, List<AccessLogStatic> accessLogStatics) {
        accessLogStatics.forEach(c -> {
            Gauge.builder("access_log_statistic_upstreamAvgTime", c, accessLog -> accessLog.getUpstreamAvgTime())
                    .tag("name", c.getName())
                    .tag("host", c.getHost())
                    .tag("statusCode", c.getStatusCode())
                    .description("upstreamAvgTime of request")
                    .register(meterRegistry);
        });
    }

    /**
     * 采集 access_log_statistic_responseAvgTime
     * <pre>
     *     标签：
     *        name，host，statusCode
     * </pre>
     * @param meterRegistry
     * @param accessLogStatics
     */
    private void bindResponseAvgTime(MeterRegistry meterRegistry, List<AccessLogStatic> accessLogStatics) {
        accessLogStatics.forEach(c -> {
            Gauge.builder("access_log_statistic_responseAvgTime", c, accessLog -> accessLog.getResponseAvgTime())
                    .tag("name", c.getName())
                    .tag("host", c.getHost())
                    .tag("statusCode", c.getStatusCode())
                    .description("responseAvgTime of request")
                    .register(meterRegistry);
        });
    }

    /**
     * 采集 access_log_statistic_count
     * <pre>
     *     标签：
     *        name，host，statusCode
     * </pre>
     * @param meterRegistry
     * @param accessLogStatics
     */
    private void bindCount(MeterRegistry meterRegistry, List<AccessLogStatic> accessLogStatics) {
        accessLogStatics.forEach(c -> {
            Gauge.builder("access_log_statistic_count", c, accessLog -> accessLog.getCount())
                    .tag("name", c.getName())
                    .tag("host", c.getHost())
                    .tag("statusCode", c.getStatusCode())
                    .description("count of request")
                    .register(meterRegistry);
        });
    }

}
