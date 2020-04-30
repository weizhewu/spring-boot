package com.soft1851.springboot.aop.service.impl;

import com.soft1851.springboot.aop.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author: zw_w
 * @Date: 2020/4/14 10:24
 * @Description:
 */
@SpringBootTest
class UserServiceImplTest {

    @Resource
    private UserServiceImpl userService;

    @Test
    void signIn() {
        System.out.println(userService.signIn("1","111"));
    }
}