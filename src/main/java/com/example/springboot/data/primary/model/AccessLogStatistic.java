package com.example.springboot.data.primary.model;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Accessors(chain = true)
@Document(collection = "#{T(com.example.springboot.config.MongodbP).name}")
public class AccessLogStatistic  {
    private long count;
    private float responseAvgTime;
    private float upstreamAvgTime;
    private float responseMaxTime;
    private float upstreamMaxTime;
    private String name;
    private String host;
    private int statusCode;
    private long monitorTime;
}
