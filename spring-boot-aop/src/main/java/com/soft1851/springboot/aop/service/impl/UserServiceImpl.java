package com.soft1851.springboot.aop.service.impl;

import com.soft1851.springboot.aop.entity.User;
import com.soft1851.springboot.aop.mapper.UserMapper;
import com.soft1851.springboot.aop.mapper.UserRoleMapper;
import com.soft1851.springboot.aop.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zw_w
 * @Date: 2020/4/14 10:20
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private UserRoleMapper userRoleMapper;

    @Override
    public Map<String, Object> signIn(String id, String password) {
        User user = userMapper.signIn(id);
        Map<String,Object> map = new HashMap<>();
        if (user != null && user.getPassword().equals(password)){
            map = userRoleMapper.getUserRole(id);
            if (map!=null){
                return map;
            }
        }
        map.put("msg","账号密码错误");
        return map;
    }
}
