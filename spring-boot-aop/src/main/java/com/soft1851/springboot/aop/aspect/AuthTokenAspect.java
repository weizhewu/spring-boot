package com.soft1851.springboot.aop.aspect;

import com.soft1851.springboot.aop.annotation.AuthToken;
import com.soft1851.springboot.aop.entity.User;
import com.soft1851.springboot.aop.mapper.UserMapper;
import com.soft1851.springboot.aop.util.ResponseBean;
import com.soft1851.springboot.aop.util.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zw_w
 * @Date: 2020/4/13 15:40
 * @Description:
 */
@Aspect
@Component
@Slf4j
public class AuthTokenAspect {
    @Resource
    private UserMapper userMapper;

    /**
     * 配置加上自定义注解的方法位切点
     * @param authToken
     */
    @Pointcut("@annotation(authToken)")
    public void doAuthToken(AuthToken authToken) {
    }

    /**
     *环绕增强
     * Object 类型为controller中具体方法的类型
     */
    @Around(value = "doAuthToken(authToken)", argNames = "pjp,authToken")
    public Object doAround(ProceedingJoinPoint pjp, AuthToken authToken) throws Throwable {
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert sra != null;
        HttpServletRequest request = sra.getRequest();
        //取得注解中的role_name的值
        String[] roleNames = authToken.role_name();

        List<User> userList = userMapper.getUsers();
        List<String> users = new ArrayList<>();
        for (User user : userList){
            users.add(user.getAccount());
        }
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        User user = userMapper.login(account,password);
        //判断是否存在
        if (users.contains(account)){
            //判断密码
            if (user.getPassword() !=null){
                pjp.proceed();
            }
            return ResponseBean.failure(ResultCode.USER_PASSWORD_WRONG);

        }
        return ResponseBean.failure(ResultCode.USER_NOT_EXIST);

    }
}