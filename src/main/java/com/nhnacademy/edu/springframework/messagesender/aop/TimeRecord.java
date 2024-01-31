package com.nhnacademy.edu.springframework.messagesender.aop;

import com.nhnacademy.edu.springframework.messagesender.user.User;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
@Slf4j
public class TimeRecord {

    @Pointcut("execution(* com.nhnacademy.edu.springframework.messagesender.MessageSenderService.doSendMessage(com.nhnacademy.edu.springframework.messagesender.user.User, java.lang.String))")
    public void messageSenderService(){}

    @Around("messageSenderService()")
    public Object doRecordStopWatch(ProceedingJoinPoint pjp)throws Throwable{
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object result = null;
        try{
            result = pjp.proceed();
        }catch (Exception e){
            throw new RuntimeException(e);
        }finally {
            stopWatch.stop();
            log.info("[{}].[{}] [{}]ms",pjp.getSignature().getDeclaringType(),pjp.getSignature().getName(),stopWatch.getTotalTimeMillis());
            // 메소드 실행 시간과 메소드 이름을 출력합니다.

        }
        return result;
    }
}
