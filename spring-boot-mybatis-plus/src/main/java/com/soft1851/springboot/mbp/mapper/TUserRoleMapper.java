package com.soft1851.springboot.mbp.mapper;

import com.soft1851.springboot.mbp.entity.TUserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.soft1851.springboot.mbp.model.UserRole;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wzw
 * @since 2020-04-16
 */
public interface TUserRoleMapper{
    /**
     * 根据id查询用户的所有权限
     * @param id
     * @return
     */
    List<UserRole> getUserById(String id);

}
