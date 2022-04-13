package com.cshbxy.demo3;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class XmlAdvice {
    // 前置通知
    public void before(JoinPoint joinPoint) {
        System.out.print("这是前置通知！");
        System.out.print("目标类是：" + joinPoint.getTarget());
        System.out.println("，被织入增强处理的目标方法为：" + joinPoint.getSignature().getName());
    }

    public void afterReturning(JoinPoint joinPoint) {
        System.out.print("这是返回通知（方法不出现异常时调用）！");
        System.out.println("被织入增强处理的目标方法为：" + joinPoint.getSignature().getName());
    }

    /**
     * 环绕通知
     * ProceedingJoinPoint是JoinPoint的子接口，表示可以执行目标方法
     * 1.必须是Object类型的返回值
     * 2.必须接收一个参数，且为ProceedingJoinPoint类型
     * 3.必须throws Throwable
     */
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("这是环绕通知之前的部分！");
        // 调用目标方法
        Object object = proceedingJoinPoint.proceed();
        System.out.println("这是环绕通知之后的部分！");
        return object;
    }

    // 异常通知
    public void afterException(JoinPoint joinPoint) {
        System.out.print("这是异常通知！");
    }

    // 后置通知
    public void after(JoinPoint joinPoint) {
        System.out.print("这是后置通知！");
    }
}
