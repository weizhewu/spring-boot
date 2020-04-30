package com.soft1851.springboot.aop.service.impl;

import com.soft1851.springboot.aop.service.RolePermissionService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author: zw_w
 * @Date: 2020/4/14 11:51
 * @Description:
 */
@SpringBootTest
class RolePermissionServiceImplTest {
    @Resource
    private RolePermissionService service;

    @Test
    void getAdminRolePermission() {
        System.out.println(service.getAdminRolePermission());
    }

    @Test
    void getRolePermissionBySysAdmin() {
        System.out.println(service.getRolePermissionBySysAdmin(1));
    }
}