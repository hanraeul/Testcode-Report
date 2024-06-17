package com.sparta.lck_news.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.aspectj.lang.JoinPoint;

@Aspect
@Component
@Slf4j
public class LoggingAop {

    @Before("execution(* com.sparta.lck_news.controller..*(..))")
    public void logBefore(JoinPoint joinPoint) {
        log.info("Request URL: {}", joinPoint.getSignature().toShortString());
        log.info("HTTP Method: {}", joinPoint.getSignature().getDeclaringTypeName());
    }
}