package com.soft1851.springboot.aop.aspect;

import com.soft1851.springboot.aop.annotation.AuthToken;

import com.soft1851.springboot.aop.mapper.UserMapper;
import com.soft1851.springboot.aop.util.ResponseBean;
import com.soft1851.springboot.aop.util.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Map;

/**
 * @Description TODO
 * @Author wzw
 * @Date 2020/4/13
 */
@Aspect
@Component
@Slf4j
public class AuthTokenAspect {
    @Resource
    private UserMapper mapper;

    private ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal<>();

    /**
     * 配置加上自定义注解的方法为切点
     * @param authToken
     */
    @Pointcut("@annotation(authToken)")
    public void doAuthToken(AuthToken authToken) {
    }

    @Pointcut("execution(public * com.soft1851.springboot.aop.controller..*.*(..))")
    public void webLog(){
    }
    /**
     * object是指controller方法返回的类型
     */
    @Around(value = "doAuthToken(authToken)", argNames = "pjp,authToken")
    public Object doAround(ProceedingJoinPoint pjp,AuthToken authToken) throws Throwable{
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert sra != null;
        HttpServletRequest request = sra.getRequest();
        // 取得注解中的role_name的值
        String[] roleNames = authToken.role_name();
        //没有role的值
        if (roleNames.length <= 1) {
            // 只需认证
            String token = request.getHeader("token");
            String id = request.getParameter("id");
            Map<String, Object> map = mapper.getUserById(id);
            // 如果id为空， 证明用户没有登录
            if (token != null && roleNames[0].equals(map.get("role_name"))) {
                // 返回controller方法的值
                return pjp.proceed();
            }
            return ResponseBean.failure(ResultCode.USER_NOT_LOGIN);
        }else {
            // 请求头中取出role，验证身份
            String id = request.getParameter("id");
            Map<String, Object> map = mapper.getUserById(id);
            if ( Arrays.asList(roleNames).contains(map.get("role_name"))){
                // 身份匹配成功
                return pjp.proceed();
            }
            return ResponseBean.failure(ResultCode.USER_NOT_ACCESS);
        }

    }
}
