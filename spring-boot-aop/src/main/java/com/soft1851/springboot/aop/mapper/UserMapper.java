package com.soft1851.springboot.aop.mapper;


import com.soft1851.springboot.aop.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

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

    @Select("SELECT t1.*,t3.`role_name`,t4.permission_id\n" +
            "FROM `t_user` t1\n" +
            "LEFT JOIN t_user_role t2\n" +
            "ON t1.id = t2.user_id\n" +
            "LEFT JOIN t_role t3\n" +
            "ON  t3.id = t2.user_id \n" +
            "LEFT JOIN t_role_permission t4\n" +
            "ON t4.role_id = t3.id\n" +
            "WHERE t1.id = #{userId}")
    Map<String,Object> getUserById(String userId);

    @Select("SELECT * FROM t_user WHERE id=#{userId}")
    User signIn(String userId);
}
