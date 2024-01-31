package com.nhnacademy.edu.springframework.messagesender.aop;

import com.nhnacademy.edu.springframework.messagesender.user.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class TimeRecord {
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
            System.out.println(stopWatch.prettyPrint());
            // 메소드 실행 시간과 메소드 이름을 출력합니다.

        }
        return result;
    }
}
