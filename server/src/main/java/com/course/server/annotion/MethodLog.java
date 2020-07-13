package com.course.server.annotion;

import java.lang.annotation.*;

/**
 * 日志处理
 * @author jiange
 * @date 2020/7/13 19:19
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface MethodLog {

    boolean throwException() default true;
}
