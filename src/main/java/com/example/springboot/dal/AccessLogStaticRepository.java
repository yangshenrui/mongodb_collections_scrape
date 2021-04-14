package com.example.springboot.dal;

import com.example.springboot.model.AccessLogStatic;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccessLogStaticRepository extends MongoRepository<AccessLogStatic, String> {
    List<AccessLogStatic> findByMonitorTime(long time);
}
