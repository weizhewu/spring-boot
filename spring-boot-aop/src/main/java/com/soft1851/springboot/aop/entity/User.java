package com.soft1851.springboot.aop.entity;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

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
    private String avatar;
    private String name;
    private Date createTime;
    private String roleName;


}
