package com.example.springboot.data.secondary.repository;

import com.example.springboot.dal.MyRepository;
import com.example.springboot.data.secondary.model.LogStatistic;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface LogStatisticRepository extends MyRepository<LogStatistic, String> {
    List<LogStatistic> findAllByMonitorTime(long monitorTime);
}