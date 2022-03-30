package com.example.demo.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SysLog {
    private Logger logger = LoggerFactory.getLogger(SysLog.class);

    // 定义切点
    // @Pointcut("execution(* com.example.demo1.controller.*.*(..))")
    @Pointcut("@annotation(com.example.demo.common.Log)")
    public void logPointCut() {
    }

    // 定义通知
    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        String className = pjp.getTarget().getClass().toString();
        String methodName = pjp.getSignature().getName();
        Object[] arr = pjp.getArgs();

        ObjectMapper mapper = new ObjectMapper();

        logger.info("before exec, " + className + ":" + methodName + " 参数:" + mapper.writeValueAsString(arr));
        // 目标方法
        Object obj = pjp.proceed();
        logger.info("after exec, " + className + ":" + methodName + " 返回值:" + mapper.writeValueAsString(obj));

        return obj;
    }
}
