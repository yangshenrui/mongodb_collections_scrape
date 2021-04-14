package com.example.springboot.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document("test1")
public class Exporter {
    private String name;
    private String age;
    private String title;
    private String sex;
}