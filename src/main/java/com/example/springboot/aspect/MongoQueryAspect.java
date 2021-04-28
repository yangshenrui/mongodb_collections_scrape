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
        // 由于 mongo 数据延迟两分钟，这里每次触发采集查询两分钟前的数据
        long l = Long.parseLong(DateUtil.nowMinus(2, "yyyyMMddHHmm"));
        // 存储查询结果
        repositoryEnum.setData(repository.findByMonitorTime(l));
        System.out.println(mongoQuery.name() + " 执行一次查询" + l);
    }
}
