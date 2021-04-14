package com.example.springboot.dal;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MyRepository<T, ID> extends MongoRepository<T, ID> {
    List findByMonitorTime(long time);
}
