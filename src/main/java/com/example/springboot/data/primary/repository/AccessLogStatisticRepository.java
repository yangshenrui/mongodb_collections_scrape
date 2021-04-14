package com.example.springboot.data.primary.repository;

import com.example.springboot.dal.MyRepository;
import com.example.springboot.data.primary.model.AccessLogStatistic;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AccessLogStatisticRepository extends MyRepository<AccessLogStatistic, String> {
    List<AccessLogStatistic> findAllByMonitorTime(long monitorTime);
}
