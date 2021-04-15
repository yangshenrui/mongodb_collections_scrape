package com.example.springboot.config;

import com.example.springboot.util.DateUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * 原本用于动态生成集合名，现已废弃.
 */
@Configuration
public class MongodbCollectionConfig {

    @Bean
    @Scope("prototype")
    public SecondaryCollection secondaryCollection() {
        return new SecondaryCollection();
    }

    class SecondaryCollection {
        public String getName() {
            return "log_" + DateUtil.todayMinus(0);
        }
    }
    @Bean
    @Scope("prototype")
    public PrimaryCollection primaryCollection() {
        return new PrimaryCollection();
    }

    class PrimaryCollection {
        public String getName() {
            return "log_log_20210125";
        }
    }
}