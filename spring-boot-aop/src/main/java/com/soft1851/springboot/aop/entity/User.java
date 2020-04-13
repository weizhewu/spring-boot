package com.soft1851.springboot.aop.entity;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

/**
 * @author ：wzw
 * @date ：2020/4/7
 * @description：TODO
 */
@Data
@Builder
public class User {
    private Integer userId;
    private String account;
    private String password;
    private String root;

}
