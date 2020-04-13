package com.soft1851.springboot.aop.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author yhChen
 * @Description
 * @Date 2020/4/12
 */
@RestController
@RequestMapping(value = "/hello")
public class HelloControllerMvc {
    @RequestMapping
    public String hello(String name) {
        return "Hello " + name;
    }
}
