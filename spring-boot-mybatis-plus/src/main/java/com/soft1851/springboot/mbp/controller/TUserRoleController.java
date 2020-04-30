package com.soft1851.springboot.mbp.controller;


import com.soft1851.springboot.mbp.mapper.TUserRoleMapper;
import com.soft1851.springboot.mbp.model.UserRole;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wzw
 * @since 2020-04-16
 */
@RestController
@RequestMapping("/tUserRole")
@ComponentScan("com.soft1851.springboot.mbp.controller")
public class TUserRoleController {
    @Resource
    private TUserRoleMapper mapper;
    @GetMapping("id")
    public List<UserRole> rolePermission(String userId){
        return mapper.getUserById(userId);
    }

}
