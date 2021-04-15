package com.example.springboot.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 触发一次 MongoDB 查询.
 * 后续可以尝试使用 RepositoryEnum，直接赋值 repository，而不是用 name
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MongoQuery {
//    RepositoryEnum repository();
    String name();
}
