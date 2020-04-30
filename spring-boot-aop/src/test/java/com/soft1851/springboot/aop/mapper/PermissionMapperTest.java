package com.soft1851.springboot.aop.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author: zw_w
 * @Date: 2020/4/14 11:44
 * @Description:
 */
@SpringBootTest
class PermissionMapperTest {

    @Resource
    private PermissionMapper permissionMapper;

    @Test
    void getChildPermissionById() {
        System.out.println(permissionMapper.getChildPermissionById("1"));
    }

    @Test
    void getPermissionByParentId() {
    }
}