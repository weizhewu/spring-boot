package com.soft1851.springboot.jwt.interceptor;

import com.auth0.jwt.exceptions.InvalidClaimException;
import com.soft1851.springboot.jwt.common.ResultCode;
import com.soft1851.springboot.jwt.exception.JwtException;
import com.soft1851.springboot.jwt.service.AdminService;
import com.soft1851.springboot.jwt.util.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: zw_w
 * @Description: JWT拦截器
 */
@Slf4j
@Component
public class JwtInterceptor implements HandlerInterceptor {
    @Resource
    private AdminService adminService;

    /**
     * 前置处理，拦截请求
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");
        if (token == null) {
            log.info("### 用户未登录，请先登录 ###");
            throw new JwtException("用户未登录，请先登录", ResultCode.USER_NOT_SIGN_IN);
        } else { //已经登录
            log.info("## token={}",token);
            //鉴权
            if (!adminService.checkRole(JwtTokenUtil.getUserRole(token))){
                log.info("### 用户权限不足 ###");
                //通过自定义异常抛出权限不足的信息，由全局统一处理
                throw new JwtException("用户权限不足",ResultCode.PERMISSION_NO_ACCESS);
            } else {
                if (JwtTokenUtil.isExpiration(token)){
                    log.info("### token已失效 ###");
                    //通过自定义异常抛出token时效的信息，由全局统一处理
                    throw new InvalidClaimException("token已失效");
                } else {
                    //之前的拦截全部通过，放行到controller层调用接口
                    return true;
                }
            }

        }
    }

}
