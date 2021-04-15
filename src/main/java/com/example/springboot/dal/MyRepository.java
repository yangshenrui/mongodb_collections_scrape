package com.example.springboot.dal;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * 用于在枚举中接两个repository，不可替代，非常重要，用于解决类型转换问题.
 * @param <T>
 * @param <ID>
 */
public interface MyRepository<T, ID> extends MongoRepository<T, ID> {
    List findByMonitorTime(long time);
}
