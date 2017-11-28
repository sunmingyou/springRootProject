package com.icolor.StudySpringBoot.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created by admin on 2017/11/1.
 */
@Aspect
@Component
public class TimeAspect {

    @Around("execution(* com.icolor.StudySpringBoot.controller.UserController.getAll(..))")
    public  Object handleMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{

            System.out.println("time aspect start");
            Object[]args=proceedingJoinPoint.getArgs();
            for (Object o:args){
                System.out.println(" arg is "+o);
            }
         Object retObj=proceedingJoinPoint.proceed();
        System.out.println("time aspect end");
        return retObj;
    }
}
