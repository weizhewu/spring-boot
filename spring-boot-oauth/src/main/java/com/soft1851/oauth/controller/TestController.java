package com.soft1851.oauth.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zw_w
 * @Date: 2020/4/29 11:05
 * @Description:
 */
@RestController
public class TestController {
    @RequestMapping("/index")
    public String simpleIndex(ModelMap map){
        return "index";
    }
}
