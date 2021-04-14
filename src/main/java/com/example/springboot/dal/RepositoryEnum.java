package com.example.springboot.dal;

import com.example.springboot.data.primary.repository.AccessLogStatisticRepository;
import com.example.springboot.data.secondary.repository.LogStatisticRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

public enum RepositoryEnum {
    ACCESS_LOG_STATISTIC(),
    LOG_STATISTIC();

    private MyRepository repository;

    public MyRepository getRepository() {
        return repository;
    }

    public void setRepository(MyRepository repository) {
        this.repository = repository;
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
