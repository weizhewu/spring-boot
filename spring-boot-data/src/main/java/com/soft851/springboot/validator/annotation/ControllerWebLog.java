package com.soft851.springboot.validator.annotation;

import java.lang.annotation.*;

/**
 * @Description 自定义的web日志注解
 * @author dyf
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ControllerWebLog {
    //调用的接口名称
    String name();
    //该日志是否需要持久化存储
    boolean isSaved() default false;
}
