package com.example.springboot.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document("log_20210125")
public class AccessLogStatic {
    @Field("count")
    private long count;
    private float responseAvgTime;
    private float upstreamAvgTime;
    private float responseMaxTime;
    private float upstreamMaxTime;
    private float totalUpstreamTime;
    private float totalResponseTime;
    @Field("name")
    private String name;
    private String host;
    private String statusCode;
    private long monitorTime;
}
