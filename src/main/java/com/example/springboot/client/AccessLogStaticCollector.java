package com.example.springboot.client;

import com.example.springboot.annotation.MongoQuery;
import com.example.springboot.dal.AccessLogStaticRepository;
import com.example.springboot.dal.RepositoryEnum;
import com.example.springboot.model.AccessLogStatic;
import io.prometheus.client.Collector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * access_log_statistic 数据采集器.
 */
@Component
public class AccessLogStaticCollector extends Collector {

    public List<MetricFamilySamples> collect() {
        List<MetricFamilySamples> mfs = new ArrayList<MetricFamilySamples>();
        cc(mfs);
        return mfs;
    }

    private void cc(List<MetricFamilySamples> mfs) {
    }
}