package com.example.springboot.data.secondary.model;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Accessors(chain = true)
@Document(collection = "#{T(com.example.springboot.config.MongodbC).name}")
public class LogStatistic {
    private long count;
    private float avgTime;
    private float maxTime;
    private String name;
    private String module;
    private String host;
    private int resultCode;
    private long monitorTime;
}
