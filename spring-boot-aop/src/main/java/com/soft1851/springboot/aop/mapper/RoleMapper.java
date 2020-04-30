package com.soft1851.springboot.aop.mapper;

import org.apache.ibatis.annotations.Select;

import java.util.Map;

/**
 * @Author: zw_w
 * @Date: 2020/4/14 10:39
 * @Description:
 */
public interface RoleMapper {
    @Select("SELECT * FROM t_role WHERE id=#{roleId}")
    Map<String, Object> getRoleById(int roleId);
}
