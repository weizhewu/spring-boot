package com.soft1851.springboot.mbp.mapper;

import com.soft1851.springboot.mbp.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 * @Author: zw_w
 * @Date: 2020/4/16 9:05
 * @Description:
 */
@SpringBootTest
class UserMapperTest {
    @Resource
    private UserMapper userMapper;

    @Test
    void selectAll(){
        List<User> list = userMapper.selectList(null);
        list.forEach(System.out::println);
    }

    @Test
    void insert(){
        User user = User.builder()
                .binding(1)
                .createTime(new Timestamp(new Date().getTime()))
                .credits(2)
                .email("1")
                .lastLoginTime(new Timestamp(new Date().getTime()))
                .name("1")
                .password("1")
                .phoneNumber("1")
                .salt("2")
                .status(1)
                .build();
        System.out.println(userMapper.insert(user));
    }

    @Test
    void deleteById(){
        System.out.println(userMapper.deleteById(6));
    }

    @Test
    void updateById(){
        User user = User.builder()
                .Id(6)
                .binding(1)
                .createTime(new Timestamp(new Date().getTime()))
                .credits(1)
                .email("test")
                .lastLoginTime(new Timestamp(new Date().getTime()))
                .name("test")
                .password("test")
                .phoneNumber("test")
                .salt("test")
                .status(1)
                .build();
        userMapper.updateById(user);
    }
    @Test
    void selectById(){
        System.out.println(userMapper.selectById(1));
    }

}