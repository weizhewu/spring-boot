package com.soft1851.springboot.aop.mapper;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author: zw_w
 * @Date: 2020/4/13 19:29
 * @Description:
 */
@SpringBootTest
class UserMapperTest {

    @Resource
    private UserMapper mapper;

    @Test
    void getUsers() {
        System.out.println(mapper.getUsers());
    }

    @Test
    void login() {
        System.out.println(mapper.login("111","111"));
    }
}