package com.example.springboot.data.secondary.repository;

import com.example.springboot.data.secondary.model.LogStatistic;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface LogStatisticRepository extends MongoRepository<LogStatistic, String> {
    List<LogStatistic> findAllByMonitorTime(long monitorTime);
}