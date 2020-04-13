package com.soft1851.springboot.aop.annotation;

import com.soft1851.springboot.aop.entity.User;
import com.soft1851.springboot.aop.mapper.UserMapper;

import javax.annotation.Resource;
import java.lang.annotation.*;
import java.util.List;

/**
 * @Author wzw
 * @Description
 * @Date 2020/4/13
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AuthToken {

    /**
     * 访问接口所需要的身份，默认为空，即登录即可访问，可以定义多个
     *
     * @return String[]
     */
    String[] role_name() default "";

    /**
     * 用户信息验证
     * @return
     */
    String[] user() default "";
}