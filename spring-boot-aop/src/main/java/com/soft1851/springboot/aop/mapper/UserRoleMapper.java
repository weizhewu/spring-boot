package com.soft1851.springboot.aop.mapper;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

/**
 * @Author: zw_w
 * @Date: 2020/4/14 10:37
 * @Description:
 */
public interface UserRoleMapper {

    /**
     * 根据用户id查询该用户角色
     * @param userId
     * @return
     */
    @Results({
            @Result(property = "role", column = "role_id",
                    one=@One(select="com.soft1851.springboot.aop.mapper.RoleMapper.getRoleById")),
            @Result(property = "user", column = "user_id",
                    one=@One(select="com.soft1851.springboot.aop.mapper.UserMapper.getUserById"))
    })
    @Select("SELECT * FROM t_user_role WHERE user_id=#{userId}")
    Map<String,Object> getUserRole(String userId);
}

