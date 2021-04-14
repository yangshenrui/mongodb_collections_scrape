package com.example.springboot.aspect;

import com.example.springboot.annotation.MongoQuery;
import com.example.springboot.dal.MyRepository;
import com.example.springboot.dal.RepositoryEnum;
import com.example.springboot.data.MongoData;
import com.example.springboot.data.primary.repository.AccessLogStatisticRepository;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MongoQueryAspect {

    @Pointcut("@annotation(mongoQuery)")
    public void serviceStatistics(MongoQuery mongoQuery) {
    }

    @Before("serviceStatistics(mongoQuery)")
    public void doBefore(JoinPoint joinPoint, MongoQuery mongoQuery) {
        MyRepository repository = RepositoryEnum.valueOf(mongoQuery.name()).getRepository();
//        repository.findByMonitorTime(202101250000l);
//        System.out.println(repository.findByMonitorTime(202101250000l).size());
//        MyRepository repository = (MyRepository) mongoQuery.repository().getRepository();
        MongoData.accessLogStatistics = repository.findByMonitorTime(202101250000l);
        System.out.println(mongoQuery.name() + " 执行一次查询");
    }

//    @Pointcut("execution(* com.example.springboot.client.*.collect(..))")
//    public void serviceStatistics() {
//    }
//
//    @Before("serviceStatistics()")
//    public void doBefore(JoinPoint joinPoint) {
//        System.out.println("accessLogStatisticRepository 执行一次查询");
//    }
}
