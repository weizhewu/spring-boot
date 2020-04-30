package com.soft1851.springboot.jwt.util;

import com.auth0.jwt.algorithms.Algorithm;

import java.io.UnsupportedEncodingException;
import java.util.UUID;

/**
 * @Author: zw_w
 * @Date: 2020/4/15 11:31
 * @Description:
 */
public class SaltUtil {
    /**
     * 生成32位的随机盐值
     */
    public static String createSalt(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }

    public static void main(String[] args){
        String mySecret = SaltUtil.createSalt();
        System.out.println("当前密钥为："+ mySecret);
    }
}
