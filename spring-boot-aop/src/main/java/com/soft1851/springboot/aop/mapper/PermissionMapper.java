package com.soft1851.springboot.aop.mapper;

import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @Author: zw_w
 * @Date: 2020/4/14 11:18
 * @Description:
 */
public interface PermissionMapper {

    /**
     * 根据资源id查询资源及子类资源
     * @param id
     * @return
     */
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "subList", column = "id",
                    many=@Many(select="com.soft1851.springboot.aop.mapper.PermissionMapper.getPermissionByParentId")),
    })
    @Select("SELECT * FROM t_permission WHERE id=#{id}")
    Map<String, Object> getChildPermissionById(String id);

    /**
     * 根据父类id查询子类资源
     * @param parentId
     * @return
     */
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "subList", column = "id",
                    one=@One(select="com.soft1851.springboot.aop.mapper.PermissionMapper.getPermissionByParentId")),
    })
    @Select("SELECT * FROM t_permission WHERE parent_id=#{parentId}")
    List<Map<String, Object>> getPermissionByParentId(int parentId);

    /**
     * 获取页面资源及其所拥有的子类资源
     * @return
     */
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "subList", column = "id",
                    many=@Many(select="com.soft1851.springboot.aop.mapper.PermissionMapper.getPermissionByParentId")),
    })
    @Select("SELECT * FROM t_permission WHERE parent_id = 0")
    List<Map<String, Object>> getParentPermission();
}
