package com.soft1851.springboot.mbp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;

/**
 * @Author: zw_w
 * @Date: 2020/4/16 9:02
 * @Description:
 */
@Data
@Builder
public class User {
    private Integer Id;
    private String name;
    private String password;
    private String salt;
    private String email;
    private String phoneNumber;
    private Integer status;
    private Integer binding;
    private Integer credits;
    private Timestamp createTime;
    private Timestamp lastLoginTime;
}
