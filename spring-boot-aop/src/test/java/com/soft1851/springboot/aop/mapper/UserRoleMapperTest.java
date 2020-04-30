package com.soft1851.springboot.aop.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author: zw_w
 * @Date: 2020/4/14 10:41
 * @Description:
 */
@SpringBootTest
class UserRoleMapperTest {
    @Resource
    private UserRoleMapper mapper;

    @Test
    void getUserRole() {
        System.out.println(mapper.getUserRole("1"));
    }
}