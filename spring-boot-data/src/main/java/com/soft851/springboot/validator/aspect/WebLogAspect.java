package com.soft851.springboot.validator.aspect;

import com.soft851.springboot.validator.annotation.ControllerWebLog;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
@Order(1)
@Slf4j
public class WebLogAspect {
    private ThreadLocal<Map<String,Object>> threadLocal = new ThreadLocal<>();
    @Pointcut("execution(public * com.soft851.springboot.validator.controller..*.*(..))")
    public void webLog() {

    }

    /**
     * 前置增强
     * @param joinPoint
     * @param controllerWebLog
     */
    @Before(value = "webLog() && @annotation(controllerWebLog)")
    public void doBefore(JoinPoint joinPoint, ControllerWebLog controllerWebLog) {
        RequestAttributes at = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) at;
        assert sra != null;
        HttpServletRequest request = sra.getRequest();
        log.info("请求URI:"+ request.getRequestURI());
        log.info("请求URL:"+ request.getRequestURL());
        log.info("请求头的User-Agent:"+ request.getHeader("User-Agent"));
        log.info("请求方法:"+ request.getMethod());
        log.info("请求地址:"+ request.getRemoteAddr());
        log.info("连接点对象通过反射获得类名和方法名" +joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        log.info("AOP拦截获得参数：" + Arrays.toString(joinPoint.getArgs()));
        log.info("执行方法：" + controllerWebLog.name());
        Map<String,Object> map = new HashMap<>(16);
        map.put("uri",request.getRequestURI());
        map.put("url",request.getRequestURL());
        map.put("user-agent",request.getHeader("User-Agent"));
        map.put("request-method",request.getMethod());
        map.put("remote-address",request.getRemoteAddr());
        map.put("class-method",joinPoint.getSignature().getDeclaringTypeName() + "." +joinPoint.getSignature().getName());
        map.put("arguments",Arrays.toString(joinPoint.getArgs()));
        map.put("execute-method",controllerWebLog.name());
        threadLocal.set(map);
    }

    /**
     * 执行成功后处理
     * @param controllerWebLog
     * @param ret
     * @throws Throwable
     */
    @AfterReturning(value = "webLog() && @annotation(controllerWebLog)",returning = "ret")
    public void doAfterReturning(ControllerWebLog controllerWebLog,Object ret) throws Throwable {
        Map<String,Object> threadInfo = threadLocal.get();
        threadInfo.put("result",ret);
        if (controllerWebLog.isSaved()) {
            log.info("日至已存入数据库");
        }
        log.info("RESPONSE:" + ret);
    }
    @Around(value = "webLog()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object ob = proceedingJoinPoint.proceed();
        Map<String,Object> threadInfo = threadLocal.get();
        Long takeTime = System.currentTimeMillis() - startTime;
        threadInfo.put("takeTime",takeTime);
        log.info("耗时：" + takeTime);
        threadLocal.set(threadInfo);
        return ob;
    }

    /**
     * 异常处理
     * @param throwable
     */
    @AfterThrowing(value = "webLog()",throwing = "throwable")
    public void doAfterThrowing(Throwable throwable) {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        assert sra != null;
        HttpServletRequest request = sra.getRequest();
        log.info("{}接口调用异常，异常信息{}",request.getRequestURI(),throwable);
    }
}
