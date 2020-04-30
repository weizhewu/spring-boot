package com.soft1851.springboot.aop.service;

import java.util.Map;

/**
 * @Author: zw_w
 * @Date: 2020/4/14 10:16
 * @Description:
 */
public interface UserService {

    Map<String,Object> signIn(String id, String password);

}
