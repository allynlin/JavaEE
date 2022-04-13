package com.cshbxy.demo4;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class AnnoAdvice {
    // 切点
    @Pointcut("execution(* com.cshbxy.demo3.UserDaoImpl.*(..))")
    public void pointcut() {
    }

    // 前置通知
    @Before("pointcut()")
    public void before(JoinPoint joinPoint) {
        System.out.print("这是前置通知！");
        System.out.print("目标类是：" + joinPoint.getTarget());
        System.out.println("，被织入增强处理的目标方法为：" + joinPoint.getSignature().getName());
    }

    // 返回通知
    @AfterReturning("pointcut()")
    public void afterReturning(JoinPoint joinPoint) {
        System.out.print("这是返回通知！");
        System.out.println("被织入增强处理的目标方法是：" + joinPoint.getSignature().getName());
    }

    // 环绕通知
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint Point) throws Throwable {
        System.out.println("这是环绕通知之前的部分");
        // 调用目标方法
        Object object = Point.proceed();
        System.out.println("这是环绕通知之后的部分");
        return object;
    }

    // 异常通知
    @AfterThrowing("pointcut()")
    public void afterException() {
        System.out.println("这是异常通知");
    }

    // 后置通知
    @After("pointcut()")
    public void after() {
        System.out.println("这是后置通知");
    }
}
