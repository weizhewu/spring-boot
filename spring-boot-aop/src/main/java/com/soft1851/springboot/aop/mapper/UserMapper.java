package com.soft1851.springboot.aop.mapper;


import com.soft1851.springboot.aop.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author ：wanghuanle
 * @date ：2020/4/7
 * @description：TODO
 */
public interface UserMapper {
    @Select("SELECT * FROM t_user")
    List<User> getUsers();

    @Select("SELECT * FROM t_user WHERE account = #{account} AND password =  #{password}")
    User login(String account,String password);
}
