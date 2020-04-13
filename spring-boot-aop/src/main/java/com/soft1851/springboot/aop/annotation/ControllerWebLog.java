package com.soft1851.springboot.aop.annotation;

import java.lang.annotation.*;

/**
 * @Author yhChen
 * @Description 自定义Web日志注解
 * @Date 2020/4/9
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ControllerWebLog {
    /**
     * 调用的接口名称
     */
    String name();

    /**
     * 标识该日志是否需要持久化存储
     * @return boolean
     */
    boolean isSaved() default false;
}
