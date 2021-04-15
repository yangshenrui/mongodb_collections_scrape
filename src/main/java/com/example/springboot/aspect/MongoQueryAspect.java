package com.example.springboot.aspect;

import com.example.springboot.annotation.MongoQuery;
import com.example.springboot.dal.MyRepository;
import com.example.springboot.dal.RepositoryEnum;
import com.example.springboot.data.MongoData;
import com.example.springboot.data.primary.model.AccessLogStatistic;
import com.example.springboot.data.primary.repository.AccessLogStatisticRepository;
import com.example.springboot.util.DateUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 在 collect 前执行查询.
 */
@Aspect
@Component
public class MongoQueryAspect {

    @Pointcut("@annotation(mongoQuery)")
    public void serviceStatistics(MongoQuery mongoQuery) {
    }

    @Before("serviceStatistics(mongoQuery)")
    public void doBefore(JoinPoint joinPoint, MongoQuery mongoQuery) {
        RepositoryEnum repositoryEnum = RepositoryEnum.valueOf(mongoQuery.name());
        MyRepository repository = repositoryEnum.getRepository();
        String s = DateUtil.minMod12();
        if ("ACCESS_LOG_STATISTIC".equals(mongoQuery.name())) {
            long l = Long.parseLong("2021012500" + s);
            repositoryEnum.setData(repository.findByMonitorTime(l));
        } else {
            long l = Long.parseLong("2021030100" + s);
            repositoryEnum.setData(repository.findByMonitorTime(l));
        }
        System.out.println(mongoQuery.name() + " 执行一次查询");
    }
}
