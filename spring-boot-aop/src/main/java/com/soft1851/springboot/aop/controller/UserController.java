package com.soft1851.springboot.aop.controller;

import com.soft1851.springboot.aop.annotation.AuthToken;
import com.soft1851.springboot.aop.mapper.UserMapper;
import com.soft1851.springboot.aop.service.UserService;
import com.soft1851.springboot.aop.util.ResponseBean;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Author wzw
 * @Description
 * @Date 2020/4/13
 */
@RestController
@Slf4j
public class UserController {
    private UserMapper userMapper;
    @Resource
    private UserService userService;

    /**
     * 无需任何校验，不用加注解
     * @param name
     * @return
     */
    @GetMapping("hello")
    @AuthToken(role_name={"admin"})
    public ResponseBean hello(String name) {
        log.info("hello()方法，无需鉴权，也无需认证，当前用户名：" + name);
        return ResponseBean.success();
    }

    /**
     * 需要登录认证，此时该方法需要加注解，但是不需要传角色
     * @param name
     * @return
     */
    @GetMapping("user")
    public ResponseBean user(String name) {
        log.info("user()方法需要认证，当前用户名：" + name);
        return ResponseBean.success();
    }

    /**
     * 需要鉴权，此时该方法需要加注解，需要传角色
     * 角色可以传多个
     * 如果需要更复杂得逻辑操作，建议使用Spring Security、Apache
     * @param name
     * @return
     */
    @GetMapping("admin")
    @AuthToken(role_name={"admin","Admin"})
    public ResponseBean admin(String name) {
        log.info("admin()方法需要鉴权，当前用户名：" + name);
        return ResponseBean.success();
    }


//    @GetMapping("login")
//    public ResponseBean login(String account,String password) {
//        log.info("admin()方法需要鉴权，当前用户名：" + account);
//        return ResponseBean.success();
//    }

    @PostMapping("login")
    public Map<String,Object> signIn(@Param("id") String id, @Param("password") String password) {
        return userService.signIn(id, password);
    }



}
