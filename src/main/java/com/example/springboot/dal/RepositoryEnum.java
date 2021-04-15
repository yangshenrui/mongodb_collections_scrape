package com.example.springboot.dal;

import com.example.springboot.data.primary.repository.AccessLogStatisticRepository;
import com.example.springboot.data.secondary.repository.LogStatisticRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * 存储 Repository 及 结果数据集.
 */
public enum RepositoryEnum {
    ACCESS_LOG_STATISTIC(),
    LOG_STATISTIC();

    private MyRepository repository;
    /**
     * mongo 数据集
     */
    private Object data;

    public MyRepository getRepository() {
        return repository;
    }

    public void setRepository(MyRepository repository) {
        this.repository = repository;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Component
    public static class  EnumTypeInjector {
        @Resource private AccessLogStatisticRepository accessLogStatisticRepository;
        @Resource private LogStatisticRepository logStatisticRepository;
        @PostConstruct
        private void postConstruct() {
            ACCESS_LOG_STATISTIC.setRepository(accessLogStatisticRepository);
            LOG_STATISTIC.setRepository(logStatisticRepository);
        }
    }
}
