package com.soft1851.springboot.mbp.mapper;

import com.soft1851.springboot.mbp.model.UserRole;

import java.util.List;

/**
 * @Author: zw_w
 * @Date: 2020/4/16 14:51
 * @Description:
 */
public interface UserRoleMapper {
    /**
     * 根据id查询用户的所有权限
     * @param id
     * @return
     */
    List<UserRole> getUserById(String id);
}
