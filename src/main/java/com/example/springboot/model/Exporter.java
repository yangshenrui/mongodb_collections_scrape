package com.example.springboot.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document("test1")
public class Exporter {
    @Field("name")
    private String name;
    @Field("age")
    private String age;
    @Field("title")
    private String title;
    @Field("sex")
    private String sex;
}