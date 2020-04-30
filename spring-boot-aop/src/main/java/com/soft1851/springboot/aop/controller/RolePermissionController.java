package com.soft1851.springboot.aop.controller;

import com.soft1851.springboot.aop.annotation.AuthToken;
import com.soft1851.springboot.aop.service.RolePermissionService;
import com.soft1851.springboot.aop.util.ResponseBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: zw_w
 * @Date: 2020/4/14 11:53
 * @Description:
 */
@RestController
@RequestMapping(value = "/rolePermission")
public class RolePermissionController {

    @Resource
    private RolePermissionService service;

    @GetMapping("/admin")
    @AuthToken(role_name = "超级管理员")
    public ResponseBean selectAll(@Param("id") int id) {
        return ResponseBean.success(service.getAdminRolePermission());
    }

    @GetMapping("/sysAdmin")
    @AuthToken(role_name = {"超级管理员","系统管理员"})
    public ResponseBean getBySysId(@Param("id") int id) {
        return ResponseBean.success(service.getRolePermissionBySysAdmin(id));
    }

}