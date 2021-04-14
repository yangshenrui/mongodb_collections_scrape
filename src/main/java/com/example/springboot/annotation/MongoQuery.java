package com.example.springboot.annotation;

import com.example.springboot.dal.MyRepository;
import com.example.springboot.dal.RepositoryEnum;
import com.example.springboot.model.Exporter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MongoQuery {
//    RepositoryEnum repository();
    String name();
}
