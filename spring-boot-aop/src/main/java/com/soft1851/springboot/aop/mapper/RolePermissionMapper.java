package com.soft1851.springboot.aop.mapper;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @Author: zw_w
 * @Date: 2020/4/14 11:15
 * @Description:
 */
public interface RolePermissionMapper {

    /**
     * 根据role_id获得其对应权限
     * @param id int
     * @return List<Map<String, Object>>
     */
    @Results({
            @Result(property = "permission", column = "permission_id",
                    one=@One(select="com.soft1851.springboot.aop.mapper.PermissionMapper.getChildPermissionById")),
    })
    @Select("SELECT * FROM t_role_permission WHERE role_id=#{id}")
    List<Map<String, Object>> getRoleById(int id);

}
