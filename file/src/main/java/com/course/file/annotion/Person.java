package com.course.file.annotion;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author jiange
 * @date 2020/7/13 19:12
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Person {
    String name();
    int age();
}
