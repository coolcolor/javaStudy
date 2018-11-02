package cn.cool.springboot.bean;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeAspect {
    @Around("execution(* cn.cool.springboot.controller.FastJsonController..*(..))")
    public Object method(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("aspect处理========");
        Object[] args = pjp.getArgs();
        for (Object arg : args) {
            System.out.println("参数是" + arg);
        }
        long timeMillis = System.currentTimeMillis();
        Object proceed = pjp.proceed();
        System.out.println("Aspect耗时" + (System.currentTimeMillis() - timeMillis));
        return proceed;
    }
}
